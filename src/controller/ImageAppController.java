package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import commands.BlueGrayscale;
import commands.Blur;
import commands.Brighten;
import commands.Grayscale;
import commands.GreenGrayscale;
import commands.HorizontalFlip;
import commands.ICommand;
import commands.Intensity;
import commands.Load;
import commands.Luma;
import commands.RedGrayscale;
import commands.Save;
import commands.SepiaTone;
import commands.Sharpen;
import commands.Value;
import commands.VerticalFlip;
import model.IImageAppModel;

/**
 * A class to represent a Controller for an ImageAppModel. This controls
 * passage of data from the basic text based scripting to the Model.
 */
public class ImageAppController implements IImageAppController {
  private final Readable in;
  private final Appendable out;
  private final IImageAppModel model;

  /**
   * A constructor for an ImageAppController. Initializes relevant fields.
   *
   * @param out   the appendable to transmit messages to.
   * @param in    the readable to scan input from.
   * @param model the model containing data for the app.
   * @throws IllegalArgumentException if any arguments passed
   *                                  to the controller are null.
   */
  public ImageAppController(Readable in, Appendable out, IImageAppModel model) {
    if (out == null || in == null || model == null) {
      throw new IllegalArgumentException("Arguments cannot be null.");
    }
    this.in = in;
    this.out = out;
    this.model = model;
  }

  /**
   * Runs the program with simple text based scripting input commands.
   *
   * @throws IllegalArgumentException if the controller is unable to
   *                                  read input
   *                                  if the controller is unable to
   *                                  transmit the output.
   */
  @Override
  public void runProgram() throws IllegalArgumentException {
    Map<String, Function<Scanner, ICommand>> knownCommands = new HashMap<>();
    knownCommands.put("load", (Scanner s) -> {
      return new Load(s.next());
    });
    knownCommands.put("save", (Scanner s) -> {
      return new Save(s.next());
    });
    knownCommands.put("brighten", (Scanner s) -> {
      return new Brighten(s.nextInt());
    });
    knownCommands.put("grayscale-red", (Scanner s) -> {
      return new RedGrayscale();
    });
    knownCommands.put("grayscale-green", (Scanner s) -> {
      return new GreenGrayscale();
    });
    knownCommands.put("grayscale-blue", (Scanner s) -> {
      return new BlueGrayscale();
    });
    knownCommands.put("grayscale-value", (Scanner s) -> {
      return new Value();
    });
    knownCommands.put("grayscale-intensity", (Scanner s) -> {
      return new Intensity();
    });
    knownCommands.put("grayscale-luma", (Scanner s) -> {
      return new Luma();
    });
    knownCommands.put("vertical-flip", (Scanner s) -> {
      return new VerticalFlip();
    });
    knownCommands.put("horizontal-flip", (Scanner s) -> {
      return new HorizontalFlip();
    });
    knownCommands.put("blur", (Scanner s) -> {
      return new Blur();
    });
    knownCommands.put("sharpen", (Scanner s) -> {
      return new Sharpen();
    });
    knownCommands.put("matrix-grayscale", (Scanner s) -> {
      return new Grayscale();
    });
    knownCommands.put("sepia-tone", (Scanner s) -> {
      return new SepiaTone();
    });


    Scanner scanner = new Scanner(this.in);
    this.renderStartupInstructions();
    while (scanner.hasNext()) { //continue until the user quits
      String in = scanner.next(); //take an instruction name
      if (in.equals("quit") || in.equals("q")) {
        return;
      }
      Function<Scanner, ICommand> cmd = knownCommands.getOrDefault(in, null);

      if (cmd == null) {
        this.appendMessage("Invalid command or arguments\n");
        continue;
      }
      try {
        ICommand comm = cmd.apply(scanner);
        String destImageName = "";
        String imageName = "";
        if (in.equals("load")) {
          destImageName = scanner.next();
        } else if (in.equals("save")) {
          imageName = scanner.next();
        } else {
          imageName = scanner.next();
          destImageName = scanner.next();
        }
        this.model.acceptCommand(comm, imageName, destImageName);
      } catch (IllegalArgumentException e) {
        this.appendMessage("Invalid command or arguments\n");
      }
    }

  }

  private void renderStartupInstructions() {
    this.appendMessage("load <image-path> <image-name>\n"
            + "save <image-path> <image-name>\n"
            + "grayscale-component <image-name> <dest-image-name>\n"
            + "horizontal-flip <image-name> <dest-image-name>\n"
            + "vertical-flip <image-name> <dest-image-name>\n"
            + "brighten <increment> <image-name> <dest-image-name>\n"
            + "blur <image-name> <dest-image-name>\n"
            + "sharpen <image-name> <dest-image-name>\n"
            + "sepia-tone <image-name> <dest-image-name>\n"
            + "matrix-grayscale <image-name> <dest-image-name>\n"
            + "quit or q to quit\n");
  }

  private void appendMessage(String message) throws IllegalArgumentException {
    try {
      this.out.append(message);
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to transmit output.");
    }
  }
}