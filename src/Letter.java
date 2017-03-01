import java.util.Random;

public class Letter
{
	char letterCharacter;
	Letter()
	{
		letterCharacter = getRandomLetter();
	}
	
	private char getRandomLetter()
	{
		Random r = new Random();
		char randomCharacter = (char)(r.nextInt(26) + 'A');
		return randomCharacter;
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
