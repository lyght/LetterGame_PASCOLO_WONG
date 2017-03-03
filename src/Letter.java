public class Letter
{
	char letterCharacter;
	Letter(char newLetterCharacter)
	{
		this.letterCharacter = Character.toUpperCase(newLetterCharacter);
	}

	public String toString()
	{
		return Character.toString(this.letterCharacter);
	}
	
	public int toInt()
	{
		return (int)letterCharacter;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == this)
			return true;
		if(!(other instanceof Letter))
			return false;
		Letter otherLetter = (Letter)other;
		return (this.toInt() == otherLetter.toInt());
	}
	
	@Override
	public int hashCode()
	{
		int hash = 5;
		hash *= this.toInt();
		return hash;
	}
}
