import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class GridTest extends TestCase {
    /** Sets up our Grid object to test Grid.java */
    private Grid g;
    
    @Before
    public void setUp() {
        g = new Grid(8);
        g.placePiece(1,1);
        g.placePiece(1,1);
        g.placePiece(1,1);
        g.placePiece(1,1);
        g.placePiece(4,2);
        g.placePiece(5,1);
        g.placePiece(5,2);
        g.placePiece(6,1);
        g.placePiece(6,1);
        g.placePiece(6,2);
        g.placePiece(7,1);
        g.placePiece(7,1);
        g.placePiece(7,1);
        g.placePiece(7,2);
    }

    
    @Test
    public void testHasWon1() {
        String desc = "Player 1 has at least 4 in a row, so it should be true";
        boolean exp = true;
        boolean actual = g.hasWon1();
        assertEquals(desc, exp, actual);
    }
    
    @Test
    public void testHasWon2() {
        String desc = "Player 2 has at least 4 in a row, so it should be true";
        boolean exp = true;
        boolean actual = g.hasWon1();
        assertEquals(desc, exp, actual);
    }

    @Test
    public void testNextTurn() {
        String desc = "Changing turn from player 1 to 2";
        int exp = 2;
        int actual = grid.nextTurn();
        assertEquals(desc, exp, actual);
    }
    
}