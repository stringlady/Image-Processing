package commands;


import model.Color;

/**
 * A class to represent the filter command applied to an image,
 * the kernel can change.
 */
public abstract class Filter extends AbstractCommand {

  private final double[][] kernel;

  /**
   * A constructor for a filter.
   *
   * @param kernel the kernel to be applied.
   */
  public Filter(double[][] kernel) {
    this.kernel = kernel;
  }

  /**
   * Filters the current pixels specified channel by calculating the value to replace it with.
   * @param pixels  the array of pixels to use.
   * @param height  the height of the image.
   * @param width   the width of the image.
   * @param row     the current row.
   * @param column  the current column.
   * @param channel the channel of color to operate on.
   */
  protected void filter(Color[][] pixels, int height, int width,
                        int row, int column, Channel channel) {
    int newColor = 0;
    int offset = kernel.length / 2;
    for (int i = 0; i < kernel.length; i++) {
      for (int j = 0; j < kernel.length; j++) {
        if (row - offset + i < 0 || row - offset + i >= height
                || column - offset + j < 0 || column - offset + j >= width) {
          continue;
        }
        Color c = pixels[row - offset + i][column - offset + j];
        switch (channel) {
          case RED:
            newColor += ((int) (kernel[i][j] * (double) c.getRed()));
            break;
          case GREEN:
            newColor += ((int) (kernel[i][j] * (double) c.getGreen()));
            break;
          default:
            newColor += ((int) (kernel[i][j] * (double) c.getBlue()));
            break;
        }
      }
    }
    newColor = Math.max(0, Math.min(255, newColor));
    pixels[row][column] = new Color(channel == Channel.RED ?
            newColor : pixels[row][column].getRed(),
            channel == Channel.GREEN ? newColor : pixels[row][column].getGreen(),
            channel == Channel.BLUE ? newColor : pixels[row][column].getBlue());
  }


}
