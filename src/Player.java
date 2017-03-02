import java.util.Objects;

public class Player
{
	String name;
	int id;
	
	Player(int newId, String newName)
	{
		
		this.id = newId;
		this.name = newName;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getWords()
	{
		//if()
		System.out.println(this.name + " got the words:");
		return "None";
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
