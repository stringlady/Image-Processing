package model;

import commands.ICommand;

/**
 * An interface for an Image App Model. This contains the ability to
 * get images and accept a command given to it.
 */
public interface IImageAppModel extends IImageAppModelState {
  /**
   * Puts an image into the hashmap under the given name.
   *
   * @param fileName the name to be mapped to the image.
   * @param image    the image to be put into the map.
   */
  public void putImage(String fileName, IImage image);

  public void acceptCommand(ICommand cmd, String imageName, String destImageName)
          throws IllegalArgumentException;


}
