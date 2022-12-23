package commands;

import model.Color;

/**
 * A class to represent the sharpen command for an image.
 */
public class Sharpen extends Filter {

  /**
   * A constructor that calls super with the matrix for the sharpen command.
   */
  public Sharpen() {
    super(new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
                         {-0.125, 0.25, 0.25, 0.25, -0.125},
                         {-0.125, 0.25, 1, 0.25, -0.125},
                         {-0.125, 0.25, 0.25, 0.25, -0.125},
                         {-0.125, -0.125, -0.125, -0.125, -0.125}});
  }

  /**
   * Gets the modified pixel when given the unmodified pixel.
   *
   * @param pixels the array of pixels.
   * @param i      the row to operate on.
   * @param j      the column to operate on.
   * @return the modified pixel.
   */
  @Override
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    this.filter(pixels, height, width, i, j, Channel.RED);
    this.filter(pixels, height, width, i, j, Channel.GREEN);
    this.filter(pixels, height, width, i, j, Channel.BLUE);
    return pixels[i][j];
  }

  @Override
  public String toString() {
    return "sharpen";
  }
}
