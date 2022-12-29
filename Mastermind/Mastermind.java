import java.util.*;

public class Mastermind {
	public static void main(String[] args)
	{
		if(args.length == 0)
			playMastermind();
		else
			System.out.println("Start the game without arguments.");
	}

	public static void playMastermind()
	{
		String 	result 	= getNewRandomNumber();
		String 	input 	= "";
		Scanner scanner = new Scanner(System.in);
		boolean hasWon 	= false;
		for (int i = 0; i < 10; i++)
		{
			System.out.print("Introduce a number.\n==>");
			input = scanner.next();
			if (isWrongInput(input))
			{
				System.out.println("ERROR: Please introduce only four numbers between 1 and 8. Try again.\n");
				i--;
			}
			else if (result.equals(input))
			{
				hasWon = true;
				break;
			}
			else
			{
				giveFeedbackToPlayer(input, result);
			}
		}
		if (hasWon)
			System.out.println("You have won the game.");
		else
		{
			System.out.println("You have sadly lost. Good luck next time. The result is: " + result);
		}
		scanner.close();
	}
}
