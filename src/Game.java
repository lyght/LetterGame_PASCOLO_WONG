import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	Dictionnary dictionnary = null;
	ArrayList<Player> players = new ArrayList<>();
	
	LetterContainer commonPot = new LetterContainer();
	
	int nbOfPlayers = 0;
	int currentPlayerIndex = -1;
	
	Game(int nbOfPlayers, String dictionnaryPath)
	{
		try
		{
			this.dictionnary = new Dictionnary(dictionnaryPath);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
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
			System.out.println("(" + players.get(i).getName() + " picked letter " + playerLetter + " )\n");
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
		System.out.println(("Player " + players.get(firstPlayerIndex).getName() + " will begin.\n").toUpperCase());
		return commonPot.getMinimumLetterIndex();
	}

	public void launchGame()
	{
		newTurn(currentPlayerIndex);
	}
	
	private void changePlayer()
	{
		currentPlayerIndex = (currentPlayerIndex + 1)%nbOfPlayers;
		newTurn(currentPlayerIndex);
	}
	
	private void newTurn(int playerIndex)
	{
		System.out.println(getPlayerNameFromId(playerIndex) + ", it is your turn.\n");
		addLettersToCommonPot(2);
		showCommonPot();
		showPlayerBoards();
		
		int choice = -1;
		while (choice == -1)
		{
			choice = selectChoice();
		}
		while(doActionWithChoice(choice))
		{
			addLettersToCommonPot(1);
			choice = -1;
			showCommonPot();
			showPlayerBoards();
			System.out.println("You can play again.");
			while (choice == -1)
			{
				choice = selectChoice();
			}
		}
		changePlayer();
	}
	
	private int selectChoice()
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number corresponding to your action:\n1 to make a word from the common pot \n2 to make your word from another player word");
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
	
	private boolean doActionWithChoice(int choice)
	{
		if(choice == 1)
			return makeWordWithCommonLetters();
		else
			return makeWordWithOtherPlayerWord();
	}
	
	private boolean makeWordWithCommonLetters()
	{
		String wordString;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the word you want to make:");
		wordString = reader.nextLine();
		Word word = new Word(wordString);
		if(dictionnary.isWordValid(wordString) && doesCommonPotContainsLettersOf(word))
		{
			players.get(currentPlayerIndex).addWordToPlayerBoard(wordString);
			System.out.println("The word " + wordString.toUpperCase() + " has been added to your player board.");
			return true;
		}
		return false;
	}
	
	private boolean makeWordWithOtherPlayerWord()
	{
		String playerName;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the name of the player:");
		playerName = reader.nextLine();
		Player playerToSteal = getPlayerByName(playerName);
		String wordToStealString;
		System.out.println("Enter the word you want to steal:");
		wordToStealString = reader.nextLine();
		if(playerToSteal.stealWord(new Word(wordToStealString)))
		{
			players.get(currentPlayerIndex).addWordToPlayerBoard(wordToStealString);
			return true;
		}
		return false;
	}
	
	private Player getPlayerByName(String playerName)
	{
		for(Player player : players)
		{
			if(player.getName().equalsIgnoreCase(playerName))
			{
				return player;
			}
		}
		System.out.println("This player does not exist");
		makeWordWithOtherPlayerWord();
		return null;
	}
	
	private boolean doesCommonPotContainsLettersOf(Word wordEntered)
	{
		return commonPot.isWordPossibleWith(wordEntered.getLetters());
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
			player.showPlayerBoard();
			System.out.println();
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