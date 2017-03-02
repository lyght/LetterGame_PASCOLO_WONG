import java.util.Random;

public class Letter
{
	char letterCharacter;
	Letter(char letterCharacter)
	{
		this.letterCharacter = letterCharacter;
	}
	
	
	
	public String toString()
	{
		return Character.toString(this.letterCharacter);
	}
	
	public int toInt()
	{
		return (int)letterCharacter;
	}
}