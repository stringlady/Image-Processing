package model;

import java.util.Objects;

/**
 * A class to represent a pixel or Color containing
 * a simple r,g,b color model.
 */
public class Color implements IColor {
  private final int r;
  private final int g;
  private final int b;

  /**
   * Constructor for a color object.
   *
   * @param r the red component
   * @param g the green component.
   * @param b the blue component.
   *          Will throw an IllegalArgumentException if any values are negative or above 255.
   */
  public Color(int r, int g, int b) {
    if (r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0) {
      throw new IllegalArgumentException("values must be in the range(0, 255)");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Method to retrieve the red component.
   *
   * @return the red component.
   */
  @Override
  public int getRed() {
    return this.r;
  }

  /**
   * Method to retrieve the green component.
   *
   * @return the green component.
   */
  @Override
  public int getGreen() {
    return this.g;
  }

  /**
   * Method to retrieve the blue component.
   *
   * @return the blue component.
   */
  @Override
  public int getBlue() {
    return this.b;
  }

  /**
   * Override for the toString method to display the r,g,b components.
   *
   * @return a string containing the r, g, and b values.
   */
  @Override
  public String toString() {
    return this.r + " " + this.g + " " + this.b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Color)) {
      return false;
    }

    Color other = (Color) o;

    return this.r == other.getRed() && this.g == other.getGreen() && this.b == other.getBlue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(r, g, b);
  }
}
