package commands;

import model.Color;

/**
 * A class to represent the grayscale command using matrix multiplication.
 */
public class Grayscale extends Transform {
  /**
   * A constructor for the grayscale, passing in the correct
   * matrix to be applied.
   */
  public Grayscale() {
    super(new double[][]{{0.2126, 0.7152, 0.0722},
                         {0.2126, 0.7152, 0.0722},
                         {0.2126, 0.7152, 0.0722}});
  }

  /**
   * Gets the modified pixel when given the unmodified pixel.
   *
   * @param pixels the array of pixels.
   * @param height the height of the image.
   * @param width  the width of the image.
   * @param i      the row to operate on.
   * @param j      the column to operate on
   * @return the modified pixel.
   */
  @Override
  protected Color getPixel(Color[][] pixels, int height, int width, int i, int j) {
    this.transform(pixels, i, j);
    return pixels[i][j];
  }
}
