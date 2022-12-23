package commands;

import model.Color;

/**
 * A class to represent the luma gray scale operation.
 */
public class Luma extends AbstractCommand {
  /**
   * Retrieves the modified pixel that applies the luma gray scale to it.
   *
   * @param pixels the array of pixels.
   * @param i the current row position.
   * @param j the current column position.
   * @return the modified pixel.
   */
  @Override
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    Color c = pixels[i][j];
    int luma = (int) ((double) c.getRed() * 0.2126 +
            (double) c.getGreen() * 0.7152 + (double) c.getBlue() * 0.0722);
    return new Color(luma, luma, luma);
  }

  @Override
  public String toString() {
    return "grayscale-luma";
  }
}
