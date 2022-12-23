import org.junit.Before;
import org.junit.Test;

import commands.CommandUtil;
import commands.ICommand;
import commands.SepiaTone;
import controller.ImageUtil;
import model.Color;
import model.IImage;

/**
 * This is the class that tests the Sepia Tone command.
 */
public class SepiaToneTest extends AbstractCommandTest {
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
    cmd = new SepiaTone();
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
   * Check each pixel of the expected and modified pixels of the sepia toned image.
   */
  @Test
  public void testModifiedGuitarImagePixels() {
    double[][] matrix = new double[][]{{0.393, 0.769, 0.189},
                                       {0.349, 0.686, 0.168},
                                       {0.272, 0.534, 0.131}};

    Color[][] pixels = this.guitarImage.getPixels();
    Color[][] expected = new Color[this.guitarImage.getHeight()][this.guitarImage.getWidth()];

    for (int r = 0; r < this.guitarImage.getHeight(); r++) {
      for (int c = 0; c < this.guitarImage.getWidth(); c++) {
        Color color = pixels[r][c];
        int[] rgb = {color.getRed(), color.getGreen(), color.getBlue()};
        double[] primes = {0, 0, 0};
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix.length; j++) {
            primes[i] += (double) rgb[j] * matrix[i][j];
          }
        }
        expected[r][c] = new Color(CommandUtil.clampTo8Bit((int) primes[0]),
                CommandUtil.clampTo8Bit((int) primes[1]),
                CommandUtil.clampTo8Bit((int) primes[2]));
      }
    }
    super.testModifiedImagePixels(this.cmd, this.guitarImage, expected);
  }

  /**
   * Check each pixel of the expected and modified pixels of the sepia toned image.
   */
  @Test
  public void testModifiedSample4by4ImagePixels() {
    double[][] matrix = new double[][]{{0.393, 0.769, 0.189},
                                       {0.349, 0.686, 0.168},
                                       {0.272, 0.534, 0.131}};

    Color[][] pixels = this.sample4by4.getPixels();
    Color[][] expected = new Color[this.sample4by4.getHeight()][this.sample4by4.getWidth()];

    for (int r = 0; r < this.sample4by4.getHeight(); r++) {
      for (int c = 0; c < this.sample4by4.getWidth(); c++) {
        Color color = pixels[r][c];
        int[] rgb = {color.getRed(), color.getGreen(), color.getBlue()};
        double[] primes = {0, 0, 0};
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix.length; j++) {
            primes[i] += (double) rgb[j] * matrix[i][j];
          }
        }
        expected[r][c] = new Color(CommandUtil.clampTo8Bit((int) primes[0]),
                CommandUtil.clampTo8Bit((int) primes[1]),
                CommandUtil.clampTo8Bit((int) primes[2]));
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample4by4, expected);
  }

  /**
   * Check each pixel of the expected and modified pixels of the sepia toned image.
   */
  @Test
  public void testModifiedSample3by4ImagePixels() {
    double[][] matrix = new double[][]{{0.393, 0.769, 0.189},
                                       {0.349, 0.686, 0.168},
                                       {0.272, 0.534, 0.131}};

    Color[][] pixels = this.sample3by4.getPixels();
    Color[][] expected = new Color[this.sample3by4.getHeight()][this.sample3by4.getWidth()];

    for (int r = 0; r < this.sample3by4.getHeight(); r++) {
      for (int c = 0; c < this.sample3by4.getWidth(); c++) {
        Color color = pixels[r][c];
        int[] rgb = {color.getRed(), color.getGreen(), color.getBlue()};
        double[] primes = {0, 0, 0};
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix.length; j++) {
            primes[i] += (double) rgb[j] * matrix[i][j];
          }
        }
        expected[r][c] = new Color(CommandUtil.clampTo8Bit((int) primes[0]),
                CommandUtil.clampTo8Bit((int) primes[1]),
                CommandUtil.clampTo8Bit((int) primes[2]));
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample3by4, expected);
  }

  /**
   * Check each pixel of the expected and modified pixels of the sepia toned image.
   */
  @Test
  public void testModifiedSample4by3ImagePixels() {
    double[][] matrix = new double[][]{{0.393, 0.769, 0.189},
                                       {0.349, 0.686, 0.168},
                                       {0.272, 0.534, 0.131}};

    Color[][] pixels = this.sample4by3.getPixels();
    Color[][] expected = new Color[this.sample4by3.getHeight()][this.sample4by3.getWidth()];

    for (int r = 0; r < this.sample4by3.getHeight(); r++) {
      for (int c = 0; c < this.sample4by3.getWidth(); c++) {
        Color color = pixels[r][c];
        int[] rgb = {color.getRed(), color.getGreen(), color.getBlue()};
        double[] primes = {0, 0, 0};
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix.length; j++) {
            primes[i] += (double) rgb[j] * matrix[i][j];
          }
        }
        expected[r][c] = new Color(CommandUtil.clampTo8Bit((int) primes[0]),
                CommandUtil.clampTo8Bit((int) primes[1]),
                CommandUtil.clampTo8Bit((int) primes[2]));
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample4by3, expected);
  }
}
