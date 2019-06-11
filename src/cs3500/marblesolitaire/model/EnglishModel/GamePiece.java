package cs3500.marblesolitaire.model.hw02;

/**
 * Enumeration of the game piece. A game piece can be either a marble, empty, or invalid.
 */
public enum GamePiece {
  // Define each named value, passing an argument into the constructor
  Marble('O'), Empty('_'), Invalid(' ');

  // Define some fields:
  private final char value;

  // Define the constructor
  GamePiece(char value) {
    this.value = value;
  }

  // Define some methods

  @Override
  public String toString() {
    return this.value + "";
  }

  /**
   * checks if this game piece is a marble by checking its value.
   *
   * @return true if this game piece is a marble, false otherwise.
   */
  public boolean isMarble() {
    return this.value == 'O';
  }

  /**
   * checks if this game piece is empty by checking its value.
   *
   * @return true if this game piece is empty, false otherwise.
   */
  public boolean isEmpty() {
    return this.value == '_';
  }

  /**
   * checks if this game piece is invalid by checking its value.
   *
   * @return true if this game piece is invalid, false otherwise
   */
  public boolean isInValid() {
    return this.value == ' ';
  }
}