import org.junit.Test;

import commands.ICommand;
import commands.Load;
import controller.ImageUtil;
import model.Color;
import model.IImage;

import static org.junit.Assert.assertEquals;

/**
 * A test class for the load operation.
 */
public class LoadTest {

  ICommand cmd;

  @Test
  public void testLoadingInGuitar() {
    this.cmd = new Load("res/guitar.ppm");
    IImage guitar;
    guitar = cmd.run(null);
    Color[][] actual = guitar.getPixels();
    Color[][] expected = ImageUtil.readPPM("res/guitar.ppm").getPixels();
    for (int i = 0; i < guitar.getHeight(); i++) {
      for (int j = 0; j < guitar.getWidth(); j++) {
        assertEquals(expected[i][j], actual[i][j]);
      }
    }
  }

  @Test
  public void testLoadPPM() {
    this.cmd = new Load("res/berryguitar.ppm");
    IImage guitar;
    guitar = cmd.run(null);
    Color[][] actual = guitar.getPixels();
    Color[][] expected = ImageUtil.readPPM("res/berryguitar.ppm").getPixels();
    for (int i = 0; i < guitar.getHeight(); i++) {
      for (int j = 0; j < guitar.getWidth(); j++) {
        assertEquals(expected[i][j], actual[i][j]);
      }
    }
  }

  @Test
  public void testLoadBMP() {
    this.cmd = new Load("res/berryguitar.bmp");
    IImage guitar;
    guitar = cmd.run(null);
    Color[][] actual = guitar.getPixels();
    Color[][] expected = ImageUtil.decodeImage("res/berryguitar.bmp").getPixels();
    for (int i = 0; i < guitar.getHeight(); i++) {
      for (int j = 0; j < guitar.getWidth(); j++) {
        assertEquals(expected[i][j], actual[i][j]);
      }
    }
  }

  @Test
  public void testLoadJPG() {
    this.cmd = new Load("res/berryguitar.jpg");
    IImage guitar;
    guitar = cmd.run(null);
    Color[][] actual = guitar.getPixels();
    Color[][] expected = ImageUtil.decodeImage("res/berryguitar.jpg").getPixels();
    for (int i = 0; i < guitar.getHeight(); i++) {
      for (int j = 0; j < guitar.getWidth(); j++) {
        assertEquals(expected[i][j], actual[i][j]);
      }
    }
  }

  @Test
  public void testLoadPNG() {
    this.cmd = new Load("res/berryguitar.png");
    IImage guitar;
    guitar = cmd.run(null);
    Color[][] actual = guitar.getPixels();
    Color[][] expected = ImageUtil.decodeImage("res/berryguitar.png").getPixels();
    for (int i = 0; i < guitar.getHeight(); i++) {
      for (int j = 0; j < guitar.getWidth(); j++) {
        assertEquals(expected[i][j], actual[i][j]);
      }
    }
  }

}
