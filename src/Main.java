import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		System.out.println("Welcome to the Letter Game !\n");
		begin();
	}
	
	public static void begin()
	{
		String dictionnaryPath = "/resources/dico.txt";
		int nbOfPlayers = 0;
		int nbOfIA = 0;
		do{
		nbOfPlayers = inputNumberScan("How many players will play ? (1 player minimum)", 1);
		}while(nbOfPlayers == -1);
		do{
			nbOfIA = inputNumberScan("How many IA will play ? (1 IA is minimum if alone)", 0);
		}while(nbOfIA == -1);
		if (nbOfPlayers == 1 && nbOfIA == 0)
			nbOfIA++;
		Game game = new Game(nbOfPlayers, nbOfIA, dictionnaryPath);
		game.launchGame();
	}
	
	private static int inputNumberScan(String question, int min)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println(question);
		if(reader.hasNextInt())
		{
			int number = reader.nextInt();
			if(number < min)
			{
				System.out.println("Please enter a valid number");
				return -1;
			}
			else
				return number;
		}
		else
		{
			System.out.println("Please enter a valid number");
			return -1;
		}
	}
}
