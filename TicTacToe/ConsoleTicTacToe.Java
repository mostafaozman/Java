import java.util.Scanner;

public class TicTacToe 
{
	int [][] board = new int [3] [3];
	final int BLANK = 0;
	final int X_MOVE = 1;
	final int O_MOVE = 2;
	int X_WIN = 0;
	int O_WIN = 0;
	boolean move = true;
	Scanner scanner;
	String input = "";
	
	public TicTacToe() 
	{
		scanner =  new Scanner(System.in); 
		boolean stillPlaying = true;
		while(stillPlaying = true)
		{
		
			while (checkWin(X_MOVE) == false && checkWin(O_MOVE) == false && checkTie() == false)
			{
				printBoard();
				input = scanner.nextLine();
				if (input.length() != 2)
				{
					System.out.println("Please enter a letter followed by a number");
				}
				else if (input.charAt(0) != 'a' && input.charAt(0) != 'b' && input.charAt(0) != 'c')
				{
					System.out.println("For a row, you must enter a, b, or c.");
				}
			
				else if (input.charAt(1) != '1' && input.charAt(1) != '2' && input.charAt(1) != '3')
				{
					System.out.println("For a column, you must enter 1, 2, or 3.");
				}
				else 
				{
					int row = input.charAt(0) - 'a';
					int column = input.charAt(1) - '1';
					System.out.println(row + "," + column);
					if (board [row][column] == BLANK)
					{
						if(move) 
							board[row][column] = X_MOVE;
						else
						{
							board[row][column] = O_MOVE;
							
						}
						move = !move;
					}
					else 
					{
						System.out.println("That place is taken, please try again.");
					}
				
				}
			    
				if (checkWin(X_MOVE) == true )
				{
					System.out.println("X Wins!!!");
					X_WIN = X_WIN + 1; 
					System.out.println("X has won " + X_WIN + " times. And O has won " + O_WIN + " times.");
				}
			
				else if (checkWin(O_MOVE) == true )
				{
					System.out.println("O Wins!!!");
					O_WIN = O_WIN + 1;
					System.out.println("X has won " + X_WIN + " times. And O has won " + O_WIN + " times.");
				}
			
				else if (checkTie() == true)
				{
					 System.out.println("Its a tie!");
				}
			}
		
			System.out.println("Would you like to play again? Please type \"yes\" or \"no\".");
			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if (input == "yes")
			{
					
					stillPlaying = true;
			}
		
			else if (input == "no")
			{
				stillPlaying = false;
			}
			wipeBoard();
			
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToe();

	}

	public void printBoard() 
	{
		System.out.println("\t1\t2\t3");
		for (int row = 0; row < board.length; row++) 
		{
			String output = (char)('a' + row) + "\t";
			for (int column = 0; column < board.length; column++) 
			{
				if (board[row][column] == BLANK ) 
				{
					output += " \t";
				}
				
				else if (board [row][column] == X_MOVE)
				{
					output += "X\t";
				}
			
				else if (board [row][column] == O_MOVE)
				{
					output += "O\t";
				}
			}
			
			System.out.println(output);
		}
		
	}
	
	public void wipeBoard()
	{
		for (int row = 0; row < board.length; row++) 
		{
			for (int column = 0; column < board.length; column++) 
			{
				board[row][column] = BLANK ;
			}
		}
	}

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
	   
	   if (board[0][0] == player && board[1][0] == player && board[2][0] == player)
	   {
		   return true;
	   }
	  
	   if (board[2][0] == player && board[2][1] == player && board[2][2] == player)
	   {
		   return true;
	   
       }
	   
	   if (board[0][2] == player && board[1][2] == player && board[2][2] == player)
	   {
		   return true;
	   }
	  
	   if (board[2][0] == player && board[1][1] == player && board[0][2] == player)
	   {
		   return true;
	   }
	   
	   if (board[0][1] == player && board[1][1] == player && board[2][1] == player)
	   {
		   return true;
	   }
	   
	   if (board[1][0] == player && board[1][1] == player && board[1][2] == player)
	   {
		   return true;
	   }
	     
	   return false;
   
   }

   public boolean checkTie() 
   {
	   for (int row = 0; row < board.length; row++)
	   {
		   for (int column = 0; column < board.length; column++) 
		   {
			   if(board[row][column] == BLANK)
			   {
				   return false;
			   }
		   }
	   }
	 
	   return true;
   }
}
