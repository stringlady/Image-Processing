import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.IImageAppController;
import controller.ImageAppController;
import model.IImageAppModel;
import model.ImageAppModel;

/**
 * A class to represent the main method for entering the Image App program.
 */
public class ImageAppMain {
  /**
   * main method. runs the image program
   *
   * @param args with the first arg being a script file path to run
   * @throws IOException if an IO exception occurs.
   */
  public static void main(String[] args) throws IOException {
    Readable in = null;
    if (args.length > 0 && args[0].equals("-file")) {
      in = new InputStreamReader(new FileInputStream(args[1]));
    } else {
      System.out.println("here");
      in = new InputStreamReader(System.in);
    }
    Appendable out = System.out;
    IImageAppModel model = new ImageAppModel();
    IImageAppController controller = new ImageAppController(in, out, model);
    controller.runProgram();
  }
}
