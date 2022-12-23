import org.junit.Before;
import org.junit.Test;

import commands.ICommand;
import commands.Luma;
import controller.ImageUtil;
import model.Color;
import model.IImage;

/**
 * A test class for the luma operation.
 */
public class LumaTest extends AbstractCommandTest {
  ICommand cmd;
  IImage guitarImage;
  IImage sample4by4;
  IImage sample3by4;
  IImage sample4by3;

  @Before
  public void setUp() {
    cmd = new Luma();
    this.guitarImage = ImageUtil.readPPM("res/guitar.ppm");
    this.sample4by4 = ImageUtil.readPPM("res/sample4by4.ppm");
    this.sample3by4 = ImageUtil.readPPM("res/sample3by4.ppm");
    this.sample4by3 = ImageUtil.readPPM("res/sample4by3.ppm");
  }

  @Test
  public void testModifiedGuitarImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.guitarImage);
  }

  @Test
  public void testModifiedGuitarImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.guitarImage);
  }

  @Test
  public void testModified4By4ImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.sample4by4);
  }

  @Test
  public void testModified4By4ImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.sample4by4);
  }

  @Test
  public void testModified4By3ImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.sample4by3);
  }

  @Test
  public void testModified4By3ImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.sample4by3);
  }

  @Test
  public void testModified3By4ImageWidthTest() {
    super.testModifiedImageWidth(this.cmd, this.sample3by4);
  }

  @Test
  public void testModified3By4ImageHeight() {
    super.testModifiedImageHeight(this.cmd, this.sample3by4);
  }

  @Test
  public void testModifiedGuitarImagePixels() {
    Color[][] pixels = this.guitarImage.getPixels();
    Color[][] expected = new Color[this.guitarImage.getHeight()][this.guitarImage.getWidth()];
    for (int i = 0; i < this.guitarImage.getHeight(); i++) {
      for (int j = 0; j < this.guitarImage.getWidth(); j++) {
        Color c = pixels[i][j];
        int luma = (int) ((double) c.getRed() * 0.2126 + (double) c.getGreen() * 0.7152 +
                (double) c.getBlue() * 0.0722);
        expected[i][j] = new Color(luma, luma, luma);
      }
    }
    super.testModifiedImagePixels(this.cmd, this.guitarImage, expected);
  }

  @Test
  public void testModified4By4ImagePixels() {
    Color[][] pixels = this.sample4by4.getPixels();
    Color[][] expected = new Color[this.sample4by4.getHeight()][this.sample4by4.getWidth()];
    for (int i = 0; i < this.sample4by4.getHeight(); i++) {
      for (int j = 0; j < this.sample4by4.getWidth(); j++) {
        Color c = pixels[i][j];
        int luma = (int) ((double) c.getRed() * 0.2126 + (double) c.getGreen() * 0.7152 +
                (double) c.getBlue() * 0.0722);
        expected[i][j] = new Color(luma, luma, luma);
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample4by4, expected);
  }

  @Test
  public void testModified4By3ImagePixels() {
    Color[][] pixels = this.sample4by3.getPixels();
    Color[][] expected = new Color[this.sample4by3.getHeight()][this.sample4by3.getWidth()];
    for (int i = 0; i < this.sample4by3.getHeight(); i++) {
      for (int j = 0; j < this.sample4by3.getWidth(); j++) {
        Color c = pixels[i][j];
        int luma = (int) ((double) c.getRed() * 0.2126 + (double) c.getGreen() * 0.7152 +
                (double) c.getBlue() * 0.0722);
        expected[i][j] = new Color(luma, luma, luma);
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample4by3, expected);
  }

  @Test
  public void testModified3By4ImagePixels() {
    Color[][] pixels = this.sample3by4.getPixels();
    Color[][] expected = new Color[this.sample3by4.getHeight()][this.sample3by4.getWidth()];
    for (int i = 0; i < this.sample3by4.getHeight(); i++) {
      for (int j = 0; j < this.sample3by4.getWidth(); j++) {
        Color c = pixels[i][j];
        int luma = (int) ((double) c.getRed() * 0.2126 + (double) c.getGreen() * 0.7152 +
                (double) c.getBlue() * 0.0722);
        expected[i][j] = new Color(luma, luma, luma);
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample3by4, expected);
  }
}