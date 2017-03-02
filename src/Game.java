import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	ArrayList<Player> players = new ArrayList<>();
	
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
			Letter playerLetter = LetterFactory.getLetter();
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
		//showCommonPot();
		newTurn(currentPlayerIndex);
	}
	
	private void newTurn(int playerIndex)
	{
		System.out.println(getPlayerNameFromId(playerIndex) + ", it is your turn.\n");
		showCommonPot();
		showPlayerBoards();
		addLettersToCommonPot(2);
		int choice = -1;
		while (choice == -1)
		{
			choice = selectChoice();
		}
		doActionWithChoice(choice);
	}
	
	private int selectChoice()
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Write the number:\n1 to make a word from the common pot \n2 to make your word from another player word");
		if(reader.hasNextInt())
		{
			int choice = reader.nextInt();
			if(choice != 1 && choice != 2)
			{
				System.out.println("Please enter a valid choice");
				return -1;
			}
			else
				return choice;
		}
		else
		{
			System.out.println("Please enter a valid choice");
			return -1;
		}
	}
	
	private void doActionWithChoice(int choice)
	{
		if(choice == 1)
			makeWordWithCommonLetters();
		else
			makeWordWithStolenWord();
	}
	
	private void makeWordWithCommonLetters()
	{
		//showCommonPot();
		System.out.println("Type the word you want to make:");
	}
	
	private void makeWordWithStolenWord()
	{
		System.out.println("Type the name of the player:");
	}
	
	private void addLettersToCommonPot(int nbOfLetters)
	{
		for (int i=0; i<nbOfLetters; i++)
		{
			Letter letterToAdd = LetterFactory.getLetter();
			commonPot.addLetter(letterToAdd);
		}
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
	
	private void showPlayerBoards()
	{
		for(Player player : players)
		{
			System.out.println(player.getWords());
		}
		System.out.println();
	}
	
	private void showCommonPot()
	{
		System.out.println("The common pot contains the letters:");
		System.out.println(commonPot.getLetters().toString());
		System.out.println();
	}
}
