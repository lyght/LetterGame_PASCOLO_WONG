import java.util.ArrayList;

public class Word
{
	ArrayList<Letter> letters = new ArrayList<Letter>();
	
	Word(String word)
	{
		stringWordToLetters(word);
	}
	
	private void stringWordToLetters(String word)
	{
		char[] lettersCharacters = word.toCharArray();
		for(int i=0; i< lettersCharacters.length; i++)
		{
			letters.add(new Letter(lettersCharacters[i]));
		}
	}
	
	public ArrayList<Letter> getLetters()
	{
		return letters;
	}
}
