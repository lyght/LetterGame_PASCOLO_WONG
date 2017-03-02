import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	ArrayList<Player> players = new ArrayList<>();
	
	LetterFactory letterFactory = new LetterFactory();
	LetterContainer commonPot = new LetterContainer();
	
	int nbOfPlayers = 0;
	int currentPlayerIndex = -1;
	
	Game(int nbOfPlayers)
	{
		this.nbOfPlayers = nbOfPlayers;
		createPlayers();
		currentPlayerIndex = chooseFirstPlayer();
	}
	
	private void createPlayers()
	{
		for(int i = 0; i< nbOfPlayers;i++)
		{
			System.out.println("Player " + (i+1) + " :");
			addNewPlayer(i);
			Letter playerLetter = letterFactory.getLetter();
			System.out.println(players.get(i).getName() + " picked letter " + playerLetter + "\n");
			commonPot.addLetter(playerLetter);
		}
	}
	private void addNewPlayer(int id)
	{
		String name = askPlayerName();
		Player playerToAdd = new Player(id, name);
		players.add(playerToAdd);
	}
	
	public int getNbOfPlayers()
	{
		return this.nbOfPlayers;
	}
	
	private String askPlayerName()
	{
		String newName;
		do
		{
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a name for the player :");
			newName = reader.nextLine();
			isPlayerNameValid(newName);
				
		}while (isPlayerNameValid(newName) == false);
		return newName;
	}
	
	private boolean isPlayerNameValid(String nameToTest)
	{
		for(Player player : players)
		{
			if(player.getName() == nameToTest)
			{
				System.out.println("Somebody already has this name !");
				return false;
			}
		}
		return true;
	}
	
	private int chooseFirstPlayer()
	{
		int firstPlayerIndex = commonPot.getMinimumLetterIndex();
		System.out.println("Player " + players.get(firstPlayerIndex).getName() + " will begin.\n");
		return commonPot.getMinimumLetterIndex();
	}

	public void launchGame()
	{
		showPlayers();
		showCommonPot();
		newTurn(currentPlayerIndex);
	}
	
	private void newTurn(int playerIndex)
	{
		System.out.println(getPlayerNameFromId(playerIndex) + ", it is your turn.\n");
	}
	
	private String getPlayerNameFromId(int playerIndex)
	{
		return players.get(playerIndex).getName();
	}

	private void showPlayers()
	{
		for (int i = 0; i < players.size();i++)
		{
			System.out.println(players.get(i).getName());
		}
	}
	
	private void showCommonPot()
	{
		System.out.println(commonPot.getLetters().toString());
	}
}
