import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionnary
{
	ArrayList<String> dictionnaryWords = new ArrayList<String>();
	
	Dictionnary(String path) throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new File(path));
		
		while (scanner.hasNext())
		{
			dictionnaryWords.add(scanner.nextLine().toUpperCase());
		}
	}
	
	public boolean isWordValid(String wordToTest)
	{
		if(dictionnaryWords.contains(wordToTest.toUpperCase()))
		{
			return true;
		}
		System.out.println("This word does not exist");
		return false;
	}
	public void showValidWords()
	{
		System.out.println(dictionnaryWords.toString());
	}
}
