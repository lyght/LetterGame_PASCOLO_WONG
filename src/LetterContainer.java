import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LetterContainer
{
	ArrayList<Letter> letters = new ArrayList<Letter>();
	
	public ArrayList<Letter> getLetters()
	{
		return letters;
	}
	
	public void addLetter(Letter letterToAdd)
	{
		letters.add(letterToAdd);
	}
	
	public int getMinimumLetterIndex()
	{
		int minimumIndex = 0;
		for (int i=0; i<letters.size(); i++)
		{
			if(letters.get(i).toInt() < letters.get(minimumIndex).toInt())
				minimumIndex = i;
		}
		return minimumIndex;
	}
	
	public boolean isWordPossibleWith(ArrayList<Letter> lettersToTest)
	{
		
		if(lettersToTest.size() > letters.size())
		{
			System.out.println("This word cannot be made with available letters.");
			return false;
		}
		ArrayList<Letter> lettersSave = new ArrayList<Letter>(lettersToTest);
		lettersToTest.removeAll(letters);
		if(lettersToTest.size() == 0)
		{
			this.letters.removeAll(lettersSave);
			return true;
		}
		else
			return false;
	}
}
