package commands;

import model.Color;
import model.IImage;
import model.Image;

/**
 * A class to represent the vertical flip command.
 */
public class VerticalFlip implements ICommand {
  /**
   * Takes an image and vertically flips it on the vertical axis.
   *
   * @param image the image to operate on.
   * @return the modified image.
   */
  @Override
  public IImage run(IImage image) {
    Color[][] pixels = image.getPixels();
    for (int i = 0; i < image.getHeight() / 2; i++) {
      for (int j = 0; j < image.getWidth(); j++) {  // (i, j) -> (row, col)
        Color temp = pixels[i][j];
        pixels[i][j] = pixels[image.getHeight() - i - 1][j];
        pixels[image.getHeight() - i - 1][j] = temp;

      }
    }
    return new Image(pixels, image.getWidth(), image.getHeight(), image.getMaxValue());
  }

  @Override
  public String toString() {
    return "vertical-flip";
  }
}
