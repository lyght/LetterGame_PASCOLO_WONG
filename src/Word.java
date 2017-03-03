import java.text.Normalizer;
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
		word = stripAccents(word);
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
	
	public String stripAccents(String s)
	{
		return s == null ? null: Normalizer.normalize(s,  Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
	}
	
}
