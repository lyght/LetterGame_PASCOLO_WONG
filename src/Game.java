
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	Dictionnary dictionnary = null;
	ArrayList<Player> players = new ArrayList<>();
	
	LetterContainer commonPot = new LetterContainer();
	
	int nbOfPlayers = 0;
	int nbOfIA = 0;
	int currentPlayerIndex = -1;
	
	Game(int nbOfPlayersSet, int nbOfIASet, String dictionnaryPath)
	{
		try
		{
			this.dictionnary = new Dictionnary(dictionnaryPath);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		this.nbOfPlayers = nbOfPlayersSet;
		this.nbOfIA = nbOfIASet;
		createPlayers();
		createIA();
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
	
	private void createIA()
	{
		for(int i = nbOfPlayers; i< nbOfIA+nbOfPlayers;i++)
		{
			System.out.println("Player IA " + (i+1) + " :");
			addNewIA(i);
			Letter playerLetter = LetterFactory.getLetter();
			System.out.println("(" + players.get(i).getName() + " picked letter " + playerLetter + " )\n");
			commonPot.addLetter(playerLetter);
		}
	}
	private void addNewIA(int id)
	{
		String name = askPlayerName();
		Player iAToAdd = new Player(id, (name + "(IA)"));
		players.add(iAToAdd);
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
			newName = inputScan("Enter a name for the player :");
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
			if(nameToTest.contains("(IA)"))
			{
				System.out.println("You can't put (IA) in a player's name !");
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
		LetterFactory.initializeLettersFrequency();
		newTurn(currentPlayerIndex);
	}
	
	private void changePlayer()
	{
		currentPlayerIndex = (currentPlayerIndex + 1)%(nbOfPlayers+nbOfIA);
		System.out.println();
		newTurn(currentPlayerIndex);
	}
	
	private void newTurn(int playerIndex)
	{
		String playerName = getPlayerNameFromId(playerIndex);
		System.out.println(playerName + (" is now playing.\n").toUpperCase());
		addLettersToCommonPot(2);
		showCommonPot();
		showPlayerBoards();
		if(!isIA(playerName))
		{
			newPlayerTurn(playerIndex);
		}
		else
		{
			newIATurn(playerName);
		}
		changePlayer();
	}
	
	private boolean isIA(String playerName)
	{
		if(playerName.contains("(IA)"))
			return true;
		else
			return false;
	}
	
	private void newPlayerTurn(int playerIndex)
	{
		int choice = -1;
		while (choice == -1)
		{
			choice = selectChoice();
		}
		while(choice != 3)
		{
			if(doActionWithChoice(choice))
			{
				addLettersToCommonPot(1);
				choice = -1;
				showCommonPot();
				showPlayerBoards();
				System.out.println("You can play again.");
				
			}
			do{
				choice = selectChoice();
			}while(choice == -1);
		}
	}
	
	private void newIATurn(String playerAIName)
	{
		String iAWord = AImakeWordWithCommonLetters();
		if(iAWord != "")
		{
			addLettersToCommonPot(1);
			System.out.println(playerAIName + " made the word " + iAWord);
		}
		else
		{
			System.out.println(playerAIName + " did not manage to make a word");
		}
	}
	
	private int selectChoice()
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number corresponding to your action:\n1 to make a word from the common pot \n2 to make your word from another word\n3 to pass");
		if(reader.hasNextInt())
		{
			int choice = reader.nextInt();
			if(choice != 1 && choice != 2 && choice != 3)
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
		else if(choice == 2)
			return makeWordWithOtherPlayerWord();
		else if(choice == 3)
			return false;
		return false;
	}
	
	private boolean makeWordWithCommonLetters()
	{
		String wordString;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the word you want to make:");
		wordString = reader.nextLine();
		Word word = new Word(wordString);
		if(dictionnary.isWordValid(wordString) && doesCommonPotContainsLettersOf(word.getLetters()))
		{
			commonPot.removeLetters(word.getLetters());
			players.get(currentPlayerIndex).addWordToPlayerBoard(wordString);
			return true;
		}
		return false;
	}
	
	private String AImakeWordWithCommonLetters()
	{
		for(int i=0; i<dictionnary.getNbOfWords(); i++)
		{
			String wordString = dictionnary.getWordWithIndex(i);
			Word word = new Word(wordString);
			//System.out.println(x);
			if(doesCommonPotContainsLettersOf(word.getLetters()))
			{
				commonPot.removeLetters(word.getLetters());
				players.get(currentPlayerIndex).addWordToPlayerBoard(wordString);
				return wordString;
			}
		}
		return "";
	}
	
	private boolean makeWordWithOtherPlayerWord()
	{
		
		String playerName = inputScan("Enter the name of the player:");
		
		Player playerToSteal = getPlayerByName(playerName);
		if(playerToSteal == null)
			return false;
		
		String wordToStealString = inputScan("Enter the word you want to steal:");
		Word wordToSteal = new Word(wordToStealString);
		if(playerToSteal.hasWord(wordToSteal))
		{
			
			String newWordString = inputScan("Enter the new word:");
			if(newWordString.equalsIgnoreCase(wordToStealString))
			{
				System.out.println("The word needs to be changed");
				return false;
			}
			else
			{
				Word newWord = new Word(newWordString);
				ArrayList<Letter> rest = commonPot.lettersDifference(newWord.getLetters(), wordToSteal.getLetters());
				if(dictionnary.isWordValid(newWordString) && doesCommonPotContainsLettersOf(rest))
				{
					commonPot.removeLetters(rest);
					playerToSteal.stealWord(wordToSteal);
					players.get(currentPlayerIndex).addWordToPlayerBoard(newWordString);
					return true;
				}
			}
		}
		return false;
	}
	
	private Player getPlayerByName(String playerName)
	{
		for(Player player : players)
		{
			if(player.getName().equalsIgnoreCase(playerName) || (player.getName()).equalsIgnoreCase(playerName + "(IA)"))
			{
				return player;
			}
		}
		System.out.println("This player does not exist");
		return null;
	}
	
	private boolean doesCommonPotContainsLettersOf(ArrayList<Letter> letters)
	{
		return commonPot.isWordPossibleWith(letters);
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
	
	private String inputScan(String question)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println(question);
		return reader.nextLine();
	}
	
	public static void endGame()
	{
		Main.begin();
	}
}