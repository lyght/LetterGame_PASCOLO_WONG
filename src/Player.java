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
}
