import java.util.ArrayList;

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
}
