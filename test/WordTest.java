import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WordTest {
String test;
	Word mot ;
	Word mot2 ;
	Word faux;
	String accent;
	ArrayList<Letter> letters ;	
    
	@Before
    public void setUp() {
		
		test ="Test";
		mot = new Word(test);
		mot2 = new Word(test);
		faux = new Word("Faux");
		accent ="àccént";
		letters = new ArrayList<Letter>();
	}

	@Test
	public void testHashCode() {
		assertEquals(mot.hashCode(),mot2.hashCode());
		assertNotEquals(mot.hashCode(),faux.hashCode());

	}

	@Test
	public void testGetLetters() {
		char[] lettersCharacters = test.toCharArray();
		for(int i=0; i< lettersCharacters.length; i++)
		{
			letters.add(new Letter(lettersCharacters[i]));
		}
		
		assertEquals(mot.getLetters(),letters);
		assertNotEquals(faux.getLetters(),letters);

	}

	@Test
	public void testStripAccents() {
		assertEquals(mot.stripAccents(accent),"accent");
	}

	@Test
	public void testToInt() {
		assertTrue(mot.toInt()==320 && faux.toInt()==308);
	}

	@Test
	public void testToString() {
		assertEquals(mot.toString(),test.toUpperCase());
		assertEquals(faux.toString(),"Faux".toUpperCase());

	}

	@Test
	public void testEqualsObject() {
		assertTrue(mot.equals(mot2));
		assertTrue(mot2.equals(mot));
		assertFalse(mot.equals(faux));
		assertFalse(faux.equals(mot));




	}

}
