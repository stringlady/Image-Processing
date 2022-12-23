package commands;

import model.Color;

/**
 * A class to represent the intensity grayscale operation.
 */
public class Intensity extends AbstractCommand {
  /**
   * Gray scales the pixel to be the average of all components.
   *
   * @param pixels the array of pixels.
   * @param i the current row position.
   * @param j the current column position.
   * @return the modified pixel.
   */
  @Override
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    Color c = pixels[i][j];
    int avg = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
    return new Color(avg, avg, avg);
  }

  @Override
  public String toString() {
    return "grayscale-intensity";
  }
}
