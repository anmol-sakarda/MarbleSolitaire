import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing the Controller Implementation.
 */
public class MarbleSolitaireControllerImplTest {
  MarbleSolitaireModel exampleOneEnglish = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel exampleTwoEnglish = new MarbleSolitaireModelImpl(5);
  MarbleSolitaireModel exampleThreeEnglish = new MarbleSolitaireModelImpl(4, 6);
  MarbleSolitaireModel exampleFourEnglish = new MarbleSolitaireModelImpl(5, 5, 5);

  @Test
  public void testMakeOneMoveThenSmallQuitEnglish() {
    String test = "4 6 4 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitEnglish() {
    String test = "4 6 4 4 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }

  @Test
  public void testWinGameEnglish() {
    String test = "4 6 4 4 6 5 4 5 5 7 5 5 5 4 5 6 5 2 5 4 7 3 5 3 4 3 6 3 7 5 7 3 7 3 5 3 3 5 5 " +
            "5 1 5 3 5 2 3 4 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 2 5 3 7 5 7 5 7 5 5 5 5 5 3 3 1 3 3 3 " +
            "4 3 2 5 1 3 1 3 1 3 3 1 3 1 5 1 5 3 5 3 6 3 4 3 4 3 2 3 2 5 2 5 2 5 4 5 4 3 4 2 4 4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertTrue(output.toString().endsWith("Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n"));
  }

  @Test
  public void testLoseGameWithOneMarbleEnglish() {
    String test = "4 6 4 4 6 5 4 5 5 7 5 5 5 4 5 6 5 2 5 4 7 3 5 3 4 3 6 3 7 5 7 3 7 3 5 3 3 5 5 " +
            "5 1 5 3 5 2 3 4 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 2 5 3 7 5 7 5 7 5 5 5 5 5 3 3 1 3 3 3 " +
            "4 3 2 5 1 3 1 3 1 3 3 1 3 1 5 1 5 3 5 3 6 3 4 3 4 3 2 3 2 5 2 5 2 5 4 5 4 3 4 3 4 1 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertTrue(output.toString().endsWith("Game over!\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n"));
  }

  @Test
  public void testLoseGameWithManyMarbleEnglish() {
    String test = "4 6 4 4 6 5 4 5 5 7 5 5 5 4 5 6 5 2 5 4 7 3 5 3 4 3 6 3 7 5 7 3 7 3 5 3 3 5 5 " +
            "5 1 5 3 5 2 3 4 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 2 5 3 7 5 7 5 7 5 5 5 5 5 3 3 1 3 3 3 " +
            "4 3 2 5 1 3 1 3 1 3 3 1 3 1 5 1 5 3 5 3 6 3 4 3 4 3 2 3 2 5 2 5 2 5 4 4 4 6 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertTrue(output.toString().endsWith("Game over!\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2\n"));
  }

  @Test
  public void testLoseGameWithManyMarbleWithQEnglish() {
    String test = "4 6 4 4 6 5 4 5 5 7 5 5 5 4 5 6 5 2 5 4 7 3 5 3 4 3 6 3 7 5 7 3 7 3 5 3 3 5 5 " +
            "5 1 5 3 5 2 3 4 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 2 5 3 7 5 7 5 7 5 5 5 5 5 3 3 1 3 3 3 " +
            "4 3 2 5 1 3 1 3 1 3 3 1 3 1 5 1 5 3 5 3 6 3 4 3 4 3 2 3 2 5 2 5 2 5 4 4 4 6 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertTrue(output.toString().endsWith("Game over!\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2\n"));
  }

  @Test
  public void testMakeOneMoveWithSomeLetterThenQuitEnglish() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "Invalid move. Play again. You need to enter an integer.\n" +
            "Invalid move. Play again. You need to enter an integer.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInputModelIsNullEnglish() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(null);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalStateExceptionEnglish() {
    String test = "4 6 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    exampleOneMSC.playGame(this.exampleOneEnglish);

  }

  @Test
  public void testMakeOneMoveFirstBadInputThenQuitEnglish() {
    String test = "4 6 4 15 4 6 4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "Invalid Move Requested. Please fix ToArguments\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutputIsNullEnglish() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, null);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInputIsNullEnglish() {
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(null, output);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutputInputIsNullEnglish() {
    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(null, null);

  }

  @Test
  public void testMakeInputNegativesEnglish() {
    String test = "-1 4 6 -3 4 4 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }


  @Test
  public void testBadInputThenGoodInputEnglish() {
    String test = "4 4 4 6 4 6 4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "Invalid Move Requested\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }


  @Test
  public void testBadInputThenQEnglish() {
    String test = "4 4 4 6 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "Invalid Move Requested\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n"), output.toString());

  }

  @Test
  public void testLessInputEnglish() {
    String test = "4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n"), output.toString());

  }

