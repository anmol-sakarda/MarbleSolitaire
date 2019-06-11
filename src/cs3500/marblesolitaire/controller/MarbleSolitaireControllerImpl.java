package cs3500.marblesolitaire.controller;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;


import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class Marble Solitaire Controller Implementation which implements the MarbleSolitaireController
 * interface and implements the method playGame. This class is for the user to control the model of
 * the game, using the play game method.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {


  /**
   * The Readable represents the String input given by the user. The Appendable represents the
   * String output after the user plays the game.
   */
  private final Readable rd;
  private final Appendable ap;

  /**
   * Constructor that creates an instance of the MarbleSolitaireControllerImpl.
   *
   * @param rd represents an existing interface in Java that abstracts the input.
   * @param ap represents an existing interface in Java that abstracts the output.
   * @throws IllegalArgumentException throws illegal argument exception if one but not both
   *                                  arguments are null.
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if ((rd == null || ap == null)) {
      throw new IllegalArgumentException();
    }
    this.rd = rd;
    this.ap = ap;

  }


  /**
   * This method should play a new game of Marble Solitaire using the provided model.
   *
   * @param model Uses the given model to play a new game.
   * @throws IllegalArgumentException if the input is null.
   * @throws IllegalStateException    if the controller is unable to successfully receive input or
   *                                  transmit output.
   */
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException,
          IllegalStateException {
    ArrayList<Integer> inputs = new ArrayList<>();
    if (model == null) {
      throw new IllegalArgumentException();
    }


    String originalMsg = model.getGameState() + "\n Score: " + model.getScore() + "\n";
    appendToAp(originalMsg);

    String command;
    Scanner scanner = new Scanner(this.rd);
    while (scanner.hasNext()) {
      command = scanner.next();

      if (command.equals("q") || command.equals("Q")) {
        String msg = "\nGame " + command + "uit!\nState of game when quit:\n" + model.getGameState()
                + "\n" + "Score: " + model.getScore() + "\n";
        appendToAp(msg);
        return;
      }
      /**
       * Checks to see if the given command is an integer.
       */
      try {
        if (Integer.parseInt(command) > 0) {
          inputs.add(Integer.parseInt(command));
        }
      } catch (NumberFormatException e) {
        String msg = "Invalid move. Play again. You need to enter an integer." + "\n";
        appendToAp(msg);
      }

      if (inputs.size() >= 4) {
        /**
         * throws IllegalStateException if unable to move using the given coordinates and append
         * the appropriate message properly.
         */
        try {
          model.move(inputs.get(0) - 1, inputs.get(1) - 1,
                  inputs.get(2) - 1, inputs.get(3) - 1);
          String msg = model.getGameState() + "\n" + "Score: " + model.getScore() + "\n";
          appendToAp(msg);
        } catch (IllegalArgumentException e) {
          String msg = e.getMessage();
          appendToAp(msg + "\n");
        }
        while (inputs.size() > 0) {
          inputs.remove(0);
        }
      }
      if (model.isGameOver()) {
        String msg = "Game over!\n" + model.getGameState() + "\n" + "Score: " + model.getScore()
                + "\n";
        appendToAp(msg);
        return;
      }

    }
    throw new IllegalStateException();


  }

  /**
   * Method appends the given message to the appendable.
   *
   * @param msg represents the message that needs to be appended to the appendable.
   */
  private void appendToAp(String msg) {
    /**
     * Throws IllegalStateException if unable to append the given message.
     */
    try {
      this.ap.append(msg);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }


}


