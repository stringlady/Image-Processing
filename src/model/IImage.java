package model;

/**
 * A class to represent the interface for an Image.
 */
public interface IImage {
  /**
   * Retrieves the 2D array of pixels of the image.
   * @return the pixels of the image
   */
  public Color[][] getPixels();

  /**
   * Retrieves the width of the image.
   * @return the width of the image
   */
  public int getWidth();

  /**
   * Retrieves the height of the image.
   * @return the height of the image.
   */
  public int getHeight();

  /**
   * Retrieves the maximum value of the image.
   * @return the maximum value of the image.
   */
  public int getMaxValue();


}
