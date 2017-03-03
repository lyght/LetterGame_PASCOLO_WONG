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
	
	public int toInt()
	{
		int count = 0;
		for(Letter letter : letters)
		{
			count += letter.toInt();
		}
		return count;
	}
	
	public String toString()
	{
		String word = "";
		for(Letter letter : letters)
		{
			word += letter.toString();
		}
		return word;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == this)
			return true;
		if(!(other instanceof Word))
			return false;
		Word otherWord = (Word)other;
		return (this.toInt() == otherWord.toInt());
	}
	
	@Override
	public int hashCode()
	{
		int hash = 5;
		hash *= this.toInt();
		return hash;
	}
	
}
