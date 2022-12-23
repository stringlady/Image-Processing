package controller;

import java.util.HashMap;
import java.util.Map;

import commands.Load;
import model.IImage;
import model.IImageAppModel;
import view.ButtonListener;
import view.Histogram;
import view.IView;

/**
 * A class to represent a Controller for an ImageAppModel. This controls
 * passage of data from the basic text based scripting to the Model.
 */
public class ImageAppBetterController {
  private final IImageAppModel model;

  private IView view;

  private int i;

  /**
   * A constructor for an ImageAppController. Initializes relevant fields.
   *
   * @param model the model containing data for the app.
   * @throws IllegalArgumentException if any arguments passed
   *                                  to the controller are null.
   */
  public ImageAppBetterController(IImageAppModel model) {
    if (model == null) {
      throw new IllegalArgumentException("Arguments cannot be null.");
    }

    this.model = model;
    i = 0;
  }

  public void setView(IView v) {
    this.view = v;
    //create and set the keyboard listener
    configureButtonListener();
  }

  private void configureButtonListener() {
    Map<String, Runnable> buttonClickedMap = new HashMap<String, Runnable>();
    ButtonListener buttonListener = new ButtonListener();

    buttonClickedMap.put("Load", () -> {
      String absPath = view.getFileToLoad();
      IImage i = new Load(absPath).run(null);
      this.model.putImage(Integer.toString(this.i), i);
      this.view.displayImage(ImageUtil.toBufferedImage(i));
      this.view.setHist(new Histogram[]{new Histogram(i, 1), new Histogram(i, 2),
              new Histogram(i, 3), new Histogram(i, 0)});
    });
    buttonClickedMap.put("Save", () -> {
      System.exit(0);
    });

    buttonListener.setButtonClickedActionMap(buttonClickedMap);
    this.view.addActionListener(buttonListener);

  }

  private void addButtonCommand() {

  }





  /**
   * Runs the program with simple text based scripting input commands.
   *
   * @throws IllegalArgumentException if the controller is unable to
   *                                  read input
   *                                  if the controller is unable to
   *                                  transmit the output.

  @Override
  public void runProgram() throws IllegalArgumentException {
    Map<String, Function<Scanner, ICommand>> knownCommands = new HashMap<>();
    knownCommands.put("load", (Scanner s) -> {return new Load(s.next()); });
    knownCommands.put("save", (Scanner s) -> {return new Save(s.next()); });
    knownCommands.put("brighten", (Scanner s) -> {return new Brighten(s.nextInt()); });
    knownCommands.put("grayscale-red", (Scanner s) -> {return new RedGrayscale(); });
    knownCommands.put("grayscale-green", (Scanner s) -> {return new GreenGrayscale(); });
    knownCommands.put("grayscale-blue", (Scanner s) -> {return new BlueGrayscale(); });
    knownCommands.put("grayscale-value", (Scanner s) -> {return new Value(); });
    knownCommands.put("grayscale-intensity", (Scanner s) -> {return new Intensity(); });
    knownCommands.put("grayscale-luma", (Scanner s) -> {return new Luma(); });
    knownCommands.put("vertical-flip", (Scanner s) -> {return new VerticalFlip(); });
    knownCommands.put("horizontal-flip", (Scanner s) -> {return new HorizontalFlip(); });
    knownCommands.put("blur", (Scanner s) -> {return new Blur(); });
    knownCommands.put("sharpen", (Scanner s) -> {return new Sharpen(); });
    knownCommands.put("matrix-grayscale", (Scanner s) -> {return new Grayscale(); });
    knownCommands.put("sepia-tone", (Scanner s) -> {return new SepiaTone(); });

    Scanner scanner = new Scanner(this.in);
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
**/


}