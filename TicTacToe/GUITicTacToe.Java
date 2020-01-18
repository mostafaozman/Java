/*
By: Mostafa Osman
Date: October, 3, 2018
Graphical User Interface TicTacToe
This code will create an interactive board for TicTacToe in which you click to claim a space alternating turns
This will also keep track of wins and players names
*/

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class GUITicTacToe implements ActionListener
{
	JFrame frame = new JFrame();
	JButton button[][] = new JButton[3][3];
	int[][] board = new int[3][3];
	final int BLANK = 0;
	final int X_MOVE = 1;
	final int O_MOVE = 2;
	final int X_TURN = 0;
	final int O_TURN = 1;
	int turn = X_TURN;

	Container center = new Container();
	JLabel xname = new JLabel("X wins: 0");
	JLabel oname = new JLabel("O wins: 0");
	JButton xChangeName = new JButton("Change X's Name.");
	JButton oChangeName = new JButton("Change O's Name.");
	Container north = new Container();
	JTextField xChangeField = new JTextField();
	JTextField oChangeField = new JTextField();
	String xPlayerName = "X";
	String oPlayerName = "O";
	int xwins = 0;
	int owins = 0;
	
	public GUITicTacToe() 
	{// Creates a board
		frame.setSize(400,400);
		//Center grid container
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
		for (int j = 0; j < button.length; j++)
		{
			for (int j1 = 0; j1 < button[0].length; j1++)
			{
				button[j1][j] = new JButton();
				center.add(button[j1][j]);
				button[j1][j].addActionListener(this);
			}
		}
		//Creates the north container in which it will keep track of wins and the players names
		frame.add(center, BorderLayout.CENTER);
		//North Container
		north.setLayout(new GridLayout(3,2));
		north.add(xname);
		north.add(oname);
		north.add(xChangeName);
		xChangeName.addActionListener(this);
		north.add(oChangeName);
		oChangeName.addActionListener(this);
		north.add(xChangeField);
		north.add(oChangeField);
		frame.add(north, BorderLayout.NORTH); 	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new GUITicTacToe();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton current; 
		boolean gridButton = false;
		for(int j1 = 0; j1 < button.length; j1++)
		{
			for(int j = 0; j < button.length; j++)
			{
				if (event.getSource().equals(button[j][j1]))
				{
					current = button[j][j1];
					if (board[j][j1] == BLANK)
					{ // After each move set the move to the other player X --> O and O --> X
						if (turn == X_TURN)
						{
							current.setText("X");
							current.setEnabled(false);
							board[j][j1] = X_MOVE;
							turn = O_TURN;
						}	
						else 
						{
							current.setText("O");
							current.setEnabled(false);
							board[j][j1] = O_MOVE;
							turn = X_TURN;
						}		
				        // Check for wins and add 1 to score
						if (checkWin(X_MOVE) == true)
						{
							System.out.println("X Wins!");
							xwins++; 
							xname.setText(xPlayerName + " wins:" + xwins);
							clearBoard();
						}
						
						else if (checkWin(O_MOVE) == true)
						{
							System.out.println("O Wins!");
							owins++;
							oname.setText(oPlayerName + " wins:" + owins);
							clearBoard();
						}
						//If its a tie just clear the board
						else if (checkTie() == true)
						{
							System.out.println("Its a tie!");
							clearBoard();
						}
					}
				}
			}
	  }
		
		if (gridButton == false )
		{
			if (event.getSource().equals(xChangeName) == true)
			{
				xPlayerName = xChangeField.getText();
				if (xPlayerName.length() >= 1) 
				{
				xname.setText(xPlayerName + " wins:" + xwins);
				}
			}
			else if (event.getSource().equals(oChangeName) == true)
			{
				oPlayerName = oChangeField.getText();
				if (oPlayerName.length() >= 1) 
				{
				oname.setText(oPlayerName + " wins:" + owins);
				}
			}
		}
	}
// Check all possible combinations of winning
	  public boolean checkWin(int player) 
	   {
		   if (board[0][0] == player && board[0][1] == player && board[0][2] == player)
		   {
			   return true;
		   }
		   if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
		   {
			   return true;
		   }
		   
		etc.
		   return false;
	   
	   }
// If it is not a winning layout, return tie
	  public boolean checkTie() 
	   {
		  return false;
	   }
//Clear the board by setting each space to a bank and re-enabling the buttons
	  public void clearBoard()
	  {
		  for(int a = 0; a < board.length; a++)
		  {
			  for (int c = 0; c < board[0].length; c++)
			  {
				  board[a][c]= BLANK;
				  button[a][c].setText("");
				  button[a][c].setEnabled(true);
			  }
		  }
		  turn = X_TURN;
	  }


	
}
