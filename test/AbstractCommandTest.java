import commands.ICommand;
import model.Color;
import model.IImage;

import static org.junit.Assert.assertEquals;

/**
 * A class to represent testing for any command implementing
 * the abstract command interface.
 */
public abstract class AbstractCommandTest {
  /**
   * Tests the image width is the same for a modified image.
   *
   * @param cmd      the command to run.
   * @param original the original image.
   */
  public void testModifiedImageWidth(ICommand cmd, IImage original) {
    IImage modifiedImage = cmd.run(original);
    assertEquals(original.getWidth(), modifiedImage.getWidth());
  }

  /**
   * Tests the image height is the same for a modified image.
   *
   * @param cmd      the command to run.
   * @param original the original image.
   */
  public void testModifiedImageHeight(ICommand cmd, IImage original) {
    IImage modifiedImage = cmd.run(original);
    assertEquals(original.getHeight(), modifiedImage.getHeight());
  }

  /**
   * Tests the pixels are the same for the original image and the modified image.
   *
   * @param cmd      the command to run.
   * @param original the original image.
   * @param expected the expected 2D array
   */
  public void testModifiedImagePixels(ICommand cmd, IImage original, Color[][] expected) {
    IImage modifiedImage = cmd.run(original);
    Color[][] actual = modifiedImage.getPixels();
    for (int i = 0; i < original.getHeight(); i++) {
      for (int j = 0; j < original.getWidth(); j++) {
        assertEquals(expected[i][j], actual[i][j]);
      }
    }
  }
}
