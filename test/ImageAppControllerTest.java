import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import controller.IImageAppController;
import controller.ImageAppController;
import model.Color;
import model.IImage;
import model.IImageAppModel;
import model.ImageAppMockModel;
import model.ImageAppModel;

import static org.junit.Assert.assertEquals;

/**
 * A test class for an image app controller to ensure it passes correct data
 * and generally functions as expected.
 */
public class ImageAppControllerTest {

  Appendable out;
  IImageAppModel model;
  IImageAppController controller;

  @Before
  public void setUp() {
    this.model = new ImageAppModel();
  }


  // TESTS FOR DATA TRANSMISSION TO ENSURE CORRECT COMMAND IS PASSED TO MODEL.

  @Test
  public void testDataTransmissionLoad() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("load guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: load imageName:  destImageName: guitar", log.toString());
  }

  @Test
  public void testDataTransmissionSave() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("save guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: save imageName: guitar destImageName: ", log.toString());
  }

  @Test
  public void testDataTransmissionBlueGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("grayscale-blue guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: grayscale-blue imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionGreenGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("grayscale-green guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: grayscale-green imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionRedGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("grayscale-red guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: grayscale-red imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionLumaGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("grayscale-luma guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: grayscale-luma imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionIntensityGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("grayscale-intensity guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: grayscale-intensity imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionValueGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("grayscale-value guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: grayscale-value imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionVFlipGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("vertical-flip guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: vertical-flip imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionHFlipGrayscale() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("horizontal-flip guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: horizontal-flip imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  @Test
  public void testDataTransmissionBrighten() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("brighten 20 guitar.ppm guitar");
    StringBuilder log = new StringBuilder();
    IImageAppModel mockModel = new ImageAppMockModel(log);
    this.controller = new ImageAppController(in, out, mockModel);
    this.controller.runProgram();
    assertEquals("cmd: brighten imageName: guitar.ppm destImageName: guitar",
            log.toString());
  }

  // TESTS THAT LOAD AND MODIFY IMAGES BEHAVING IN THE WAY A USER WOULD WITH THE PROGRAM
  @Test
  public void testController1() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("load res/guitar.ppm guitar\n" +
            "brighten 30 guitar brighter-guitar q\n");
    this.controller = new ImageAppController(in, out, this.model);
    this.controller.runProgram();
    IImage guitar = this.model.getImage("guitar");
    IImage brightGuitar = this.model.getImage("brighter-guitar");
    Color[][] expected = guitar.getPixels();
    Color[][] actual = brightGuitar.getPixels();
    for (int i = 0; i < guitar.getHeight(); i++) {
      for (int j = 0; j < guitar.getWidth(); j++) {
        assertEquals(new Color(Math.max(0, Math.min(255, expected[i][j].getRed() + 30)),
                Math.max(0, Math.min(255, expected[i][j].getGreen() + 30)),
                Math.max(0, Math.min(255, expected[i][j].getBlue() + 30))), actual[i][j]);
      }
    }
  }

  @Test
  public void testController2() {
    Readable in1 = new StringReader("load res/guitar.ppm guitar " +
            "vertical-flip guitar vflip-guitar"
            + " horizontal-flip guitar hflip-guitar quit");
    Readable in2 = new StringReader("load res/guitar.ppm guitar horizontal-flip " +
            "guitar hflip-guitar q");
    this.out = new StringBuilder();
    IImageAppModel model1 = new ImageAppModel();
    IImageAppModel model2 = new ImageAppModel();
    IImageAppController controller1 = new ImageAppController(in1, this.out, model1);
    IImageAppController controller2 = new ImageAppController(in2, this.out, model2);
    controller1.runProgram();
    controller2.runProgram();
    IImage guitar1 = model1.getImage("hflip-guitar");
    IImage guitar2 = model2.getImage("hflip-guitar");
    Color[][] actual = guitar1.getPixels();
    Color[][] expected = guitar2.getPixels();
    for (int i = 0; i < guitar2.getHeight(); i++) {
      for (int j = 0; j < guitar2.getWidth(); j++) {
        assertEquals(expected[i][j], actual[i][j]);
      }
    }
  }

  // TESTS FOR BAD INPUT
  @Test
  public void testBadInput1() {
    Readable in = new StringReader("load guitar.ppm guitar " +
            "vertical-fli guitar vflip-guitar"
            + " -flip guitar hflip-guitar quit");

    this.out = new StringBuilder();
    IImageAppModel model = new ImageAppModel();
    IImageAppController controller = new ImageAppController(in, this.out, model);
    controller.runProgram();
    String[] contents = this.out.toString().split("\n");
    assertEquals("Invalid command or arguments", contents[contents.length - 1]);
  }

  @Test
  public void testBadInput2() {
    Readable in = new StringReader("load res/guitar.ppm guitar " +
            "vertical-fli guitar vflip-guitar"
            + " -flip guitar hflip-guitar quit");

    this.out = new StringBuilder();
    IImageAppModel model = new ImageAppModel();
    IImageAppController controller = new ImageAppController(in, this.out, model);
    controller.runProgram();
    String[] contents = this.out.toString().split("\n");
    assertEquals("Invalid command or arguments", contents[contents.length - 1]);
  }

}
