package commands;

/**
 * A class for commandUtils.
 */
public class CommandUtil {
  /**
   * A method to clamp an integer to the range 0-255
   * otherwise known as an 8 bit value.
   * @param val the value to clamp
   * @return the value clamped to 8 bit.
   */
  public static int clampTo8Bit(int val) {
    return Math.max(0, Math.min(255, val));
  }
}
