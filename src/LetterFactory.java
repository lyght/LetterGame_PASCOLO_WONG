import java.util.Random;

public class LetterFactory
{
	public static Letter getLetter()
	{
		return new Letter(getRandomCharacter());
	}
	
	private static char getRandomCharacter()
	{
		Random r = new Random();
		char randomCharacter = (char)(r.nextInt(26) + 'A');
		return randomCharacter;
	}
}