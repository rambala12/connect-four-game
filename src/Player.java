/**
 * Player Class to represent a player in the game
 *
 * @author Johnny Huang
 * @author Bobby Scanlon
 * @author Seth Hollandsworth 
 * @author Ramanathan Balasubramanian
 */
public class Player {
    /**
     * int for player's number
     */
    private int playerNumber;
    
    /**
     * int for the amount of pieces placed
     */
    private int piecesPlaced;


    /**
     * This method returns the player number
     *
     * @return playerNumber the assigned number for each player
     */
    public int getPlayerNumber() {
        return playerNumber;
    }
    /**
     * This method returns the number of pieces placed
     *
     * @return piecesPlaced the number of pieces each player has placed
     */
    public int getPiecesPlaced() {
        return piecesPlaced;
    }


    /**
     * sets the number of pieces placed
     */
    public void incrementPiecesPlaced() {
        this.piecesPlaced += 1;
    }

    /**
     * Constructs the player object
     *
     * @param playerNumber the number of the player of interest
     */
    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        this.piecesPlaced = 0;
    }
    /**
     * Returns whether or not two objects are equal
     *
     * @param o the object of interest
     * @return boolean whether or not the two objects are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player p = (Player) o;
            return playerNumber == p.playerNumber
                    && piecesPlaced == p.piecesPlaced;
        } else {
            return false;
        }
    }
}
