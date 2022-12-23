import org.junit.Before;
import org.junit.Test;

import commands.HorizontalFlip;
import commands.ICommand;
import controller.ImageUtil;
import model.Color;
import model.IImage;

/**
 * A test class for the horizontal flip operation.
 */
public class HorizontalFlipTest extends AbstractCommandTest {
  ICommand cmd;
  IImage guitarImage;
  IImage sample4by4;
  IImage sample3by4;
  IImage sample4by3;

  @Before
  public void setUp() {
    cmd = new HorizontalFlip();
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
    Color[][] expected = this.guitarImage.getPixels();
    for (int i = 0; i < this.guitarImage.getHeight(); i++) {
      for (int j = 0; j < this.guitarImage.getWidth() / 2; j++) {
        Color temp = expected[i][j];
        expected[i][j] = expected[i][this.guitarImage.getWidth() - j - 1];
        expected[i][this.guitarImage.getWidth() - j - 1] = temp;
      }
    }
    super.testModifiedImagePixels(this.cmd, this.guitarImage, expected);
  }

  @Test
  public void testModified4By4ImagePixels() {
    Color[][] expected = this.sample4by4.getPixels();
    for (int i = 0; i < this.sample4by4.getHeight(); i++) {
      for (int j = 0; j < this.sample4by4.getWidth() / 2; j++) {
        Color temp = expected[i][j];
        expected[i][j] = expected[i][this.sample4by4.getWidth() - j - 1];
        expected[i][this.sample4by4.getWidth() - j - 1] = temp;
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample4by4, expected);
  }

  @Test
  public void testModified4By3ImagePixels() {
    Color[][] expected = this.sample4by3.getPixels();
    for (int i = 0; i < this.sample4by3.getHeight(); i++) {
      for (int j = 0; j < this.sample4by3.getWidth() / 2; j++) {
        Color temp = expected[i][j];
        expected[i][j] = expected[i][this.sample4by3.getWidth() - j - 1];
        expected[i][this.sample4by3.getWidth() - j - 1] = temp;
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample4by3, expected);
  }

  @Test
  public void testModified3By4ImagePixels() {
    Color[][] expected = this.sample3by4.getPixels();
    for (int i = 0; i < this.sample3by4.getHeight(); i++) {
      for (int j = 0; j < this.sample3by4.getWidth() / 2; j++) {
        Color temp = expected[i][j];
        expected[i][j] = expected[i][this.sample3by4.getWidth() - j - 1];
        expected[i][this.sample3by4.getWidth() - j - 1] = temp;
      }
    }
    super.testModifiedImagePixels(this.cmd, this.sample3by4, expected);
  }
}