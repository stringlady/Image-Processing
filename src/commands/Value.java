package commands;

import model.Color;

/**
 * A class to represent the value gray scale command.
 */
public class Value extends AbstractCommand {
  /**
   * Applies the value gray scale on a given pixel.
   *
   * @param pixels the array of pixels.
   * @param i the current row position.
   * @param j the current column position.
   * @return the modified pixel.
   */
  @Override
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    Color c = pixels[i][j];
    int max = Math.max(c.getRed(), Math.max(c.getBlue(), c.getGreen()));
    return new Color(max, max, max);
  }

  @Override
  public String toString() {
    return "grayscale-value";
  }

}
