import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Scanner;
/**
 * Game of Connect Four with GUI implementation
 *
 * @author Seth Hollandsworth
 * @author Ram Bala
 * @author Bobby Scanlon
 * @author Johnny Huang
 */
public class ConnectFourGUI extends JFrame implements ActionListener {
    /** Label for pieces placed */
    private JLabel player1Placed;
    /** Label for pieces placed */
    private JLabel player2Placed;
    /** Label for connected pieces */
    private JLabel player1ConnectedPieces;
    /** Label for connectd pieces */
    private JLabel player2ConnectedPieces;
    /** container for other items for organization */
    private JPanel panel1;
    /** container for other items for organization */
    private JPanel panel2;
    /** array of all the buttons at the top */
    private JButton[] allButtons;
    /** Grid object to call the board from */
    private Grid grid;
    /** Player object for the first player */
    private Player player1 = new Player(1);
    /** Player object for the second player */
    private Player player2 = new Player(2);
    /** 2D array of all the textFields for the board */
    private JTextField[][] allTextFields;
    /** text field for how many pieces have been placed for player one */
    private JTextField player1PlacedText = new JTextField();
    /** text field for how many pieces have been placed for player two */
    private JTextField player2PlacedText = new JTextField();
    /** length of window */
    private final int windowLength = 1500;
    /** height of window */
    private final int windowHeight = 500;
    /** location of the window on screen */
    private final int location = 100;
    /** small button size */
    private final int smallButton = 50;
    /** big button size */
    private final int bigButton = 90;
    /** preferred size of panel width */
    private final int preferredWidth = 300;
    /** preferred size of panel height */
    private final int preferredHeight = 500;
    /** grid width */
    private final int gridWidth = 9;
    /** minimum number of pieces to connect */
    private static final int minSize = 4;

    /**
     * Constructor method for the GUI that starts the whole game
     *
     * @param size - the int of how big the board should be
     */
    public ConnectFourGUI(int size) {
        super("Connect Four GUI");
        setSize(windowLength, windowHeight);
        setLocation(location, location);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        // initialize the grid
        grid = new Grid(size);
        panel1 = new JPanel();
        panel1.setLayout( new BorderLayout() );
        //Create a JPanel
        JPanel panel1 = new JPanel(new GridLayout(size + 1, size));
        allButtons = new JButton[size];
        allTextFields = new JTextField[size][size];
        for (int i = 0;i < allButtons.length;i++) {
            allButtons[i] = new JButton((i + 1) + "");
            if (size > minSize * 3) {
                allButtons[i].setPreferredSize(new Dimension(smallButton, smallButton));
            } else {
                allButtons[i].setPreferredSize(new Dimension(bigButton, bigButton));
            }
            allButtons[i].addActionListener(this);
            panel1.add(allButtons[i],i);
            for (int j = 0;j < allButtons.length;j++) {
                    //allTextFields[i][j] = new JTextField(j + "");
                allTextFields[i][j] = new JTextField("");
                panel1.add(allTextFields[i][j]);
                allTextFields[i][j].setEditable(false);
                allTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);
            }
        }
        c.add(panel1, BorderLayout.WEST);
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(preferredWidth,preferredHeight));
        panel2.setLayout(new GridLayout(gridWidth, 1));
        Border b = BorderFactory.createLineBorder(Color.black);
        panel2.setBorder(b);
        JLabel player1Placed = new JLabel("Player 1 Total Pieces (X):");
        panel2.add(player1Placed);
        player1Placed.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(player1PlacedText);
        JLabel player2Placed = new JLabel("Player 2 Total Pieces (O):");
        panel2.add(player2Placed);
        player2Placed.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(player2PlacedText);
        c.add(panel2, BorderLayout.EAST);
        setVisible(true);
    }
    
    /**
     * Starts the program
     *
     * @param args - command line arguments as strings
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int size = 0;
        do {
            System.out.print("How many pieces do you want to connect to win (4 or greater)?  ");
            while (!console.hasNextInt() ){
                System.out.print("Please input a positive integer: ");
                console.next();
            }
            size = console.nextInt();
        } while ( size < minSize);  
        new ConnectFourGUI(2 * size);
    }
   
    

    /**
     * Performs specific action(s) based on the event that occurs
     *
     * @param e event that occured
     */
    public void actionPerformed(ActionEvent e) {
        int turn = grid.getTurn();
        int buttonNum = 0;
        int[][] updatedGrid = grid.getGrid();
        int[] heights = new int[updatedGrid.length];
        int columnPlace = 0;
        for (int k = 0; k < allButtons.length; k++) {
            if (e.getSource() == allButtons[k]) {
                buttonNum = k;
            }
        }
        grid.placePiece(buttonNum,turn);
        
        for (int i = 0; i < updatedGrid.length; i++) {
            for (int j = 0; j < updatedGrid.length; j++) {
                if (updatedGrid[i][j] == 1) {
                    allTextFields[i][j].setText("X");
                } else if (updatedGrid[i][j] == 2) {
                    allTextFields[i][j].setText("O");
                }
            }
        }

        if (turn == 1) {
            player1.incrementPiecesPlaced();
        } else if (turn == 2) {
            player2.incrementPiecesPlaced();
        }
        // sets the number of pieces placed
        player1PlacedText.setText("" + player1.getPiecesPlaced());
        player2PlacedText.setText("" + player2.getPiecesPlaced());
        if (grid.hasWon1()) {
            System.out.println("\nPlayer " + turn + " has won!!!");
            System.exit(1);
        }
        grid.nextTurn();
    }
}