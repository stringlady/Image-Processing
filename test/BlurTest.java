import org.junit.Before;
import org.junit.Test;

import commands.Blur;
import commands.Channel;
import commands.ICommand;
import controller.ImageUtil;
import model.Color;
import model.IImage;

/**
 * This is the class for testing the Blur Command.
 */
public class BlurTest extends AbstractCommandTest {
  ICommand cmd;
  IImage guitarImage;
  IImage sample4by4;
  IImage sample3by4;
  IImage sample4by3;

  /**
   * This helps set up all the fields.
   */
  @Before
  public void setUp() {
    cmd = new Blur();
    this.guitarImage = ImageUtil.readPPM("res/guitar.ppm");
    this.sample4by4 = ImageUtil.readPPM("res/sample4by4.ppm");
    this.sample3by4 = ImageUtil.readPPM("res/sample3by4.ppm");
    this.sample4by3 = ImageUtil.readPPM("res/sample4by3.ppm");
  }

  /**
   * Tests the image width is the same for a modified image.
   */
  @Test
  public void testModifiedGuitarImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.guitarImage);
  }

  /**
   * Tests the image height is the same for a modified image.
   */
  @Test
  public void testModifiedGuitarImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.guitarImage);
  }

  /**
   * Tests the image width is the same for a modified image.
   */
  @Test
  public void testModified4By4ImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.sample4by4);
  }

  /**
   * Tests the image height is the same for a modified image.
   */
  @Test
  public void testModified4By4ImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.sample4by4);
  }

  /**
   * Tests the image width is the same for a modified image.
   */
  @Test
  public void testModified4By3ImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.sample4by3);
  }

  /**
   * Tests the image height is the same for a modified image.
   */
  @Test
  public void testModified4By3ImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.sample4by3);
  }

  /**
   * Tests the image width is the same for a modified image.
   */
  @Test
  public void testModified3By4ImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.sample3by4);
  }

  /**
   * Tests the image height is the same for a modified image.
   */
  @Test
  public void testModified3By4ImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.sample3by4);
  }

  /**
   * This is the helper to test the pixels for the blur command.
   *
   * @param pixels  the array of color pixels
   * @param height  height of the image
   * @param width   width of the image
   * @param row     the row of the pixel
   * @param column  the column of the pixel
   * @param channel is it green, blue, or red?
   */
  public void helper(Color[][] pixels, int height, int width,
                     int row, int column, Channel channel) {
    double[][] kernel = new double[][]{{0.0625, 0.125, 0.0625},
                                       {0.125, 0.25, 0.125},
                                       {0.0625, 0.125, 0.0625}};
    int newColor = 0;
    int offset = kernel.length / 2;
    for (int i = 0; i < kernel.length; i++) {
      for (int j = 0; j < kernel.length; j++) {
        if (row - offset + i < 0 || row - offset + i >= height
                || column - offset + j < 0 || column - offset + j >= width) {
          continue;
        }
        Color c = pixels[row - offset + i][column - offset + j];
        switch (channel) {
          case RED:
            newColor += ((int) (kernel[i][j] * (double) c.getRed()));
            break;
          case GREEN:
            newColor += ((int) (kernel[i][j] * (double) c.getGreen()));
            break;
          default:
            newColor += ((int) (kernel[i][j] * (double) c.getBlue()));
            break;
        }
      }
    }
    newColor = Math.max(0, Math.min(255, newColor));
    pixels[row][column] = new Color(channel == Channel.RED ? newColor :
            pixels[row][column].getRed(),
            channel == Channel.GREEN ? newColor : pixels[row][column].getGreen(),
            channel == Channel.BLUE ? newColor : pixels[row][column].getBlue());
  }

  /**
   * Check each pixel of the expected and modified pixels of the blurred image.
   */
  @Test
  public void testModifiedGuitarImagePixels() {
    Color[][] pixels = this.guitarImage.getPixels();
    Color[][] expected = new Color[this.guitarImage.getHeight()][this.guitarImage.getWidth()];

    for (int row = 0; row < this.guitarImage.getHeight(); row++) {
      for (int col = 0; col < this.guitarImage.getWidth(); col++) {
        this.helper(pixels, this.guitarImage.getHeight(), this.guitarImage.getWidth(), row, col,
                Channel.RED);
        this.helper(pixels, this.guitarImage.getHeight(), this.guitarImage.getWidth(), row, col,
                Channel.GREEN);
        this.helper(pixels, this.guitarImage.getHeight(), this.guitarImage.getWidth(), row, col,
                Channel.BLUE);
        expected[row][col] = pixels[row][col];
      }
    }
    super.testModifiedImagePixels(this.cmd, this.guitarImage, expected);
  }

  /**
   * Check each pixel of the expected and modified pixels of the blurred image.
   */
  @Test
  public void testModified4by4ImagePixels() {
    Color[][] pixels = this.sample4by4.getPixels();
    Color[][] expected = new Color[this.sample4by4.getHeight()][this.sample4by4.getWidth()];

    for (int row = 0; row < this.sample4by4.getHeight(); row++) {
      for (int col = 0; col < this.sample4by4.getWidth(); col++) {
        this.helper(pixels, this.sample4by4.getHeight(), this.sample4by4.getWidth(), row, col,
                Channel.RED);
        this.helper(pixels, this.sample4by4.getHeight(), this.sample4by4.getWidth(), row, col,
                Channel.GREEN);
        this.helper(pixels, this.sample4by4.getHeight(), this.sample4by4.getWidth(), row, col,
                Channel.BLUE);
        expected[row][col] = pixels[row][col];
      }
    }
    super.testModifiedImagePixels(this.cmd, sample4by4, expected);
  }

  /**
   * Check each pixel of the expected and modified pixels of the blurred image.
   */
  @Test
  public void testModified4by3ImagePixels() {
    Color[][] pixels = this.sample4by3.getPixels();
    Color[][] expected = new Color[this.sample4by3.getHeight()][this.sample4by3.getWidth()];

    for (int row = 0; row < this.sample4by3.getHeight(); row++) {
      for (int col = 0; col < this.sample4by3.getWidth(); col++) {
        this.helper(pixels, this.sample4by3.getHeight(), this.sample4by3.getWidth(), row, col,
                Channel.RED);
        this.helper(pixels, this.sample4by3.getHeight(), this.sample4by3.getWidth(), row, col,
                Channel.GREEN);
        this.helper(pixels, this.sample4by3.getHeight(), this.sample4by3.getWidth(), row, col,
                Channel.BLUE);
        expected[row][col] = pixels[row][col];
      }
    }
    super.testModifiedImagePixels(this.cmd, sample4by3, expected);
  }

  /**
   * Check each pixel of the expected and modified pixels of the blurred image.
   */
  @Test
  public void testModified3by4ImagePixels() {
    Color[][] pixels = this.sample3by4.getPixels();
    Color[][] expected = new Color[this.sample3by4.getHeight()][this.sample3by4.getWidth()];

    for (int row = 0; row < this.sample3by4.getHeight(); row++) {
      for (int col = 0; col < this.sample3by4.getWidth(); col++) {
        this.helper(pixels, this.sample3by4.getHeight(), this.sample3by4.getWidth(), row, col,
                Channel.RED);
        this.helper(pixels, this.sample3by4.getHeight(), this.sample3by4.getWidth(), row, col,
                Channel.GREEN);
        this.helper(pixels, this.sample3by4.getHeight(), this.sample3by4.getWidth(), row, col,
                Channel.BLUE);
        expected[row][col] = pixels[row][col];
      }
    }
    super.testModifiedImagePixels(this.cmd, sample3by4, expected);
  }

}
