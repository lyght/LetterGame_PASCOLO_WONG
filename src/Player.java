import java.util.ArrayList;
import java.util.Objects;

public class Player
{
	String name;
	int id;
	ArrayList<Word> playerBoard = new ArrayList<Word>();
	
	Player(int newId, String newName)
	{
		this.id = newId;
		this.name = newName;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void showPlayerBoard()
	{
		if(playerBoard.size() > 0)
		{
			System.out.println(this.name + " got the words:");
			for(Word word : playerBoard)
				System.out.println(word.toString());
		}
	}
	
	public void addWordToPlayerBoard(String wordString)
	{
		playerBoard.add(new Word(wordString));
		System.out.println("The word " + wordString.toUpperCase() + " has been added to your player board.");
		if(playerBoard.size() == 10)
		{
			System.out.println("CONGRATULATIONS, YOU WON THE GAME !");
			Game.endGame();
		}
	}
	
	public boolean hasWord(Word wordStolen)
	{
		for(Word word : playerBoard)
		{
			if(word.equals(wordStolen))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean stealWord(Word wordStolen)
	{
		for(Word word : playerBoard)
		{
			if(word.equals(wordStolen))
			{
				System.out.println("The word " + wordStolen.toString() + " has been removed from " + this.getName().toUpperCase() + "'s player board.");
				playerBoard.remove(wordStolen);
				return true;
			}
		}
		return false;
	}

	 @Override
	    public boolean equals(Object o) 
	 {
	        Player player1 = (Player) o;
	        return id == player1.id &&
	                Objects.equals(name, player1.name);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(name, id);
	    }
}
