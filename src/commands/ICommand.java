package commands;

import model.IImage;

/**
 * This interface will hold be used to implement all commands
 * executed on a specific Image.
 */
public interface ICommand {
  /**
   * Runs the command.
   * @param image the image to operate on.
   * @return a new image with the operation of this object executed on it.
   */
  public IImage run(IImage image);
}
