package commands;

import model.Color;

/**
 * A class to represent a red gray scale operation.
 */
public class RedGrayscale extends AbstractCommand {
  /**
   * Retrieves the pixel with all rgb values changed to the red component.
   *
   * @param pixels the array of pixels.
   * @param i the current row position.
   * @param j the current column position.
   * @return the modified pixel.
   */
  @Override
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    Color c = pixels[i][j];
    return new Color(c.getRed(), c.getRed(), c.getRed());
  }

  @Override
  public String toString() {
    return "grayscale-red";
  }
}
