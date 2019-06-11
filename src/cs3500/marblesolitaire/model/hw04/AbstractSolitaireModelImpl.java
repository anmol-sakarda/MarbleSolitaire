package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.GamePiece;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract class for the MarbleSolitaireModel that implements MarbleSolitaireModel.
 */
public abstract class AbstractSolitaireModelImpl implements MarbleSolitaireModel {

  /**
   * 2-D array of game pieces that constitute the game board. int to represent the armThickness
   */
  protected final ArrayList<ArrayList<GamePiece>> gameBoard = new ArrayList<>();

  /**
   * Takes in a pair of coordinates and determines if the game piece is invalid.
   *
   * @param i represents the row of the game board.
   * @param j represents the column of the game board.
   * @return boolean
   * @throws IllegalArgumentException if the given coordinates are invalid.
   */
  protected boolean pieceIsValid(int i, int j) throws IllegalArgumentException {
    if (checkPosCoords(i, j)) {
      return !this.gameBoard.get(i).get(j).isInValid();
    }
    throw new IllegalArgumentException("Invalid Inputs");
  }


  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!checkPosCoords(fromRow, fromCol) && !checkPosCoords(toRow, toCol)) {
      throw new IllegalArgumentException("Invalid Move Requested. Please fix To and From " +
              "Arguments");
    }
    if (!checkPosCoords(fromRow, fromCol)) {
      throw new IllegalArgumentException("Invalid Move Requested. Please fix From " +
              "Arguments");
    }
    if (!checkPosCoords(toRow, toCol)) {
      throw new IllegalArgumentException("Invalid Move Requested. Please fix To" +
              "Arguments");
    }
    if (!this.gameBoard.get(fromRow).get(fromCol).isMarble()
            || !this.gameBoard.get(toRow).get(toCol).isEmpty()) {
      throw new IllegalArgumentException("Invalid Move Requested");
    }
    determineSideToMove(fromRow, fromCol, toRow, toCol);
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

    } else {
      throw new IllegalArgumentException("Invalid Move Requested");
    }
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    if (this.getScore() == 1 ) {
      return true;
    }

    for (int i = 0; i < this.gameBoard.size(); i++) {
      for (int j = 0; j < this.gameBoard.get(i).size(); j++) {
        if (movable(i, j)) {
          return false;
        }
      }
    }

    return true;
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

  /**
   * returns the gamePiece at the given row and column.
   *
   * @param col represents the column of the game piece.
   * @param row represents the row of the game piece.
   * @return the gamePiece at the given row and column.
   * @throws IllegalArgumentException if the requested row and columns are not on the board.
   */
  protected GamePiece getGamePieceAt(int row, int col) throws IllegalArgumentException {
    if (checkPosCoords(row, col)) {
      return this.gameBoard.get(row).get(col);
    }
    throw new IllegalArgumentException("Invalid Arguments");
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int count = 0;
    for (int i = 0; i < this.gameBoard.size(); i++) {
      for (int j = 0; j < this.gameBoard.get(i).size(); j++) {
        if (this.gameBoard.get(i).get(j).isMarble()) {
          count += 1;
        }
      }
    }
    return count;
  }


  /**
   * Checks to see if the given coordinates are on the game board.
   *
   * @param i represents the row of the game board to check.
   * @param j represents the column of the game board to check.
   * @return true if given coordinates are on game board, false otherwise.
   */
  protected boolean checkPosCoords(int i, int j) {
    return (i >= 0 && i < this.gameBoard.size() && j >= 0 && j < this.gameBoard.get(i).size());
  }
}
