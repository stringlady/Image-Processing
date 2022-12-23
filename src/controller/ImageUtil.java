package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import model.Color;
import model.IImage;
import model.Image;


/**
 * This class contains utility methods to read a PPM image, scanning its contents into
 * an Image object. It also contains a utility method to save a PPM image by giving any
 * output stream.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and move
   * relevant contents into image Object.
   *
   * @param filename the path of the file.
   * @return the Image representation of the file.
   */
  public static IImage readPPM(String filename) throws IllegalArgumentException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException(filename + " is not accessible or does not exist.");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());
    String token;
    token = sc.next();
    if (!token.equals("P3")) {
      return null;
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    Color[][] pixels = new Color[height][width];
    for (int i = 0; i < height; i++) { // height, width
      for (int j = 0; j < width; j++) { // row, col
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixels[i][j] = new Color(r, g, b);
      }
    }
    return new Image(pixels, width, height, maxValue);
  }

  /**
   * Decodes an image from the conventional file formats: png, bmp, jpg...
   *
   * @param filename the filename of the file to decode.
   * @return the image saved
   * @throws IllegalArgumentException if the image cannot be decoded.
   */
  public static IImage decodeImage(String filename) throws IllegalArgumentException {

    BufferedImage image;
    try {
      image = ImageIO.read(new File(filename));
    } catch (IOException e) {
      throw new IllegalArgumentException(filename + "is not accessible or does not exist.");
    }

    int height = image.getHeight();
    int width = image.getWidth();
    Color[][] pixels = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        java.awt.Color c = new java.awt.Color(image.getRGB(j, i));
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        pixels[i][j] = new Color(r, g, b);
      }
    }

    return new Image(pixels, width, height, 255);
  }

  /**
   * Saves a file to a specified output with the specified format type.
   * @param image the image to save
   * @param formatName the format type to save to.
   * @param out the output stream to push data to.
   */
  public static void encodeImage(IImage image, String formatName, FileOutputStream out) {
    Color[][] pixels = image.getPixels();
    int height = image.getHeight();
    int width = image.getWidth();
    BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Color c = pixels[i][j];
        im.setRGB(j, i, new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue()).getRGB());
      }
    }
    try {
      ImageIO.write(im, formatName, out);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public static BufferedImage toBufferedImage(IImage image) {
    Color[][] pixels = image.getPixels();
    int height = image.getHeight();
    int width = image.getWidth();
    BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Color c = pixels[i][j];
        im.setRGB(j, i, new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue()).getRGB());
      }
    }
    return im;
  }

  /**
   * takes the image given to it and saves it to the given file output stream.
   *
   * @param image the image to save.
   * @param out   the stream to save the image to.
   * @throws IOException if the file cannot be written.
   */
  public static void savePPM(IImage image, FileOutputStream out) throws IOException {
    StringBuilder file = new StringBuilder();
    file.append("P3\n").append(image.getWidth()).append("\n").append(image.getHeight()).append(
            "\n255\n");
    Color[][] imagePixels = image.getPixels();
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Color c = imagePixels[i][j];
        file.append(c.getRed()).append(" ").append(c.getGreen()).
                append(" ").append(c.getBlue()).append("  ");
      }
      file.append("\n");
    }
    out.write(file.toString().getBytes());
    out.flush();
    out.close();
  }
}

