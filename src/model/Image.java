package model;

/**
 * A class to represent an Image.
 */
public class Image implements IImage {
  private final Color[][] pixels;
  private final int width;
  private final int height;
  private final int maxValue;

  /**
   * A constructor for an Image.
   *
   * @param pixels   the array of rgb values.
   * @param width    the width of the image.
   * @param height   the height of the image.
   * @param maxValue the maxValue of an individual component in an image.
   */
  public Image(Color[][] pixels, int width, int height, int maxValue) {
    this.pixels = pixels;
    this.width = width;
    this.height = height;
    this.maxValue = maxValue;
  }

  /**
   * Retrieves the width of the image.
   *
   * @return the width of the image
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Retrieves the height of the image.
   *
   * @return the height of the image
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Retrieves the maximum value of the image.
   *
   * @return the maximum value of the image.
   */
  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

  /**
   * Retrieves the 2D array of pixels of the image.
   *
   * @return the pixels of the image
   */
  public Color[][] getPixels() {
    Color[][] copy = new Color[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        copy[i][j] = new Color(this.pixels[i][j].getRed(),
                this.pixels[i][j].getGreen(), this.pixels[i][j].getBlue());
      }
    }
    return copy;
  }
}
