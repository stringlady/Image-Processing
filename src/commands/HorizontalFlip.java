package commands;

import model.Color;
import model.IImage;
import model.Image;

/**
 * A class to represent a horizontal flip operation.
 */
public class HorizontalFlip implements ICommand {
  /**
   * Horizontally flips the pixels over the middle of the horizontal axis.
   * @param image the image to operate on.
   * @return the image horizontally flipped.
   */
  @Override
  public IImage run(IImage image) {
    Color[][] pixels = image.getPixels();
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth() / 2; j++) {   // (i, j) -> (row, col)
        Color temp = pixels[i][j];
        pixels[i][j] = pixels[i][image.getWidth() - j - 1];
        pixels[i][image.getWidth() - j - 1] = temp;
      }
    }
    return new Image(pixels, image.getWidth(), image.getHeight(), image.getMaxValue());
  }

  @Override
  public String toString() {
    return "horizontal-flip";
  }


}
