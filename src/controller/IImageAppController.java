package controller;

/**
 * Interface to represent all relevant methods for a
 * controller for the Image App.
 */
public interface IImageAppController {

  /**
   * Runs the program with simple text based scripting input commands.
   * @throws IllegalArgumentException if the controller is unable to
   *                                  read input
   *                                  if the controller is unable to
   *                                  transmit the output.
   */
  public void runProgram() throws IllegalArgumentException;
}
