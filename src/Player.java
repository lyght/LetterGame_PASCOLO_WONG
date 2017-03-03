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
			System.out.println(playerBoard.toString());
		}
	}
	
	public void addWordToPlayerBoard(Word wordToAdd)
	{
		playerBoard.add(wordToAdd);
	}
	
	public boolean stealWord(Word wordStolen)
	{
		if (playerBoard.contains(wordStolen))
		{
			return true;
		}
		else
		{
			return false;
		}
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