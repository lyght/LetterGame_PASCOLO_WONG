import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<String> playersNames = new ArrayList<>();
	
	LetterFactory letterFactory = new LetterFactory();
	LetterContainer commonPot = new LetterContainer();
	
	int currentPlayerIndex = -1;
	
	Game(int nbOfPlayers)
	{
		createPlayers(nbOfPlayers);
		currentPlayerIndex = chooseFirstPlayer();
	}
	
	private void createPlayers(int nbOfPlayers)
	{
		for(int i = 0; i< nbOfPlayers;i++)
		{
			System.out.println("Player " + (i+1) + " :");
			addNewPlayer(i);
			Letter playerLetter = letterFactory.getLetter();
			System.out.println(players.get(i).getName() + " picked letter " + playerLetter);
			commonPot.addLetter(playerLetter);
		}
	}
	private void addNewPlayer(int id)
	{
		String name = askPlayerName();
		Player playerToAdd = new Player(id, name);
		players.add(playerToAdd);
		playersNames.add(playerToAdd.getName());
	}
	
	private String askPlayerName()
	{
		String newName;
		do
		{
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a name for the player :");
			newName = reader.nextLine();
			if(playersNames.contains(newName))
				System.out.println("Somebody already has this name !");
		}while (playersNames.contains(newName));
		return newName;
	}
	
	private int chooseFirstPlayer()
	{
		int firstPlayerIndex = commonPot.getMinimumLetterIndex();
		System.out.println("Player " + players.get(firstPlayerIndex).getName() + " will begin.");
		return commonPot.getMinimumLetterIndex();
	}

	public void showPlayers()
	{
		for (int i = 0; i < players.size();i++)
		{
			System.out.println(players.get(i).getName());
		}
	}
	
	public void showCommonPot()
	{
		System.out.println(commonPot.getLetters().toString());
	}
}
