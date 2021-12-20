package Connect4;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

// Class Connect4GUI definition
public class Connect4GUI
{
// Declares component and container objects
private JFrame frame;
private JLabel[][] slots;
private JButton[] buttons;
  
// Instance variables to store the grid size
private int rowSize = 7;
private int colSize = 6;
private int currentPlayer = 1;
  
// Instance variables to store game status
private boolean hasWon = false;
private boolean hasDraw = false;
private boolean quit = false;
private boolean newGame = false;
  
// Creates Grid and Logic class object
Connect4Grid my_grid = new Connect4Grid();
// For the logic applied in the game
Connect4Logic my_logic = new Connect4Logic(my_grid);
  
// Default constructor
public Connect4GUI()
{
// Instantiate objects
frame = new JFrame("connect four");
JPanel panel = (JPanel) frame.getContentPane();
panel.setLayout(new GridLayout(rowSize, colSize + 1));
slots = new JLabel[rowSize][colSize];
buttons = new JButton[rowSize];
// Loops 7 times for row
for (int i = 0; i < rowSize; i++)
{
// Create buttons
buttons[i] = new JButton("" + (i + 1));
buttons[i].setActionCommand("" + i);
// Register action listener to each button
buttons[i].addActionListener(new ActionListener()
{
// Overrides the method of ActionListener
public void actionPerformed(ActionEvent e)
{
int command = Integer.parseInt(e.getActionCommand());
// Calls the method to check space in column
int isSpace = my_grid.find_y(command);
// Checks if the method return value is not -1
if (isSpace != -1)
{
// Sets a place to current player
if (my_logic.setAndCheck(command, isSpace, currentPlayer))
hasWon = true;
// Otherwise calls the method to check for game draw
else if (my_logic.draw_game())
hasDraw = true;
// Otherwise
else
{
// Calls the method to change player
currentPlayer = my_grid.changeplayer(currentPlayer, 2);
frame.setTitle("Connect four - player " + currentPlayer + "'s turn");
}
}// End of if condition
// Otherwise displays error message
else
JOptionPane.showMessageDialog(null, "Choose another one", "Column is filled", JOptionPane.INFORMATION_MESSAGE);
}
});// End of anonymous class
// Adds the button to panel
panel.add(buttons[i]);
}// End of for loop
  
// Loops 6 times for column
for (int column = 0; column < colSize; column++)
{
// Loops 7 times for row
for (int row = 0; row < rowSize; row++)
{
// Assigns panels to matrix sloat's row and column index position
slots[row][column] = new JLabel();
slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
slots[row][column].setBorder(new LineBorder(Color.black));
// Adds the sloat's panes to main panel
panel.add(slots[row][column]);
}// End of inner for loop
}// End of outer for loop
// Sets the frame properties
frame.setContentPane(panel);
frame.setSize(700, 600);
frame.setVisible(true);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}// End of constructor
// Method to update the board after each move
public void updateBoard()
{
// Loops 7 times for row
for (int row = 0; row < rowSize; row++)
{
// Loops 6 times for column
for (int column = 0; column < colSize; column++)
{
// Calls the method to check if player 1
if (my_grid.matrix_equals(row, column, 1))
{
// Set it to true for selected
slots[row][column].setOpaque(true);
// Sets the background color to red
slots[row][column].setBackground(Color.red);
}// End of if condition
// Calls the method to check if player 2
if (my_grid.matrix_equals(row, column, 2))
{
slots[row][column].setOpaque(true);
slots[row][column].setBackground(Color.blue);
}// End of if condition
}// End of inner for loop
}// End of outer for loop
}// End of method
// Method to show winning status
public void showWon()
{
String winner = "player " + currentPlayer + " wins";
// Asks the user for new game
int conformation = JOptionPane.showConfirmDialog(frame, "new game?", winner, JOptionPane.YES_NO_OPTION);
// Checks if yes button is clicked
if (conformation < 1)
{
// Clears the frame for the next game
frame.dispose();
// Set the new game status to true
newGame = true;
}// End of if condition
// Otherwise no button clicked
else
{
// Clears the frame
frame.dispose();
// Sets the quit status to true to exit
quit = true;
}// End of else
}// End of method
// Method for game draw
public void showDraw()
{
String winner = "draw game";
// Asks the user for new game
int conformation = JOptionPane.showConfirmDialog(frame, "new game?", winner, JOptionPane.YES_NO_OPTION);
// Checks if yes button is clicked
if (conformation < 1)
{
// Clears the frame for the next game
frame.dispose();
// Set the new game status to true
newGame = true;
}// End of if condition
// Otherwise no button clicked
else
{
// Clears the frame
frame.dispose();
// Sets the quit status to true to exit
quit = true;
}// End of else
}// End of method
// Method to return true if own otherwise false
public boolean getHasWon()
{
return hasWon;
}// End of method
  
// Method to return true if draw otherwise false
public boolean getHasDraw()
{
return hasDraw;
}// End of method
// Method to return quit status
public boolean getQuit()
{
return quit;
}// End of method
// Method to return new game status
public boolean getNewGame()
{
return newGame;
}// End of method
// main method definition
public static void main(String[] args)
{
// Creates an object of the Connect4GUI class
Connect4GUI gui = new Connect4GUI();
}// End of main method
}// End of class