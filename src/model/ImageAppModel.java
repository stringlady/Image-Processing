package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import commands.ICommand;

/**
 * A class to represent the model for an Image App. This model
 * is relatively simplistic, just mapping a fileName to an Image object,
 * and allowing some methods to get and put images in the map along with
 * running commands on an image.
 */
public class ImageAppModel implements IImageAppModel {
  private final Map<String, IImage> loadedImages; // fileName -> ImageAppModel.Image

  /**
   * A constructor for an Image App Model.
   * Initialize the map relating fileNames to images.
   */
  public ImageAppModel() {
    loadedImages = new HashMap<>();
  }

  /**
   * Gets an image from the hashmap.
   *
   * @param name the name of the image to be retrieves
   * @return the image, or null if there is no image under that alias.
   */
  @Override
  public IImage getImage(String name) {
    return this.loadedImages.get(name);
  }

  /**
   * Puts an image into the hashmap under the given name.
   *
   * @param fileName the name to be mapped to the image.
   * @param image    the image to be put into the map.
   */
  @Override
  public void putImage(String fileName, IImage image) {
    this.loadedImages.put(fileName, image);
  }

  /**
   * Accepts a command and gets the requested image to be operated on from the map.
   * Will then run that command on the appropriate image.
   *
   * @param cmd           the command to be run
   * @param imageName     the image name to run the command on
   * @param destImageName the destination name of the modified image
   * @throws IllegalStateException if the image to be modified is not in the map.
   */
  @Override
  public void acceptCommand(ICommand cmd, String imageName, String destImageName)
          throws IllegalArgumentException {
    IImage image;
    if ((image = this.getImage(imageName)) == null && !cmd.toString().equals("load")) {
      throw new IllegalArgumentException(
              "Image does not exist or was not loaded into the application.");
    }
    IImage modImage = cmd.run(image);
    this.putImage(destImageName, modImage);
  }

  @Override
  public Collection<IImage> getLoadedImages() {
    return loadedImages.values();
  }
}