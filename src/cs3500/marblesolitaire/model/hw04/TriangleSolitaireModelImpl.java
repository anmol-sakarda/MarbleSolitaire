package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.GamePiece;

/**
 * Class for representing the Triangle Solitaire Game and extends the Abstract Solitaire Model.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModelImpl {


  /**
   * The first constructor should take no parameters, and initialize the game board as shown above
   * (arm thickness 3 with the empty slot at the center).
   */
  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
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
  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    this(5, sRow, sCol);
  }


  /**
   * The third constructor should take the arm thickness as its only parameter and initialize a game
   * board with the empty slot at the center. It should throw an IllegalArgumentException if the arm
   * thickness is not a positive odd number.
   *
   * @param length represents the arm thickness of the game which determines the size of the game
   *               board
   */
  public TriangleSolitaireModelImpl(int length) {

    this(length, 0,
            0);

  }


  /**
   * Fourth constructor should take the arm thickness, row and column of the empty slot in that
   * order. It should throw an IllegalArgumentException if the arm thickness is not a positive odd
   * number, or the empty cell position is invalid.
   *
   * @param length represents the arm thickness of the game which determines the size of the game
   *               board
   * @param sCol   represents the column of the game board which should be empty.
   * @param sRow   represents teh row of the game board which should be empty.
   * @throws IllegalArgumentException if the given position is invalid.
   */
  public TriangleSolitaireModelImpl(int length, int sRow, int sCol)
          throws IllegalArgumentException {
    if (length <= 1) {
      throw new IllegalArgumentException("Arm Thickness must be odd and positive");
    }
    this.initGameBoard(length);
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
   * @param length represents the arm length to determine the size of the game board.
   */
  private void initGameBoard(int length) {
    for (int i = 0; i < length; i++) {
      ArrayList<GamePiece> temp = new ArrayList<>();
      for (int j = 0; j < i + 1; j++) {
        temp.add(GamePiece.Marble);
      }
      this.gameBoard.add(i, temp);
    }
  }


  /**
   * Determines if the movement from one position to another is possible and executes the movement.
   *
   * @param fromCol represents the column for which the marble is moving from.
   * @param fromRow represents the row for which the marble is moving from.
   * @param toCol   represents the column for which the marble is moving to.
   * @param toRow   represents the row for which the marble is moving to.
   */
  protected void determineSideToMove(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (fromCol == toCol && fromRow == toRow + 2 && checkPosCoords(toRow + 1, toCol)
            && this.gameBoard.get(fromRow - 1).get(fromCol).isMarble()) {
      this.gameBoard.get(fromRow).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(fromRow - 1).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(toRow).set(toCol, GamePiece.Marble);
    } else if (fromCol == toCol && fromRow == toRow - 2 && checkPosCoords(toRow - 1, toCol)
            && this.gameBoard.get(fromRow + 1).get(fromCol).isMarble()) {
      this.gameBoard.get(fromRow).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(fromRow + 1).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(toRow).set(toCol, GamePiece.Marble);
    } else if (fromCol == toCol + 2 && fromRow == toRow && checkPosCoords(toRow, toCol + 1)
            && this.gameBoard.get(fromRow).get(fromCol - 1).isMarble()) {
      this.gameBoard.get(fromRow).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(fromRow).set(fromCol - 1, GamePiece.Empty);
      this.gameBoard.get(toRow).set(toCol, GamePiece.Marble);
    } else if (fromCol == toCol - 2 && fromRow == toRow && checkPosCoords(toRow, toCol - 1)
            && this.gameBoard.get(fromRow).get(fromCol + 1).isMarble()) {
      this.gameBoard.get(fromRow).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(fromRow).set(fromCol + 1, GamePiece.Empty);
      this.gameBoard.get(toRow).set(toCol, GamePiece.Marble);

    } else if (fromCol == toCol - 2 && fromRow == toRow - 2 && checkPosCoords(toRow - 1, toCol - 1)
            && this.gameBoard.get(fromRow + 1).get(fromCol + 1).isMarble()) {
      this.gameBoard.get(fromRow).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(fromRow + 1).set(fromCol + 1, GamePiece.Empty);
      this.gameBoard.get(toRow).set(toCol, GamePiece.Marble);
    } else if (fromCol == toCol + 2 && fromRow == toRow + 2 && checkPosCoords(toRow + 1, toCol + 1)
            && this.gameBoard.get(fromRow - 1).get(fromCol - 1).isMarble()) {
      this.gameBoard.get(fromRow).set(fromCol, GamePiece.Empty);
      this.gameBoard.get(fromRow - 1).set(fromCol - 1, GamePiece.Empty);
      this.gameBoard.get(toRow).set(toCol, GamePiece.Marble);
    } else {

      throw new IllegalArgumentException("Invalid Move Requested");
    }
  }


  /**
   * returns whether or not the current game piece at the given coordinates is movable.
   *
   * @param i represents the row of the game board piece to check if it is movable.
   * @param j represents the column of the game board piece to check if it is movable.
   * @return true if the current game piece at the given coordinates is movable, false otherwise.
   */
  protected boolean movable(int i, int j) {
    if (!checkPosCoords(i, j)) {
      return false;
    }
    if (checkPosCoords(i + 1, j + 1) && checkPosCoords(i + 2, j + 2)) {
      if (getGamePieceAt(i + 1, j + 1).equals(GamePiece.Marble)
              && getGamePieceAt(i + 2, j + 2).equals(GamePiece.Empty)) {
        return true;
      }
    }
    if (checkPosCoords(i - 1, j - 1) && checkPosCoords(i - 2, j - 2)) {
      if (getGamePieceAt(i - 1, j - 1).equals(GamePiece.Marble)
              && getGamePieceAt(i - 2, j - 2).equals(GamePiece.Empty)) {
        return true;
      }
    }
    if (checkPosCoords(i + 1, j) && checkPosCoords(i + 2, j)) {
      if (getGamePieceAt(i, j).equals(GamePiece.Marble) &&
              getGamePieceAt(i + 1, j).equals(GamePiece.Marble)
              && getGamePieceAt(i + 2, j).equals(GamePiece.Empty)) {
        return true;
      }
    }
    if (checkPosCoords(i - 1, j) && checkPosCoords(i - 2, j)) {
      if (getGamePieceAt(i, j).equals(GamePiece.Marble) &&
              getGamePieceAt(i - 1, j).equals(GamePiece.Marble)
              && getGamePieceAt(i - 2, j).equals(GamePiece.Empty)) {
        return true;
      }
    }
    if (checkPosCoords(i, j + 1) && checkPosCoords(i, j + 2)) {
      if (getGamePieceAt(i, j).equals(GamePiece.Marble) &&
              getGamePieceAt(i, j + 1).equals(GamePiece.Marble)
              && getGamePieceAt(i, j + 2).equals(GamePiece.Empty)) {
        return true;
      }
    }
    if (checkPosCoords(i, j) && checkPosCoords(i, j - 1) && checkPosCoords(i, j - 2)) {
      if (getGamePieceAt(i, j).equals(GamePiece.Marble) &&
              getGamePieceAt(i, j - 1).equals(GamePiece.Marble)
              && getGamePieceAt(i, j - 2).equals(GamePiece.Empty)) {
        return true;
      }
    }

    return false;

  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single character (O, X or space for
   * a marble, empty and invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String getGameState() {
    String rows = "";
    for (int i = 0; i < this.gameBoard.size(); i++) {
      String cols = "";
      double spacing = (this.gameBoard.size() - 1 - i);
      while (spacing >= 1) {
        cols = cols + " ";
        spacing = spacing - 1;
      }
      for (int j = 0; j < this.gameBoard.get(i).size() - 1; j++) {
        cols = cols + this.getGamePieceAt(i, j) + " ";
      }
      cols = cols + this.getGamePieceAt(i, this.gameBoard.get(i).size() - 1);
      if (i == this.gameBoard.size() - 1) {
        rows += cols;
      } else {
        rows += cols + "\n";
      }
    }
    return rows;
  }


}
