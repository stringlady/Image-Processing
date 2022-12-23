package commands;


import model.Color;

/**
 * An abstract class to represent the transform command for an image.
 */
public abstract class Transform extends AbstractCommand {
  private final double[][] matrix;

  /**
   * Passes in the matrix to be used.
   * @param matrix the matrix to apply.
   */
  public Transform(double[][] matrix) {
    this.matrix = matrix;

  }

  /**
   * Transforms the current (r, c) to be prime and clamps them to 0-255 range.
   * @param pixels the array of pixels.
   * @param row the current row position.
   * @param column the current column position.
   */
  public void transform(Color[][] pixels, int row, int column) {
    Color c = pixels[row][column];
    int[] rgb = {c.getRed(), c.getGreen(), c.getBlue()};
    double[] primes = {0, 0, 0};

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        primes[i] += (double) rgb[j] * matrix[i][j];
      }
    }
    pixels[row][column] = new Color(CommandUtil.clampTo8Bit((int) primes[0]),
            CommandUtil.clampTo8Bit((int) primes[1]),
            CommandUtil.clampTo8Bit((int) primes[2]));
  }


}
