package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

/**
 * Game Play that takes in the type of game and creates the respective game.
 */
public final class MarbleSolitaire {

  /**
   * Main method that accepts and executes on command line arguments.
   *
   * @param args Arguments that set the game and moves
   */
  public static void main(String[] args) {
    MarbleSolitaireModel marbleSolitaire = new MarbleSolitaireModelImpl();
    switch (args[0]) {
      case "english":
        if (args.length == 3 && args[1].equals("-size")) {
          marbleSolitaire = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]));
        } else if (args.length == 4 && args[1].equals("-hole")) {
          marbleSolitaire = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));

        } else if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
          marbleSolitaire = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[4]), Integer.parseInt(args[5]));
        } else if (args.length == 6 && args[1].equals("-hole") && args[4].equals("-size")) {
          marbleSolitaire = new MarbleSolitaireModelImpl(Integer.parseInt(args[5]),
                  Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else {
          marbleSolitaire = new MarbleSolitaireModelImpl();
        }
        break;
      case "european":
        if (args.length == 3 && args[1].equals("-size")) {
          marbleSolitaire = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]));

        } else if (args.length == 4 && args[1].equals("-hole")) {
          marbleSolitaire = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
        } else if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {
          marbleSolitaire = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[4]), Integer.parseInt(args[5]));
        } else if (args.length == 6 && args[1].equals("-hole") && args[4].equals("-size")) {
          marbleSolitaire = new MarbleSolitaireModelImpl(Integer.parseInt(args[5]),
                  Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else {
          marbleSolitaire = new EuropeanSolitaireModelImpl();
        }
        break;
      case "triangular":
        if (args.length == 3 && args[1].equals("-size")) {
          marbleSolitaire = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]));
        } else if (args.length == 4 && args[1].equals("-hole")) {
          marbleSolitaire = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
        } else if (args.length == 6 && args[1].equals("-size") && args[3].equals("-hole")) {

          marbleSolitaire = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[4]), Integer.parseInt(args[5]));

        } else if (args.length == 6 && args[1].equals("-hole") && args[4].equals("-size")) {
          marbleSolitaire = new TriangleSolitaireModelImpl(Integer.parseInt(args[5]),
                  Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else {
          marbleSolitaire = new TriangleSolitaireModelImpl();
        }
        break;
      default:
        // All cases covered.
    }
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(marbleSolitaire);
  }
}