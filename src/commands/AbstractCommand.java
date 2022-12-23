package commands;

import model.Color;
import model.IImage;
import model.Image;

/**
 * A class to represent a command that can operate on an image.
 */
public abstract class AbstractCommand implements ICommand {
  /**
   * runs the command specified in method on image argument.
   *
   * @param image the image to operate on.
   * @return a new image with the operation executed on it.
   */
  @Override
  public IImage run(IImage image) {
    Color[][] pixels = image.getPixels();
    int height = image.getHeight();
    int width = image.getWidth();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        pixels[i][j] = this.getPixel(pixels, height, width, i, j);
      }
    }
    return new Image(pixels, image.getWidth(), image.getHeight(), image.getMaxValue());
  }

  /**
   * Gets the modified pixel when given the unmodified pixel.
   *
   * @param pixels the array of pixels.
   * @param i i
   * @param j j
   * @return the modified pixel.
   */
  protected abstract Color getPixel(Color[][] pixels, int height, int width, int i, int j);

}
