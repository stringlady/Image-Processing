import org.junit.Test;

import java.io.File;

import commands.ICommand;
import commands.Load;
import commands.Save;
import controller.ImageUtil;
import model.IImage;

import static org.junit.Assert.assertTrue;

/**
 * A test class for the save operation.
 */
public class SaveTest extends AbstractCommandTest {
  ICommand cmd;

  @Test
  public void testSaveGuitar() {
    this.cmd = new Load("res/guitar.ppm");
    IImage guitar;
    guitar = cmd.run(null);
    ICommand save = new Save("res/saveguitartest.ppm");
    save.run(guitar);
    File f = new File("res/saveguitartest.ppm");
    assertTrue(f.exists());
  }

  @Test
  public void testSaveSample4by4() {
    this.cmd = new Load("res/sample4by4.ppm");
    IImage guitar;
    guitar = cmd.run(null);
    ICommand save = new Save("res/savesample4by4test.ppm");
    save.run(guitar);
    File f = new File("res/savesample4by4test.ppm");
    assertTrue(f.exists());
  }

  @Test
  public void testSavePPMASPNG() {
    this.cmd = new Load("res/berryguitar.ppm");
    IImage guitar;
    guitar = cmd.run(null);
    IImage image = ImageUtil.decodeImage("res/berryguitar.png");
    super.testModifiedImagePixels(this.cmd, guitar, image.getPixels());
  }

  @Test
  public void testSaveBMPASPPM() {
    this.cmd = new Load("res/berryguitar.bmp");
    IImage guitar;
    guitar = cmd.run(null);
    //this.cmd = new Save("res/berryguitar.ppm");
    //this.cmd.run(guitar);
    IImage image = ImageUtil.readPPM("res/berryguitar.ppm");
    super.testModifiedImagePixels(this.cmd, guitar, image.getPixels());
  }



}
