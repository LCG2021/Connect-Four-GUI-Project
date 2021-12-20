package Connect4;

//Class Connect4Driver definition
public class Connect4Driver
{
//main method definition
public static void main(String[] args)
{
int state = 0;
Connect4GUI Gui = new Connect4GUI();
//Checks if program is in quitting stage
while (state != -1)
{
switch (state)
{
case 0:
Gui.updateBoard();
if (Gui.getHasWon())
state = 1;
else if (Gui.getHasDraw())
state = 2;
else if (Gui.getNewGame())
{
Gui = new Connect4GUI();
state = 0;
}
break;
//End game with winner
case 1:
Gui.showWon();
if (Gui.getQuit())
state = -1;
else if (Gui.getNewGame())
{
Gui = new Connect4GUI();
state = 0;
}
break;
//End game with draw game
case 2:
Gui.showDraw();
if (Gui.getQuit())
state = -1;
else if (Gui.getNewGame())
{
Gui = new Connect4GUI();
state = 0;
}
break;
}// End of switch - case
}// End of while loop
}// End of main method
}// End of class