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
	
	public boolean isWordPossibleWith(ArrayList<Letter> lettersToTest)
	{
		ArrayList<Letter> lettersSave = new ArrayList<Letter>(lettersToTest);
		if(lettersSave.size() > letters.size())
		{
			System.out.println("This word cannot be made with available letters.");
			return false;
		}
		lettersSave = lettersDifference(lettersSave, letters);
		if(lettersSave.size() == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	public ArrayList<Letter> lettersDifference(ArrayList<Letter> listToKeep, ArrayList<Letter> listToRemoveFromFirst)
	{
		ArrayList<Letter> lettersSave = new ArrayList<Letter>(listToKeep);
		for (int i = 0; i < listToRemoveFromFirst.size(); i++)
		{
			listToKeep.remove(listToRemoveFromFirst.get(i));
		}
		/*if(listToKeep.size() == 0)
		{
			removeLettersFromCommonPot(lettersSave);
		}*/
		return listToKeep;
	}
	
	public void removeLetters(ArrayList<Letter> lettersToRemove)
	{
		for (int i = 0; i < lettersToRemove.size(); i++)
		{
			letters.remove(lettersToRemove.get(i));
		}
	}
}
