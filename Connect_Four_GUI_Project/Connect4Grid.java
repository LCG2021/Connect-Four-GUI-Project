package Connect4;

//Class Connect4Grid definition
public class Connect4Grid
{
//Instance variable to store matrix information
private int rowSize;
private int colSize;
private int[][] matrix;
private int cellsLeft = 0;
//Default constructor
public Connect4Grid()
{
//Sets the row and column size
rowSize = 7;
colSize = 6;
//Dynamically allocate memory
matrix = new int[rowSize][colSize];

//Loops till number of rows
for (int r = 0; r < rowSize; r++)
{
//Loops till number of columns
for (int c = 0; c < colSize; c++)
{
//Initializes each position
matrix[r][c] = 0;
cellsLeft++;
}// End of inner for loop
}// End of outer for loop
}// End of method

//Methods to return cell left
public int getCellsLeft()
{
return cellsLeft;
}// End of method
//Method to return matrix
public int[][] getMatrix()
{
return matrix;
}// End of method
//Method to return if matrix pos1 and pos2 index position contains player number
//Otherwise false
public boolean matrix_equals(int pos1, int pos2, int player)
{
return matrix [pos1][pos2] == player;
}// End of method
//Method to set the player at pos1 and po2 index position of matrix
public void set_matrix(int pos1, int pos2, int player)
{
//Assigns player number at pos1 and po2 index position of the matrix
matrix[pos1][pos2] = player;
}// End of method
//Method to returns the row size
public int getRowSize()
{
return rowSize;
}// End of method

//Method to return the column Size
public int getColSize()
{
return colSize;
}// End of method
//Method to checks for room in column and returns free position
public int find_y(int row)
{
int position = -1;
//Loops till end of the column
for (int col = 0; col < colSize; col++)
{
//Checks if the matrix r and c position is having zero i.e., free
if (matrix[row][col] == 0)
{
//Assigns column counter value as free position
position = col;
}// End of if condition
}// End of for loop
//Returns the free position
return position;
}// End of method
//Method to change player and returns the player number
public int changeplayer(int player, int maximumPlayers)
{
//Increase the player counter by one
player++;
//Checks if the player counter is greater than maximum player
//then return 1
if (player > maximumPlayers)
{
return 1;
}// End of if condition
//Returns player number
return player;
}// End of method
}// End of class