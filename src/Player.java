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
	}
	
	public boolean stealWord(Word wordStolen)
	{
		System.out.println("Word to test is " + wordStolen.toString());
		for(Word word : playerBoard)
		{
			System.out.println("Word of PlayerBoard is " + word.toString());
			if(word.equals(wordStolen))
			{
				playerBoard.remove(wordStolen);
				return true;
			}
		}
		return false;
	}

	 @Override
	    public boolean equals(Object o) {
/*
	        if (o == this) return true;
	        if (!(o instanceof Player)) {
	            return false;
	        }*/
	        Player player1 = (Player) o;
	        return id == player1.id &&
	                Objects.equals(name, player1.name);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(name, id);
	    }
}
