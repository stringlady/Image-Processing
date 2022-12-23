package commands;

import model.Color;

/**
 * A class to represent the blue grayscale command.
 */
public class BlueGrayscale extends AbstractCommand {
  /**
   * Gets the pixel with all values set to the blue color.
   *
   * @param pixels the array of pixels.
   * @param i the current row position.
   * @param j the current column position.
   * @return the modified pixel.
   */
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    Color c = pixels[i][j];
    return new Color(c.getBlue(), c.getBlue(), c.getBlue());
  }

  @Override
  public String toString() {
    return "grayscale-blue";
  }

}
