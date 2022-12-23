package commands;

import model.Color;

/**
 * This class will implement that brighten command for the Image Model.
 */
public class Brighten extends AbstractCommand {

  private final int constant;

  /**
   * This constructor takes the parameters of the original method in the model.
   * @param constant how much should we increment the brightness
   */
  public Brighten(int constant) {
    this.constant = constant;
  }

  /**
   * Gets the pixels brightened by the constant.
   *
   * @param pixels the array of pixels.
   * @param i the current row position.
   * @param j the current column position.
   * @return the modified pixel.
   */
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    Color c = pixels[i][j];
    int r = c.getRed() + this.constant;
    int g = c.getGreen() + this.constant;
    int b = c.getBlue() + this.constant;
    return new Color(Math.max(0, Math.min(r, 255)),
            Math.max(0, Math.min(g, 255)), Math.max(0, Math.min(b, 255)));
  }

  @Override
  public String toString() {
    return "brighten";
  }

}
