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
			input = scanner.nextLine();
			if (isWrongInput(input))
			{
				System.out.println("ERROR: Please introduce only four integers between 1 and 8. Try again.\n");
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

	public static String getNewRandomNumber()
	{
		Random	random		= new Random();
		String	colorCode	= "";
		int		num;

		while (colorCode.length() < 4)
		{
			num = random.nextInt(8) + 1;
			if (colorCode.contains("" + num) == false)
				colorCode += ("" + num);
		}
		return (colorCode);
	}

	public static boolean isWrongInput(String input)
	{
		if (input.length() != 4)
			return (true);
		for (char c : input.toCharArray())
			if (c < '1' || c > '8')
				return (true);
		return (false);
	}

	public static void giveFeedbackToPlayer(String input, String result)
	{
		int	rightPlace	=	0;
		int	wrongPlace	=	0;

		for (int i = 0; i < 4; i++)
		{
			if (input.charAt(i) == result.charAt(i))
				rightPlace++;
			else if (hasChar(result, input.charAt(i)))
				wrongPlace++;
		}
		System.out.println("There " + giveFormatedAnswer(rightPlace) + " in the right place and " + giveFormatedAnswer(wrongPlace) + "in the wrong place\n");
	}

	public static String giveFormatedAnswer(int count)
	{
		if (count == 1)
			return ("is 1 color");
		return ("is " + count + " colors");
	}

	public static boolean hasChar(String result, char c)
	{
		for (char s : result.toCharArray())
			if (s == c)
				return (true);
		return (false);
	}
}
