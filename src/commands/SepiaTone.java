package commands;

import model.Color;

/**
 * A class to represent the sepia tone of an image.
 */
public class SepiaTone extends Transform {
  /**
   * A constructor that calls the super with the matrix for a sepia tone.
   */
  public SepiaTone() {
    super(new double[][]{{0.393, 0.769, 0.189},
                         {0.349, 0.686, 0.168},
                         {0.272, 0.534, 0.131}});
  }

  /**
   * Gets the modified pixel when given the unmodified pixel.
   *
   * @param pixels the array of pixels.
   * @param height the height of the image.
   * @param width the width of the image.
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
