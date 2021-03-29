import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
    /** Initializing player 1 object */
    Player p1;
    
    /** Initializing player 2 object */
    Player p2;
    
    /** Initializing grid object */
    Grid g;
    
    @Before
    public void setUp() {
        p1 = new Player(1);
        p2 = new Player(2);
        g = new Grid(8);
        g.placePiece1(1);
        g.placePiece1(1);
        g.placePiece1(1);
        g.placePiece1(1);
        g.placePiece2(4);
        g.placePiece1(5);
        g.placePiece2(5);
        g.placePiece1(6);
        g.placePiece1(6);
        g.placePiece2(6);
        g.placePiece1(7);
        g.placePiece1(7);
        g.placePiece1(7);
        g.placePiece2(7);
    }
    
    @Test
    public void testGetPiecesPlaced1() {
        String desc = "Player 1 has 10 total pieces so this should return 10";
        int exp = 10;
        int actual = p1.getPiecesPlaced();
        assertEquals(desc, exp, actual);
    }
    
    @Test
    public void testGetPiecesPlaced2() {
        String desc = "Player 2 has 4 total pieces so this should return 10";
        int exp = 4;
        int actual = p2.getPiecesPlaced();
        assertEquals(desc, exp, actual);
    }
    
    @Test
    public void testGetHasWon1() {
        String desc = "Player 1 has at least 4 in a row, so this should be true.";
        boolean exp = true;
        boolean actual = p1.getHasWon();
        assertEquals(desc, exp, actual);
    }
    
    @Test
    public void testGetHasWon2() {
        String desc = "Player 2 has at least 4 in a row, so this should be true.";
        boolean exp = true;
        boolean actual = p2.getHasWon();
        assertEquals(desc, exp, actual);
    }
}