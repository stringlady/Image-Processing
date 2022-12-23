package model;

import java.util.Collection;

/**
 * An interface for the non-mutating methods of an image app model.
 */
public interface IImageAppModelState {
  /**
   * Gets an image from the hashmap.
   *
   * @param name the name of the image to be retrieves
   * @return the image, or null if there is no image under that alias.
   */
  IImage getImage(String name);

  /**
   * Gets all images loaded into the application.
   * @return the loaded images of the model.
   */
  Collection<IImage> getLoadedImages();
}
