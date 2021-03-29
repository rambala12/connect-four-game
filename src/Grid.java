import java.util.Arrays;

/**
 * Class to represent the grid and all of its characteristics
 *
 * @author Johnny Huang
 * @author Bobby Scanlon
 * @author Seth Hollandsworth 
 * @author Ramanathan Balasubramanian
 */
public class Grid {

    /**
     * grid for pieces to be placed
     */
    private static int[][] grid;
    /** int for who's turn it is */
    private int turn = 1;
    /**
     * Constructor method for the Grid
     * 
     * @param size  - the size of the board
     */
    public Grid(int size) {
        grid = new int[size][size];
    }

    /**
     * method to place a piece in a certain column of the board
     *
     * @param column - which column the piece gets placed
     * @param player - the numebr of the player, either 1 or 2
     */
    public void placePiece(int column, int player) {
        for (int i = grid[0].length - 1; i >= 0; i--) {
            if (grid[i][column] == 0) {
                grid[i][column] = player;
                break;
            }
        }
    }

    /**
     * method to return whos turn it is
     *
     * @return current player's turn
     */
    public int getTurn() {
        return this.turn;
    }

    /**
     * method to switch who's turn it is
     */
    public void nextTurn() {
        if (this.turn == 1) {
            this.turn = 2;
        } else {
            this.turn = 1;
        }
    }

    //Can make this more efficient by stopping once we find a winner
    /**
     * method to determine if someone has won the game be calling other methods
     *
     * @return true if someone as won, false otherwise
     */
    public boolean hasWon1() {
        boolean horiz = winHorizontal();
        boolean vert = winVertical();
        boolean diagForward = winDiagonalForward();
        boolean diagBackward = winDiagonalBackward();
        //System.out.println(diagBackward);
        return horiz || vert || diagForward || diagBackward;
    }

    /**
     * method to see if someone has won horizontally
     *
     * @return true if someone has won horizontally, false otherwise
     */
    private boolean winHorizontal() {
        // checks horzontally
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length / 2 + 1; j++) {
                int[] consecutive = new int[grid.length / 2];
                for (int k = 0; k < grid.length / 2; k++){
                    consecutive[k] = grid[i][j + k];
                    //System.out.println((i) + " " + (j  +k));
                    //System.out.println(grid[i][j+k]);
                }

                //System.out.println(Arrays.toString(consecutive));
                boolean flag = true;
                for (int x = 0; x < consecutive.length; x++) {
                    if (consecutive[0] != consecutive[x] || consecutive[0] == 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    return flag;
                }
            }
        }
        return false;
    }

    /**
     * method to see if someone has won vertically
     *
     * @return true if someone has won vertically, false otherwise
     */
    private boolean winVertical() {
        //checks vertically
        transposeGrid();
        boolean win = winHorizontal();
        transposeGrid();
        //Arrays.deepToString(grid);
        return win;
    }

    /**
     * method to see if someone has won diagonally forward
     *
     * @return true if someone has won diagonally forward, false otherwise
     */
    private boolean winDiagonalForward() {
        for (int i = 0; i < grid.length / 2 + 1; i++) {
            for (int j = 0; j < grid.length / 2 + 1; j++) {
                int[] consecutive = new int[grid.length / 2];
                for (int k = 0; k < grid.length / 2; k++) {
                    consecutive[k] = grid[i + k][j + k];
                }
                //System.out.println(Arrays.toString(consecutive));
                boolean flag = true;
                for (int x = 0; x < consecutive.length; x++) {
                    if (consecutive[0] != consecutive[x] || consecutive[0] == 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    return flag;
                }
            }
        }
        return false;
    }

    /**
     * method to see if someone has won diagonally backward
     *
     * @return true if someone has won diagonally backward, false otherwise
     */
    private boolean winDiagonalBackward() {
        flipGrid();
        boolean win = winDiagonalForward();
        flipGrid();
        return win;
    }
    
    /**
     * method to transpose the grid to check for horizontal/vertical
     */
    private void transposeGrid() {
        int[][] tempGrid = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                tempGrid[j][i] = grid[i][j];
            }
        }
        grid = tempGrid;
    }

    /**
     * method to flip the grid to check for the different diagonals
     */
    private void flipGrid() {
        for (int i = 0; i < grid.length; i++){
            int left = 0;
            int right = grid.length - 1;
            while (left < right) {
                int temp = grid[i][left];
                grid[i][left] = grid[i][right];
                grid[i][right] = temp;
                left++;
                right--;
            }   
        }
    }

    /**
     * method to print an 8x8 grid for the command line version of the game
     */
    public void printGrid() {
        for (int p = 0;p < grid.length;p++){
            System.out.println(Arrays.toString(grid[p]));
        }
        for (int i = 0; i < grid.length * 3;)
        System.out.println("========================");
        System.out.println("||                    ||");
        System.out.println("/\\                    /\\");
        System.out.println();
        System.out.println();
    }

    /**
     * method to get the int[][] array from the Grid class
     *
     * @return array of all the pieces placed
     */
    public int[][] getGrid() {
        return this.grid;
    }
}