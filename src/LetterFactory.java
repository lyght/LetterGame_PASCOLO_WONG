import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LetterFactory
{
	static char[] letters = new char[1683];
	public static Letter getLetter()
	{
		initializeLettersFrequency();
		return new Letter(getRandomCharacter());
	}
	
	private static char getRandomCharacter()
	{
		int letterPosition = getRandomNumberFrom0To(letters.length);
		char randomCharacter = getLetterFromPosition(letters, letterPosition);
		return randomCharacter ;
	}
	
	public static void initializeLettersFrequency()
	{
		letters = getFrequencyFromFile("/resources/lettersFrequency.txt");
	}
	
	private static char[] getFrequencyFromFile(String path)
	{
		String rawFrequencies = "";
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(path));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		while (scanner.hasNext())
		{
			rawFrequencies = scanner.nextLine();
		}
		return rawFrequencies.toCharArray();
	}
	
	private static char getLetterFromPosition(char[] letters, int position)
	{
		return letters[position];
	}
	
	private static int getRandomNumberFrom0To(int max)
	{
		Random r = new Random();
		return r.nextInt(max);
	}
	
	
}