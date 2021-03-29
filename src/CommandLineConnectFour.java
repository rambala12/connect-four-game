import java.util.Scanner;

/**
 * Command line program for our presentation
 * This is purely for presentation purposes and is
 * not meant to be played as a full game.
 * We did not write a test program for this function because of this.
 * However, it was part of our presentation so we are submitting it.
 * @author Seth Hollandsworth 
 * @author Ramanathan Balasubramanian
 * @author Johnny Huang
 * @author Bobby Scanlon
 */
public class CommandLineConnectFour {
    /** constant to clear the screen */
    public static final int CLEAR_SCREEN = 5;
    /** constant for the grid size */
    public static final int GRID_SIZE = 8; 
    /**
     * Starts the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // constructs all of the objects
        Grid grid = new Grid(GRID_SIZE);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        //initializes the turn and the scanner to take in input
        Scanner console = new Scanner(System.in);
        int turn = 1;
        do {
            System.out.print("Which column would you like to place your piece? ");
            int col = console.nextInt();
            System.out.println();
            grid.placePiece(col,turn);
        
            if (turn == 1) {
                p1.incrementPiecesPlaced();
                turn++;
            } else {
                p2.incrementPiecesPlaced();
                turn--;
            } 
            grid.printGrid();
            System.out.printf("Player 1 pieces placed: %d\n",p1.getPiecesPlaced());
            System.out.printf("Player 2 pieces placed: %d\n",p2.getPiecesPlaced());
            for (int i = 0; i < CLEAR_SCREEN; i++) {
                System.out.println();
            }
        } while (!grid.hasWon1());
        if (turn == 1) {
            System.out.println("Congrats Player 2!");
        } else {
            System.out.println("Congrats Player 1!");
        }
    }
}
        
            
            
        
        
