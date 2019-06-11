
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Test class for Triangle Solitaire Game.
 */
public class TriangleSolitaireModelImplTest {
  MarbleSolitaireModel exampleOne = new TriangleSolitaireModelImpl();
  MarbleSolitaireModel exampleTwo = new TriangleSolitaireModelImpl(7);
  MarbleSolitaireModel exampleThree = new TriangleSolitaireModelImpl(1, 1);
  MarbleSolitaireModel exampleFourA = new TriangleSolitaireModelImpl(7, 4, 0);
  MarbleSolitaireModel exampleFourB = new TriangleSolitaireModelImpl(7, 4, 4);
  MarbleSolitaireModel exampleFourC = new TriangleSolitaireModelImpl(7, 2, 0);
  MarbleSolitaireModel exampleFourD = new TriangleSolitaireModelImpl(7, 2, 2);
  MarbleSolitaireModel exampleFourE = new TriangleSolitaireModelImpl(7, 6, 2);
  MarbleSolitaireModel exampleFourF = new TriangleSolitaireModelImpl(7, 6, 4);


  @Test
  public void testBuildingDefaultGameEx1() {
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            exampleOne.getGameState());

  }

  @Test
  public void testMovingA() {
    exampleFourA.move(4, 2, 4, 0);
    assertEquals("      O\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O _ _ O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O",
            exampleFourA.getGameState());
    assertEquals(26, exampleFourA.getScore());

  }

  @Test
  public void testMovingB() {
    exampleFourB.move(4, 2, 4, 4);
    assertEquals("      O\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O _ _ O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O",
            exampleFourB.getGameState());
    assertEquals(26, exampleFourB.getScore());

  }

  @Test
  public void testMovingC() {
    exampleFourC.move(4, 2, 2, 0);
    assertEquals("      O\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O _ O O\n" +
                    "  O O _ O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O",
            exampleFourC.getGameState());
    assertEquals(26, exampleFourC.getScore());

  }

  @Test
  public void testMovingD() {
    exampleFourD.move(4, 2, 2, 2);
    assertEquals("      O\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O _ O\n" +
                    "  O O _ O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O",
            exampleFourD.getGameState());
    assertEquals(26, exampleFourD.getScore());

  }

  @Test
  public void testMovingE() {
    exampleFourE.move(4, 2, 6, 2);
    assertEquals("      O\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O _ O O\n" +
                    " O O _ O O O\n" +
                    "O O O O O O O",
            exampleFourE.getGameState());
    assertEquals(26, exampleFourE.getScore());

  }

  @Test
  public void testMovingF() {
    exampleFourF.move(4, 2, 6, 4);
    assertEquals("      O\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O _ O O\n" +
                    " O O O _ O O\n" +
                    "O O O O O O O",
            exampleFourF.getGameState());
    assertEquals(26, exampleFourF.getScore());

  }

  @Test
  public void testGetScore() {
    assertEquals(14,
            exampleThree.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInputArmConstructor() {
    new TriangleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInputTotalConstructor() {
    new TriangleSolitaireModelImpl(-1, 5, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInputCoordConstructor() {
    new TriangleSolitaireModelImpl(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooBigInputCoordConstructor() {
    new TriangleSolitaireModelImpl(9, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAllInputBigConstructor() {
    new TriangleSolitaireModelImpl(-1, -5, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testTooBigAllInputBigConstructor() {
    new TriangleSolitaireModelImpl(3, 8, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooBigAllInputLongConstructor() {
    new TriangleSolitaireModelImpl(6, 4, 6);
  }

  @Test
  public void testBuildingDefaultGameEx2() {
    assertEquals("      _\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O O O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O",
            exampleTwo.getGameState());

  }

  @Test
  public void testBuildingDefaultGameEx3() {
    assertEquals("    O\n" +
                    "   O _\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            exampleThree.getGameState());

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
    this.exampleThree.move(2, 1, 0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmpty() {
    this.exampleThree.move(1, 1, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInput() {
    this.exampleThree.move(4, 6, 4, 1);
  }

  // Test Example 1
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutsideEx1() {
    this.exampleOne.move(3, 2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOverMarbleEx1() {
    this.exampleOne.move(2, 0, 4, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToMarbleEx1() {
    this.exampleOne.move(3, 1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmptyEx1() {
    this.exampleOne.move(0, 0, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInputEx1() {
    this.exampleOne.move(3, 3, 3, -2);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutsideEx4() {
    this.exampleFourA.move(6, 5, 6, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOverMarbleEx4() {
    this.exampleFourA.move(4, 2, 4, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToMarbleEx4() {
    this.exampleFourA.move(3, 0, 5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmptyEx4() {
    this.exampleFourA.move(4, 0, 6, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInputEx4() {
    this.exampleFourA.move(5, 4, 5, -1);
  }

  // Test Example 2
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutsideEx2() {
    this.exampleTwo.move(6, 5, 6, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOverMarbleEx2() {
    this.exampleTwo.move(6, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToMarbleEx2() {
    this.exampleTwo.move(6, 4, 6, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromEmptyEx2() {
    this.exampleTwo.move(6, 6, 6, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInputEx2() {
    this.exampleTwo.move(6, 6, 6, 1);
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
    this.exampleFourA.move(3, 7, 4, 7);
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

  //asdfasdfadsfasf


  @Test
  public void testGameOverWon() {
    this.exampleOne.move(2, 0, 0, 0);
    this.exampleOne.move(2, 2, 2, 0);
    this.exampleOne.move(4, 4, 2, 2);
    this.exampleOne.move(1, 1, 3, 3);
    this.exampleOne.move(4, 2, 2, 2);
    this.exampleOne.move(4, 0, 4, 2);
    this.exampleOne.move(4, 3, 4, 1);
    this.exampleOne.move(4, 1, 2, 1);
    this.exampleOne.move(3, 3, 1, 1);
    this.exampleOne.move(3, 0, 1, 0);
    this.exampleOne.move(0, 0, 2, 0);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(2, 2, 0, 0);

    assertEquals(true, this.exampleOne.isGameOver());
  }

  @Test
  public void testGameOver1LeftButNotCenter() {
    this.exampleOne.move(2, 0, 0, 0);
    this.exampleOne.move(2, 2, 2, 0);
    this.exampleOne.move(4, 4, 2, 2);
    this.exampleOne.move(1, 1, 3, 3);
    this.exampleOne.move(4, 2, 2, 2);
    this.exampleOne.move(4, 0, 4, 2);
    this.exampleOne.move(4, 3, 4, 1);
    this.exampleOne.move(4, 1, 2, 1);
    this.exampleOne.move(3, 3, 1, 1);
    this.exampleOne.move(3, 0, 1, 0);
    this.exampleOne.move(0, 0, 2, 0);
    this.exampleOne.move(2, 0, 2, 2);
    this.exampleOne.move(1, 1, 3, 3);
    assertEquals(1, this.exampleOne.getScore());
    assertEquals(true, this.exampleOne.isGameOver());
  }

  @Test
  public void testGameOverLost() {
    this.exampleOne.move(2, 0, 0, 0);
    this.exampleOne.move(2, 2, 2, 0);
    this.exampleOne.move(4, 4, 2, 2);
    this.exampleOne.move(1, 1, 3, 3);
    this.exampleOne.move(4, 2, 2, 2);
    this.exampleOne.move(4, 0, 4, 2);
    this.exampleOne.move(4, 3, 4, 1);
    this.exampleOne.move(4, 1, 2, 1);
    this.exampleOne.move(3, 3, 1, 1);
    this.exampleOne.move(2, 0, 4, 0);
    this.exampleOne.move(0, 0, 2, 2);
    this.exampleOne.move(2, 2, 2, 0);
    assertEquals(true, this.exampleOne.isGameOver());
  }

  @Test
  public void testGameNotOver() {
    this.exampleOne.move(2, 0, 0, 0);
    this.exampleOne.move(2, 2, 2, 0);
    assertEquals(12, this.exampleOne.getScore());
    this.exampleOne.move(4, 4, 2, 2);
    this.exampleOne.move(1, 1, 3, 3);
    this.exampleOne.move(4, 2, 2, 2);
    this.exampleOne.move(4, 0, 4, 2);
    this.exampleOne.move(4, 3, 4, 1);
    this.exampleOne.move(4, 1, 2, 1);
    this.exampleOne.move(3, 3, 1, 1);
    this.exampleOne.move(2, 0, 4, 0);
    assertEquals(false, this.exampleOne.isGameOver());
  }
}
