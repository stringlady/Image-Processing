package commands;

import model.Color;

/**
 * Represents a green grayscale operation.
 */
public class GreenGrayscale extends AbstractCommand {
  /**
   * Gets the modified pixel when given the original pixel.
   *
   * @param pixels the array of pixels.
   * @param i the current row position.
   * @param j the current column position.
   * @return the modified pixel.
   */
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    Color c = pixels[i][j];
    return new Color(c.getGreen(), c.getGreen(), c.getGreen());
  }

  @Override
  public String toString() {
    return "grayscale-green";
  }
}
