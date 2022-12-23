import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import commands.Brighten;
import model.Color;
import model.IColor;
import model.IImage;
import model.IImageAppModel;
import model.Image;
import model.ImageAppModel;

import static org.junit.Assert.assertEquals;

/**
 * This is the testing class for all the methods in the ImageAppModel, including
 * Color and Image.
 */
public class ImageModelTest {
  /**
   * This tests the getImage() method.
   */
  @Test
  public void testGetImage() {
    Color[][] pixels = new Color[3][3];
    IImageAppModel model = new ImageAppModel();
    IImage image1 = new Image(pixels, 5, 5, 255);
    IImage image2 = new Image(pixels, 4, 6, 255);
    IImage image3 = new Image(pixels, 25, 60, 255);
    model.putImage("image1", image1);
    model.putImage("image2", image2);
    model.putImage("image3", image3);
    assertEquals(image1, model.getImage("image1"));
    assertEquals(image2, model.getImage("image2"));
    assertEquals(image3, model.getImage("image3"));
  }

  /**
   * This tests the putImage() method.
   */
  @Test
  public void testPutImage() {
    Map<String, IImage> loaded = new HashMap<>();
    Color[][] pixels = new Color[3][3];
    IImageAppModel model = new ImageAppModel();
    IImage image1 = new Image(pixels, 5, 5, 255);
    IImage image2 = new Image(pixels, 4, 6, 255);
    IImage image3 = new Image(pixels, 25, 60, 255);
    model.putImage("image1", image1);
    model.putImage("image2", image2);
    model.putImage("image3", image3);
    loaded.put("image1", image1);
    loaded.put("image2", image2);
    loaded.put("image3", image3);
    assertEquals(loaded.get("image1"), model.getImage("image1"));
    assertEquals(loaded.get("image2"), model.getImage("image2"));
    assertEquals(loaded.get("image3"), model.getImage("image3"));
  }

  /**
   * This tests the acceptCommand() method.
   */
  @Test
  public void testAcceptCommand() {
    Random rand = new Random();
    Color[][] pixels = new Color[3][3];
    Color[][] bPixels = new Color[3][3];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        pixels[r][c] = new Color(5, 5, 5);
      }
    }
    for (int r = 0; r < bPixels.length; r++) {
      for (int c = 0; c < bPixels.length; c++) {
        bPixels[r][c] = new Color(10, 10, 10);
      }
    }
    IImageAppModel model = new ImageAppModel();
    IImage image1 = new Image(pixels, 3, 3, 255);
    IImage bImage1 = new Image(bPixels, 3, 3, 255);
    model.putImage("image1", image1);
    model.acceptCommand(new Brighten(5), "image1", "bImage1");
    assertEquals(bImage1.getPixels(), model.getImage("bImage1").getPixels());
  }

  /**
   * This test if acceptCommand will throw an IllegalStateException if the
   * image is not present in the map.
   */
  @Test(expected = IllegalStateException.class)
  public void testACIllegalArgument() {
    IImageAppModel model = new ImageAppModel();
    model.acceptCommand(new Brighten(5), "image2", "bImage2");
  }

  /**
   * This test whether the color will accurately get all the corresponding red, green, and blue
   * colors.
   */
  @Test
  public void testGetColors() {
    IColor color = new Color(10, 25, 14);
    assertEquals(10, color.getRed());
    assertEquals(25, color.getGreen());
    assertEquals(14, color.getBlue());
  }

  /**
   * This tests whether the constructor will throw an IllegalArgumentException if any of the
   * values are negative or larger than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument() {
    IColor c1 = new Color(-1, 55, 90);
    IColor c2 = new Color(700, 55, 90);
    IColor c3 = new Color(65, -87, 90);
    IColor c4 = new Color(65, 290, 90);
    IColor c5 = new Color(78, 55, -78);
    IColor c6 = new Color(63, 55, 345);
  }

  /**
   * This test the getPixels method by checking in on random individual units in the array.
   */
  @Test
  public void testGetPixels() {
    Random rand = new Random();
    Color[][] pixels = new Color[10][10];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        pixels[r][c] = new Color(rand.nextInt(255), rand.nextInt(255),
                rand.nextInt(255));
      }
    }
    IImage image = new Image(pixels, 10, 10, 255);
    assertEquals(pixels[1][1], image.getPixels()[1][1]);
    assertEquals(pixels[3][5], image.getPixels()[3][5]);
    assertEquals(pixels[0][5], image.getPixels()[0][5]);
  }

  /**
   * This tests the accuracy in both the getWidth and getHeight methods.
   */
  @Test
  public void testGetWandH() {
    Random rand = new Random();
    Color[][] pixels = new Color[10][10];
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels.length; c++) {
        pixels[r][c] = new Color(rand.nextInt(255), rand.nextInt(255),
                rand.nextInt(255));
      }
    }
    IImage image = new Image(pixels, 10, 10, 255);
    assertEquals(10, image.getWidth());
    assertEquals(10, image.getHeight());
  }
}