  @Test
  public void testNegInputEnglish() {
    String test = "-4 4 4 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n"), output.toString());

  }

  @Test
  public void testLessInputButThenQuitEnglish() {
    String test = "4 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample2English() {
    String test = "6 8 6 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleTwoEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            " Score: 104\n" +
            "Invalid Move Requested\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample2English() {
    String test = "6 8 6 6 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleTwoEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            " Score: 104\n" +
            "Invalid Move Requested\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample3English() {
    String test = "5 5 5 7 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleThreeEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample3English() {
    String test = "5 5 5 7 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleThreeEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            " Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample4English() {
    String test = "4 6 6 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleFourEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            " Score: 104\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O _ O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O _ O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample4English() {
    String test = "4 6 6 6 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleFourEnglish);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            " Score: 104\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O _ O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O _ O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n"), output.toString());
  }

  MarbleSolitaireModel exampleOneEuropean = new EuropeanSolitaireModelImpl();
  MarbleSolitaireModel exampleTwoEuropean = new EuropeanSolitaireModelImpl(5);
  MarbleSolitaireModel exampleThreeEuropean = new EuropeanSolitaireModelImpl(4, 6);
  MarbleSolitaireModel exampleFourEuropean = new EuropeanSolitaireModelImpl(5, 5, 5);
  MarbleSolitaireModel exampleFiveEuropean = new EuropeanSolitaireModelImpl(0, 2);

  @Test
  public void testMakeOneMoveThenSmallQuitEuropean() {
    String test = "4 6 4 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitEuropean() {
    String test = "4 6 4 4 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }

  @Test
  public void testWinGameEuropean() {


    String test = "4 6 4 4 6 5 4 5 5 7 5 5 5 4 5 6 5 2 5 4 7 3 5 3 4 3 6 3 7 5 7 3 7 3 5 3 3 5 5" +
            " 5 1 5 3 5 2 3 4 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 2 5 3 7 5 7 5 7 5 5 5 5 5 3 3 1 3 3 3" +
            " 4 3 2 5 1 3 1 3 1 3 3 1 3 1 5 1 5 3 5 3 6 3 4 3 4 3 2 3 2 5 2 5 2 5 4 5 4 3 4 2 4 4" +
            " 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }
    //assertEquals("", output.toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O O O O _ O O\n" +
            "  O O O _ O\n" +
            "    O O O\n" +
            "Score: 34\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O O O O O _ _\n" +
            "  O O O _ O\n" +
            "    O O O\n" +
            "Score: 33\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O O O _ _ O _\n" +
            "  O O O _ O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O _ _ O _ O _\n" +
            "  O O O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O _ O O _ O _\n" +
            "  O _ O _ O\n" +
            "    _ O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O _ O\n" +
            "O _ _ O _ O _\n" +
            "  O O O _ O\n" +
            "    _ O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O _ O\n" +
            "O _ _ O _ O _\n" +
            "  O O O _ O\n" +
            "    O _ _\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O _ O\n" +
            "O _ O O _ O _\n" +
            "  O _ O _ O\n" +
            "    _ _ _\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O _ O O\n" +
            "O O _ O _ _ O\n" +
            "O _ O O O O _\n" +
            "  O _ O _ O\n" +
            "    _ _ _\n" +
            "Score: 26\n" +
            "    O O _\n" +
            "  O O O _ O\n" +
            "O O O O O O O\n" +
            "O O _ O _ _ O\n" +
            "O _ O O O O _\n" +
            "  O _ O _ O\n" +
            "    _ _ _\n" +
            "Score: 25\n" +
            "    O O _\n" +
            "  O _ O _ O\n" +
            "O O _ O O O O\n" +
            "O O O O _ _ O\n" +
            "O _ O O O O _\n" +
            "  O _ O _ O\n" +
            "    _ _ _\n" +
            "Score: 24\n" +
            "    O O _\n" +
            "  O _ O _ O\n" +
            "O O _ O O O O\n" +
            "O O _ O _ _ O\n" +
            "O _ _ O O O _\n" +
            "  O O O _ O\n" +
            "    _ _ _\n" +
            "Score: 23\n" +
            "    O O _\n" +
            "  O _ O _ O\n" +
            "O O _ O O O O\n" +
            "O O _ O _ _ O\n" +
            "O _ _ O O O _\n" +
            "  O _ _ O O\n" +
            "    _ _ _\n" +
            "Score: 22\n" +
            "    O O _\n" +
            "  O _ O _ O\n" +
            "O O _ O O O O\n" +
            "O O _ O O _ O\n" +
            "O _ _ O _ O _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 21\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "O O _ O _ O O\n" +
            "O O _ O _ _ O\n" +
            "O _ _ O _ O _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 20\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "O O _ O _ O _\n" +
            "O O _ O _ _ _\n" +
            "O _ _ O _ O O\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 19\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "O O _ O _ O _\n" +
            "O O _ O _ _ _\n" +
            "O _ _ O O _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 18\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "O O _ O _ O _\n" +
            "O O _ O _ _ _\n" +
            "O _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 17\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "_ _ O O _ O _\n" +
            "O O _ O _ _ _\n" +
            "O _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 16\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "_ O _ _ _ O _\n" +
            "O O _ O _ _ _\n" +
            "O _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 15\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "O O _ _ _ O _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 14\n" +
            "    O O _\n" +
            "  O _ O O O\n" +
            "_ _ O _ _ O _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 13\n" +
            "    _ _ O\n" +
            "  O _ O O O\n" +
            "_ _ O _ _ O _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "    _ _ _\n" +
            "  O _ O _ O\n" +
            "_ _ O _ O O _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "  O _ O _ O\n" +
            "_ _ O O _ _ _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "  O _ O _ O\n" +
            "_ O _ _ _ _ _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "  O _ O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "  O _ O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "  O _ O _ O\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "  O _ _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "  O _ _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _\n" +
            "Score: 5\n", output.toString());
  }

  @Test
  public void testLoseGameWithManyMarbleEuropean() {

    String test = "3 3 1 3 3 1 3 3 2 5 2 3 4 5 2 5 4 3 4 5 3 4 3 2 6 4 4 4 4 1 4 3 6 2 4 2 5 6 "
            + "5 4 6 6 6 4 1 5 3 5 3 2 5 2 3 5 5 5 6 3 6 5 4 7 4 5 2 2 2 4 3 7 3 5 1 4 3 4 4 3 6 "
            + "3 4 5 4 3 7 3 5 3 4 3 6 3 5 1 5 3 5 4 5 2 7 5 7 3 7 3 5 3 5 2 5 4 5 4 5 6 5 7 5 5 "
            + "6 5 4 5 4 5 2 5 2 6 2 4 3 4 1 4 1 3 1 5";
    //assertEquals("", this.exampleFiveEuropean.getGameState());
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleFiveEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }
    assertTrue(output.toString().endsWith("Game over!\n" +
            "    _ _ O\n" +
            "  _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n"));
  }

  @Test
  public void testMakeOneMoveWithSomeLetterThenQuitEuropean() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "Invalid move. Play again. You need to enter an integer.\n" +
            "Invalid move. Play again. You need to enter an integer.\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInputModelIsNullEuropean() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(null);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalStateExceptionEuropean() {
    String test = "4 6 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    exampleOneMSC.playGame(this.exampleOneEuropean);

  }

  @Test
  public void testMakeOneMoveFirstBadInputThenQuitEuropean() {
    String test = "4 6 4 15 4 6 4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "Invalid Move Requested. Please fix ToArguments\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutputIsNullEuropean() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, null);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInputIsNullEuropean() {
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(null, output);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutputInputIsNullEuropean() {
    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(null, null);

  }

  @Test
  public void testMakeInputNegativesEuropean() {
    String test = "-1 4 6 -3 4 4 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }


  @Test
  public void testBadInputThenGoodInputEuropean() {
    String test = "4 4 4 6 4 6 4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "Invalid Move Requested\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }


  @Test
  public void testBadInputThenQEuropean() {
    String test = "4 4 4 6 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "Invalid Move Requested\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n"), output.toString());

  }

  @Test
  public void testLessInputEuropean() {
    String test = "4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n"), output.toString());

  }

  @Test
  public void testNegInputEuropean() {
    String test = "-4 4 4 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n"), output.toString());

  }

  @Test
  public void testLessInputButThenQuitEuropean() {
    String test = "4 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample2European() {
    String test = "6 8 6 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleTwoEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            " Score: 128\n" +
            "Invalid Move Requested\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 128\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample2European() {
    String test = "6 8 6 6 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleTwoEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            " Score: 128\n" +
            "Invalid Move Requested\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 128\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample3European() {
    String test = "5 5 5 7 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleThreeEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O _\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample3European() {
    String test = "5 5 5 7 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleThreeEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O _\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            " Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample4European() {
    String test = "4 6 6 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleFourEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            " Score: 128\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O _ O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 127\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O _ O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 127\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample4European() {
    String test = "4 6 6 6 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleFourEuropean);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            " Score: 128\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O _ O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 127\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O _ O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 127\n"), output.toString());
  }

  /*
  MarbleSolitaireModel exampleOneEuropean = new EuropeanSolitaireModelImpl();
  MarbleSolitaireModel exampleTwoEuropean = new EuropeanSolitaireModelImpl(5);
  MarbleSolitaireModel exampleThreeEuropean = new EuropeanSolitaireModelImpl(4, 6);
  MarbleSolitaireModel exampleFourEuropean = new EuropeanSolitaireModelImpl(5, 5, 5);
  MarbleSolitaireModel exampleFiveEuropean = new EuropeanSolitaireModelImpl(0, 2);

   */
  MarbleSolitaireModel exampleOneTriangular = new TriangleSolitaireModelImpl();
  MarbleSolitaireModel exampleTwoTriangular = new TriangleSolitaireModelImpl(7);
  MarbleSolitaireModel exampleThreeTriangular = new TriangleSolitaireModelImpl(1, 1);
  MarbleSolitaireModel exampleFourATriangular = new TriangleSolitaireModelImpl(7, 4, 0);
  MarbleSolitaireModel exampleFourBTriangular = new TriangleSolitaireModelImpl(7, 4, 4);
  MarbleSolitaireModel exampleFourCTriangular = new TriangleSolitaireModelImpl(7, 2, 0);
  MarbleSolitaireModel exampleFourDTriangular = new TriangleSolitaireModelImpl(7, 2, 2);
  MarbleSolitaireModel exampleFourETriangular = new TriangleSolitaireModelImpl(7, 6, 2);
  MarbleSolitaireModel exampleFourFTriangular = new TriangleSolitaireModelImpl(7, 6, 4);

  @Test
  public void testMakeOneMoveThenSmallQuitTriangular() {
    String test = "4 6 4 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitTriangular() {
    String test = "4 6 4 4 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());
  }

  @Test
  public void testWinGameTriangular() {
    String test = "3 1 1 1 3 3 3 1 5 5 3 3 2 2 4 4 5 3 3 3 5 1 5 3 5 4 5 2 5 2 3 2 4 4 2 2 4 1 2 " +
            "1 1 1 3 1 3 1 3 3";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 11\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O _\n" +
            "Score: 10\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "O O _ O _\n" +
            "Score: 9\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "_ _ O O _\n" +
            "Score: 8\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "_ O _ _ _\n" +
            "Score: 7\n" +
            "    O\n" +
            "   _ _\n" +
            "  O O O\n" +
            " O _ _ O\n" +
            "_ _ _ _ _\n" +
            "Score: 6\n" +
            "    O\n" +
            "   _ O\n" +
            "  O O _\n" +
            " O _ _ _\n" +
            "_ _ _ _ _\n" +
            "Score: 5\n" +
            "    O\n" +
            "   O O\n" +
            "  _ O _\n" +
            " _ _ _ _\n" +
            "_ _ _ _ _\n" +
            "Score: 4\n" +
            "    _\n" +
            "   _ O\n" +
            "  O O _\n" +
            " _ _ _ _\n" +
            "_ _ _ _ _\n" +
            "Score: 3\n" +
            "    _\n" +
            "   _ O\n" +
            "  _ _ O\n" +
            " _ _ _ _\n" +
            "_ _ _ _ _\n" +
            "Score: 2\n", output.toString());
  }

  @Test
  public void testLoseGameWithOneMarbleTriangular() {

    String test = "3 1 1 1 3 3 3 1 5 5 3 3 2 2 4 4 5 3 3 3 5 1 5 3 5 4 5 2 5 2 3 2 4 4 2 2 3 1 5 " +
            "1 1 1 3 3 3 3 3 1";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 11\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O _\n" +
            "Score: 10\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "O O _ O _\n" +
            "Score: 9\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "_ _ O O _\n" +
            "Score: 8\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "_ O _ _ _\n" +
            "Score: 7\n" +
            "    O\n" +
            "   _ _\n" +
            "  O O O\n" +
            " O _ _ O\n" +
            "_ _ _ _ _\n" +
            "Score: 6\n" +
            "    O\n" +
            "   _ O\n" +
            "  O O _\n" +
            " O _ _ _\n" +
            "_ _ _ _ _\n" +
            "Score: 5\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O _\n" +
            " _ _ _ _\n" +
            "O _ _ _ _\n" +
            "Score: 4\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ O O\n" +
            " _ _ _ _\n" +
            "O _ _ _ _\n" +
            "Score: 3\n" +
            "    _\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " _ _ _ _\n" +
            "O _ _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " _ _ _ _\n" +
            "O _ _ _ _\n" +
            "Score: 2\n", output.toString());
  }


  @Test
  public void testLoseGameWithManyMarbleWithQTriangular() {
    String test = "3 1 1 1 3 3 3 1 5 5 3 3 2 2 4 4 5 3 3 3 5 1 5 3 5 4 5 2 5 2 3 2 4 4 2 2 3 1 5 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 11\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O _\n" +
            "Score: 10\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "O O _ O _\n" +
            "Score: 9\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "_ _ O O _\n" +
            "Score: 8\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O _ O\n" +
            "_ O _ _ _\n" +
            "Score: 7\n" +
            "    O\n" +
            "   _ _\n" +
            "  O O O\n" +
            " O _ _ O\n" +
            "_ _ _ _ _\n" +
            "Score: 6\n" +
            "    O\n" +
            "   _ O\n" +
            "  O O _\n" +
            " O _ _ _\n" +
            "_ _ _ _ _\n" +
            "Score: 5\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   _ O\n" +
            "  O O _\n" +
            " O _ _ _\n" +
            "_ _ _ _ _\n" +
            "Score: 5\n", output.toString());
  }

  @Test
  public void testMakeOneMoveWithSomeLetterThenQuitTriangular() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid move. Play again. You need to enter an integer.\n" +
            "Invalid move. Play again. You need to enter an integer.\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInputModelIsNullTriangular() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(null);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalStateExceptionTriangular() {
    String test = "4 6 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    exampleOneMSC.playGame(this.exampleOneTriangular);

  }

  @Test
  public void testMakeOneMoveFirstBadInputThenQuitTriangular() {
    String test = "4 6 4 15 4 6 4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix To and From Arguments\n" +
            "Invalid Move Requested. Please fix From Arguments\n"), output.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutputIsNullTriangular() {
    String test = "4 6 4a 4 abc 4 q";
    StringReader input = new StringReader(test);

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, null);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInputIsNullTriangular() {
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(null, output);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutputInputIsNullTriangular() {
    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(null, null);

  }

  @Test
  public void testMakeInputNegativesTriangular() {
    String test = "-1 4 6 -3 4 4 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());
  }


  @Test
  public void testBadInputThenGoodInputTriangular() {
    String test = "4 4 4 6 4 6 4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix ToArguments\n" +
            "Invalid Move Requested. Please fix From Arguments\n"), output.toString());
  }


  @Test
  public void testBadInputThenQTriangular() {
    String test = "4 4 4 6 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix ToArguments\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());

  }

  @Test
  public void testLessInputTriangular() {
    String test = "4 4";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n"), output.toString());

  }

  @Test
  public void testNegInputTriangular() {
    String test = "-4 4 4 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());

  }

  @Test
  public void testLessInputButThenQuitTriangular() {
    String test = "4 4 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleOneTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample2Triangular() {
    String test = "6 8 6 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleTwoTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            " Score: 27\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            "Score: 27\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample2Triangular() {
    String test = "6 8 6 6 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleTwoTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            " Score: 27\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            "Score: 27\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample3Triangular() {
    String test = "5 5 5 7 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleThreeTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix ToArguments\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample3Triangular() {
    String test = "5 5 5 7 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleThreeTriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            " Score: 14\n" +
            "Invalid Move Requested. Please fix ToArguments\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenSmallQuitExample4Triangular() {
    String test = "4 6 6 6 q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleFourATriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  _ O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            " Score: 27\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  _ O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            "Score: 27\n"), output.toString());
  }

  @Test
  public void testMakeOneMoveThenBigQuitExample4Triangular() {
    String test = "4 6 6 6 Q";
    StringReader input = new StringReader(test);
    StringBuilder output = new StringBuilder();

    MarbleSolitaireController exampleOneMSC = new MarbleSolitaireControllerImpl(input, output);
    try {
      exampleOneMSC.playGame(this.exampleFourATriangular);
    } catch (IllegalStateException e) {
      e.getMessage();
    }

    assertEquals(("      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  _ O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            " Score: 27\n" +
            "Invalid Move Requested. Please fix From Arguments\n" +
            "\n" +
            "Game Quit!\n" +
            "State of game when quit:\n" +
            "      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  _ O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            "Score: 27\n"), output.toString());
  }

}

