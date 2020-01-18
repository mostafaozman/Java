import java.util.Scanner;

public class GuessingGame 
{

	public GuessingGame() 
	{
		boolean stillPlaying = true;
		
		while (stillPlaying = true)
		{
			int RandomNum = (int)(Math.random() * 51);
			System.out.println("Guess a random number");
			Scanner scanner = new Scanner(System.in);
			int guess = -1;
			int attempts = 0;
			while(guess != RandomNum)
			{
				String input = scanner.nextLine();
				System.out.println("You typed:" + input);
				guess = Integer.parseInt(input);
				if (guess < 0) 
				{
					System.out.println("Your guess was less than 0, please guess between 0 and 50.");
				}
				if (guess > 50) 
				{
					System.out.println("Your guess was greater than 50, please guess between 0 and 50.");
				}
				
				if (guess > RandomNum)
				{
					System.out.println("You guessed too high! The number is smaller. Guess again");
				}
				
				if (guess < RandomNum)
				{
					System.out.println("You guessed too low! The number is bigger. Guess again");
				}
				
				if (guess != RandomNum)
				{
					attempts = attempts + 1;
				}
	
			}
			System.out.println("Great Game, you guessed the number! Would you like to play again?");
			String yesno = scanner.nextLine();
			if (yesno.equals("yes") || yesno.equals("y"))
			{
				stillPlaying = true;
			}
			
			else 
			{
				stillPlaying = false;
			}
			
			
			
			}
		}
		
		
	
	public static void main(String[] args) 
	{
		new GuessingGame();

	}

}


