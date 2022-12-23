package model;

import java.util.Collection;

import commands.ICommand;

/**
 * A class to represent a mock model, for testing purposes.
 */
public class ImageAppMockModel implements IImageAppModel {
  private final StringBuilder log;

  /**
   * Initialize the private log to the passed in log.
   *
   * @param log the appendable to append relevant info to.
   */
  public ImageAppMockModel(StringBuilder log) {
    this.log = log;
  }

  /**
   * Returns null. not used.
   *
   * @param name the name to be retrieved.
   * @return null
   */
  @Override
  public IImage getImage(String name) {
    return null;
  }

  /**
   * Gets all images loaded into the application.
   *
   * @return the loaded images of the model.
   */
  @Override
  public Collection<IImage> getLoadedImages() {
    return null;
  }

  /**
   * Appends the information to the log.
   *
   * @param cmd           the cmd
   * @param imageName     the imageName
   * @param destImageName the destImageName
   */
  @Override
  public void acceptCommand(ICommand cmd, String imageName, String destImageName) {
    log.append("cmd: ").append(cmd.toString()).append(" imageName: ")
            .append(imageName).append(" destImageName: ").append(destImageName);
  }

  /**
   * Appends the information to the log.
   *
   * @param fileName the name to be mapped to the image.
   * @param image    the image to be put into the map.
   */
  @Override
  public void putImage(String fileName, IImage image) {
    log.append("fileName: ").append(fileName).append(", image: ").append(image);
  }
}
