package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.GamePiece;

/**
 * Class for representing an European Solitaire Model which extends the Abstract Solitaire model.
 */
public class EuropeanSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * The first constructor should take no parameters, and initialize the game board as shown above
   * (arm thickness 3 with the empty slot at the center).
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }


  /**
   * A second constructor should take two parameters: sRow and sCol. It should initialize the game
   * board so that the arm thickness is 3 and the empty slot is at the position (sRow, sCol) . If
   * this specified position is invalid, it should throw an IllegalArgumentException with a message
   * "Invalid empty cell position (r,c)" with r and c replaced with the row and column passed to
   * it.
   *
   * @param sCol represents the column of the game board which should be empty.
   * @param sRow represents teh row of the game board which should be empty.
   */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }


  /**
   * The third constructor should take the arm thickness as its only parameter and initialize a game
   * board with the empty slot at the center. It should throw an IllegalArgumentException if the arm
   * thickness is not a positive odd number.
   *
   * @param armThickness represents the arm thickness of the game which determines the size of the
   *                     game board
   */
  public EuropeanSolitaireModelImpl(int armThickness) {

    this(armThickness, (3 * armThickness - 3) / 2,
            (3 * armThickness - 3) / 2);

  }


  /**
   * Fourth constructor should take the arm thickness, row and column of the empty slot in that
   * order. It should throw an IllegalArgumentException if the arm thickness is not a positive odd
   * number, or the empty cell position is invalid.
   *
   * @param armThickness represents the arm thickness of the game which determines the size of the
   *                     game board
   * @param sCol         represents the column of the game board which should be empty.
   * @param sRow         represents teh row of the game board which should be empty.
   * @throws IllegalArgumentException if the given position is invalid.
   */
  public EuropeanSolitaireModelImpl(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    if (armThickness % 2 == 0 || armThickness <= 1) {
      throw new IllegalArgumentException("Arm Thickness must be odd and positive");
    }
    this.initGameBoard(armThickness);
    this.makeInvalidCells(armThickness);
    if (pieceIsValid(sRow, sCol)) {
      this.gameBoard.get(sRow).set(sCol, GamePiece.Empty);
    } else {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " + sCol
              + ")");
    }

  }

  /**
   * Initializes every cell in the game board to be empty.
   *
   * @param armLength represents the arm length to determine the size of the game board.
   */
  private void initGameBoard(int armLength) {
    for (int i = 0; i < armLength - 1; i++) {
      ArrayList<GamePiece> temp = new ArrayList<>();
      for (int j = 0; j < 2 * armLength - 1 + i; j++) {
        temp.add(GamePiece.Marble);
      }
      this.gameBoard.add(temp);
    }
    for (int i = armLength - 1; i < 2 * armLength - 1; i++) {
      ArrayList<GamePiece> temp = new ArrayList<>();
      for (int j = 0; j < 3 * armLength - 2; j++) {
        temp.add(GamePiece.Marble);
      }
      this.gameBoard.add(i, temp);
    }

    for (int i = 2 * armLength - 1; i < 3 * armLength - 2; i++) {
      ArrayList<GamePiece> temp = new ArrayList<>();
      for (int j = 0; j < 5 * armLength - 4 - i; j++) {
        temp.add(GamePiece.Marble);
      }
      this.gameBoard.add(i, temp);
    }
  }

  /**
   * Sets certain cells as invalid based on the arm length.
   *
   * @param armLength represents the given arm length to determine the size of the game board.
   */
  private void makeInvalidCells(int armLength) {
    for (int i = 0; i < armLength - 1; i++) {
      for (int j = 0; j < armLength - 1 - i; j++) {
        this.gameBoard.get(i).set(j, GamePiece.Invalid);
      }
    }
    for (int i = 2 * armLength - 1; i < this.gameBoard.size(); i++) {
      for (int j = 0; j < i - 2 * armLength + 2; j++) {
        this.gameBoard.get(i).set(j, GamePiece.Invalid);
      }
    }
  }


}
