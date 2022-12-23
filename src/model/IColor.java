package model;

/**
 * An interface to represent a simple pixel or color
 * with r, g, and b values.
 */
public interface IColor {
  /**
   * Method to retrieve the red component.
   *
   * @return the red component.
   */
  public int getRed();

  /**
   * Method to retrieve the green component.
   *
   * @return the green component.
   */
  public int getGreen();

  /**
   * Method to retrieve the blue component.
   *
   * @return the blue component.
   */
  public int getBlue();
}
