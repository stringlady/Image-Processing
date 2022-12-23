package commands;

import controller.ImageUtil;
import model.IImage;

/**
 * A class to represent the load operation.
 */
public class Load implements ICommand {
  private final String imagePath;

  /**
   * A constructor for the load operation.
   *
   * @param imagePath the path of the image to load into image format.
   */
  public Load(String imagePath) {
    if (imagePath == null) {
      throw new IllegalArgumentException();
    }
    this.imagePath = imagePath;
  }

  /**
   * Reads with the image path.
   *
   * @param image not needed in this case.
   * @return the image loaded by ImageUtil.
   */
  @Override
  public IImage run(IImage image) {
    IImage im = null;
    if ("ppm".equals(this.imagePath.substring(this.imagePath.length() - 3))) {
      im = ImageUtil.readPPM(this.imagePath);
    } else {
      im = ImageUtil.decodeImage(this.imagePath);
    }

    return im;
  }

  @Override
  public String toString() {
    return "load";
  }
}
