
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing.
 */
public class MarbleSolitaireModelImplTest {
  MarbleSolitaireModel exampleOne = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel exampleTwo = new MarbleSolitaireModelImpl(5);
  MarbleSolitaireModel exampleThree = new MarbleSolitaireModelImpl(4, 6);
  MarbleSolitaireModel exampleFour = new MarbleSolitaireModelImpl(5, 5, 5);

  @Test
  public void testBuildingDefaultGame() {
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            exampleOne.getGameState());

  }

  @Test
  public void testBuildingDefaultGameMoved() {
    assertEquals(32, this.exampleOne.getScore());
    this.exampleOne.move(3, 1, 3, 3);
    assertEquals(31, this.exampleOne.getScore());
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            this.exampleOne.getGameState());
    this.exampleOne.move(3, 4, 3, 2);
    assertEquals(30, this.exampleOne.getScore());
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            this.exampleOne.getGameState());

  }

  @Test
  public void testBuildingGameGivenArmThickness() {
    assertEquals("        O O O O O\n" +
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
                    "        O O O O O",
            this.exampleTwo.getGameState());

  }

  @Test
  public void testBuildingWithArmThicknessMoved() {
    assertEquals(104, this.exampleTwo.getScore());
    this.exampleTwo.move(6, 4, 6, 6);
    assertEquals(103, this.exampleTwo.getScore());
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O _ _ O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            this.exampleTwo.getGameState());
    this.exampleTwo.move(6, 2, 6, 4);
    assertEquals(102, this.exampleTwo.getScore());
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O _ _ O _ O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            this.exampleTwo.getGameState());

  }

  @Test
  public void testBuildingGameGivenEmptyCoords() {
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O _\n" +
                    "    O O O\n" +
                    "    O O O",
            this.exampleThree.getGameState());

  }

  @Test
  public void testBuildingGameGivenEmptyCoordsMoved() {
    assertEquals(32, this.exampleThree.getScore());
    this.exampleThree.move(4, 4, 4, 6);
    assertEquals(31, this.exampleThree.getScore());
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "    O O O\n" +
                    "    O O O",
            this.exampleThree.getGameState());
    this.exampleThree.move(4, 2, 4, 4);
    assertEquals(30, this.exampleThree.getScore());
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O _ _ O _ O\n" +
                    "    O O O\n" +
                    "    O O O",
            this.exampleThree.getGameState());

  }

  @Test
  public void testBuildingAllArguments() {
    assertEquals("        O O O O O\n" +
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
                    "        O O O O O",
            this.exampleFour.getGameState());

  }

  @Test
  public void testBuildingAllArgumentsMoved() {
    assertEquals(104, this.exampleFour.getScore());
    this.exampleFour.move(5, 3, 5, 5);
    assertEquals(103, this.exampleFour.getScore());
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O _ _ O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            this.exampleFour.getGameState());
    this.exampleFour.move(5, 1, 5, 3);
    assertEquals(102, this.exampleFour.getScore());
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O _ _ O _ O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            this.exampleFour.getGameState());

  }

  //Test Example 3
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutside() {
    this.exampleThree.move(4, 5, 4, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOverMarble() {
    this.exampleThree.move(4, 4, 2, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToMarble() {
    this.exampleThree.move(4, 4, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmpty() {
    this.exampleThree.move(4, 6, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInput() {
    this.exampleThree.move(4, 6, 4, 1);
  }

  // Test Example 1
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutsideEx1() {
    this.exampleThree.move(3, 2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOverMarbleEx1() {
    this.exampleThree.move(3, 1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToMarbleEx1() {
    this.exampleThree.move(3, 1, 1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmptyEx1() {
    this.exampleThree.move(3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInputEx1() {
    this.exampleThree.move(3, 3, 3, -2);
  }

  // Test Example 4
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutsideEx4() {
    this.exampleThree.move(5, 4, 5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOverMarbleEx4() {
    this.exampleThree.move(5, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToMarbleEx4() {
    this.exampleThree.move(5, 3, 5, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmptyEx4() {
    this.exampleThree.move(5, 5, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInputEx4() {
    this.exampleThree.move(5, 4, 5, 0);
  }

  // Test Example 2
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutsideEx2() {
    this.exampleThree.move(6, 5, 6, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOverMarbleEx2() {
    this.exampleThree.move(6, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToMarbleEx2() {
    this.exampleThree.move(6, 4, 6, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmptyEx2() {
    this.exampleThree.move(6, 6, 6, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInputEx2() {
    this.exampleThree.move(6, 6, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInputArmConstructor() {
    new MarbleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInputTotalConstructor() {
    new MarbleSolitaireModelImpl(-1, 5, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInputCoordConstructor() {
    new MarbleSolitaireModelImpl(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooBigInputCoordConstructor() {
    new MarbleSolitaireModelImpl(9, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAllInputBigConstructor() {
    new MarbleSolitaireModelImpl(-1, -5, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testTooBigAllInputBigConstructor() {
    new MarbleSolitaireModelImpl(3, 8, 4);
  }

  // Tests for move function
  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move1() {
    this.exampleOne.move(0, 3, 0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample2Move1() {
    this.exampleTwo.move(3, 4, 3, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample3Move1() {
    this.exampleThree.move(3, 8, 3, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample4MOve1() {
    this.exampleFour.move(3, 7, 4, 7);
  }

  // Tests for move function
  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move2() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(3, 2, 3, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move3() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(3, 4, 3, 2);
    this.exampleOne.move(3, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move4() {
    this.exampleOne.move(3, 3, 3, 1);
  }

  @Test
  public void testGameStateForErrors1() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    assertEquals("    O O O\n" +
            "    _ O O\n" +
            "O O _ O O O O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.exampleOne.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveMEO() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 3, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveMMO() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 3, 1, 5);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move5() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(3, 2, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move6() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(3, 3, 3, 1);
  }

  @Test
  public void testGameStateForErrors2() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    assertEquals("    O O O\n" +
            "    O _ _\n" +
            "O O _ O O O O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.exampleOne.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveEEO() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(1, 3, 1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveEMO1() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(1, 3, -1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveEMO2() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(1, 3, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveOOE() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(1, 6, 1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveOOM() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(1, 0, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveOEE() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(1, 5, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveOME() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(1, 1, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveOMM() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(0, 1, 0, 3);
  }

  @Test
  public void testGameStateForErrors3() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(2, 0, 2, 2);
    assertEquals("    O O O\n" +
            "    O _ _\n" +
            "_ _ O O O O O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.exampleOne.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1MoveOEM() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(1, 0, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move7() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(3, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move8() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(2, 2, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move9() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move10() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(3, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExample1Move11() {
    this.exampleOne.move(3, 1, 3, 3);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 3, 3, 1);
    this.exampleOne.move(1, 4, 1, 2);
    this.exampleOne.move(3, 4, 3, 6);
  }


  @Test
  public void testGameOverWon() {
    this.exampleOne.move(3, 5, 3, 3);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 3, 4, 5);
    this.exampleOne.move(4, 1, 4, 3);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(6, 4, 6, 2);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(2, 4, 4, 4);
    this.exampleOne.move(0, 4, 2, 4);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(5, 2, 5, 4);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(3, 4, 1, 4);
    this.exampleOne.move(2, 6, 4, 6);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 4, 4, 2);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(2, 3, 2, 1);
    this.exampleOne.move(4, 0, 2, 0);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(0, 2, 0, 4);
    this.exampleOne.move(0, 4, 2, 4);
    this.exampleOne.move(2, 5, 2, 3);
    this.exampleOne.move(2, 3, 2, 1);
    this.exampleOne.move(2, 1, 4, 1);
    this.exampleOne.move(4, 1, 4, 3);
    this.exampleOne.move(4, 3, 2, 3);
    this.exampleOne.move(1, 3, 3, 3);

    assertEquals(true, this.exampleOne.isGameOver());
  }

  @Test
  public void testGameOver1LeftButNotCenter() {
    this.exampleOne.move(3, 5, 3, 3);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 3, 4, 5);
    this.exampleOne.move(4, 1, 4, 3);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(6, 4, 6, 2);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(2, 4, 4, 4);
    this.exampleOne.move(0, 4, 2, 4);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(5, 2, 5, 4);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(3, 4, 1, 4);
    this.exampleOne.move(2, 6, 4, 6);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 4, 4, 2);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(2, 3, 2, 1);
    this.exampleOne.move(4, 0, 2, 0);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(0, 2, 0, 4);
    this.exampleOne.move(0, 4, 2, 4);
    this.exampleOne.move(2, 5, 2, 3);
    this.exampleOne.move(2, 3, 2, 1);
    this.exampleOne.move(2, 1, 4, 1);
    this.exampleOne.move(4, 1, 4, 3);
    this.exampleOne.move(4, 3, 2, 3);
    this.exampleOne.move(2, 3, 0, 3);

    assertEquals(true, this.exampleOne.isGameOver());
  }

  @Test
  public void testGameOverLost() {
    this.exampleOne.move(3, 5, 3, 3);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 3, 4, 5);
    this.exampleOne.move(4, 1, 4, 3);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(6, 4, 6, 2);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(2, 4, 4, 4);
    this.exampleOne.move(0, 4, 2, 4);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(5, 2, 5, 4);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(3, 4, 1, 4);
    this.exampleOne.move(2, 6, 4, 6);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 4, 4, 2);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(2, 3, 2, 1);
    this.exampleOne.move(4, 0, 2, 0);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(0, 2, 0, 4);
    this.exampleOne.move(0, 4, 2, 4);
    this.exampleOne.move(2, 5, 2, 3);
    this.exampleOne.move(2, 3, 2, 1);
    this.exampleOne.move(2, 1, 4, 1);
    this.exampleOne.move(4, 1, 4, 3);
    this.exampleOne.move(3, 3, 5, 3);
    assertEquals(true, this.exampleOne.isGameOver());
  }

  @Test
  public void testGameNotOver() {
    this.exampleOne.move(3, 5, 3, 3);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 3, 4, 5);
    this.exampleOne.move(4, 1, 4, 3);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(6, 4, 6, 2);
    this.exampleOne.move(6, 2, 4, 2);
    this.exampleOne.move(2, 4, 4, 4);
    this.exampleOne.move(0, 4, 2, 4);
    this.exampleOne.move(1, 2, 3, 2);
    this.exampleOne.move(3, 2, 5, 2);
    this.exampleOne.move(5, 2, 5, 4);
    this.exampleOne.move(5, 4, 3, 4);
    this.exampleOne.move(3, 4, 1, 4);
    this.exampleOne.move(2, 6, 4, 6);
    this.exampleOne.move(4, 6, 4, 4);
    this.exampleOne.move(4, 4, 4, 2);
    this.exampleOne.move(2, 0, 2, 2);
    assertEquals(false, this.exampleOne.isGameOver());
  }
}
