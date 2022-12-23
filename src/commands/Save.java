package commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import controller.ImageUtil;
import model.IImage;

/**
 * A class to represent the save command.
 */
public class Save implements ICommand {
  private final String imagePath;

  /**
   * A constructor to take in the imagePath to save to.
   *
   * @param imagePath the image path.
   */
  public Save(String imagePath) {
    if (imagePath == null) {
      throw new IllegalArgumentException();
    }
    this.imagePath = imagePath;
  }

  /**
   * Will save the image to the given imagePath.
   *
   * @param image the image to save.
   * @return null, as saving does not return an image.
   */
  @Override
  public IImage run(IImage image) {
    File f;
    FileOutputStream fos;
    try {
      f = new File(this.imagePath);
      fos = new FileOutputStream(f);
      if (!f.exists()) {
        f.createNewFile();
      }
    } catch (IOException e) {
      throw new IllegalArgumentException();
    }

    String fileFormat = this.imagePath.substring(this.imagePath.length() - 3);
    if (fileFormat.equals("ppm")) {
      try {
        ImageUtil.savePPM(image, fos);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } else {
      ImageUtil.encodeImage(image, fileFormat, fos);
    }
    return null;
  }

  @Override
  public String toString() {
    return "save";
  }
}
