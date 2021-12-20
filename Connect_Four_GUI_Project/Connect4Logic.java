package Connect4;

//Class Connect4Logic definition
public class Connect4Logic
{
//Instance variables to store logical data
private int cellsLeft = 0;
private int max;
private int rowSize;
private int colSize;
Connect4Grid myGrid;
//Parameterized constructor
public Connect4Logic(Connect4Grid tempGrid)
{
max = 4;
myGrid = tempGrid;
//Dynamically allocates memory
cellsLeft = myGrid.getCellsLeft();
rowSize = myGrid.getRowSize();
colSize = myGrid.getColSize();
}// End of method
//Method to set the found coordinate to current player
public boolean setAndCheck(int r, int c, int player)
{
myGrid.set_matrix(r, c, player);
cellsLeft--;
return checkOne(r, c, 0, 1, player) || checkOne(r, c, -1, 1, player)
|| checkOne(r, c, -1, 0, player) || checkOne(r, c, 1, 1, player);
}// End of method
//Method to check for draw game
public boolean draw_game()
{
return cellsLeft == 0;
}// End of method
//Method to check the player position
private boolean checkOne(int r, int c, int dR, int dC, int player)
{
int count = 0;
int tempx = r;
int tempy = c;
while (count < max && valid(tempx, tempy))
{
if (!myGrid.matrix_equals(tempx, tempy, player))
{
break;
}// End of if condition
tempx += dR;
tempy += dC;
count++;
}// End of while loop
tempx = r - dR;
tempy = c - dC;
while (count < max && valid(tempx, tempy))
{
if (!myGrid.matrix_equals(tempx, tempy, player))
{
break;
}// End of if condition
tempx -= dR;
tempy -= dC;
count++;
}// End of while loop
return count == max;
}// End of method
//Method to check valid position
private boolean valid(int r, int c)
{
//returns if the bounds are set to be > 0 only then first row and column doesn't work
return r >= 0 && r < rowSize && c >= 0 && c < colSize;
}// End of method
}// End of class