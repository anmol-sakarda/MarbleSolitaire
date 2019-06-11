package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the operations offered by the marble solitaire controller. The
 * controller represents a user's ability to play the game.
 */
public interface MarbleSolitaireController {

  /**
   * This method should play a new game of Marble Solitaire using the provided model.
   *
   * @param model Uses the given model to play a new game.
   * @throws IllegalArgumentException if the input is null
   * @throws IllegalStateException    if the controller is unable to successfully receive input or
   *                                  transmit output.
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException;
}
