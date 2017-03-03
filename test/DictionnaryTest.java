import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
public class DictionnaryTest {
	
	static String dictionnaryPath;
	static Dictionnary dico;
	
	@BeforeClass
	static public void setUp() throws Exception{
	try
	{
		 dictionnaryPath = "src/resources/dico.txt";

		dico = new Dictionnary(dictionnaryPath);
		
	} catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	}
	
	@Test
	public void testIsWordValid() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowValidWords() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNbOfWords() {
		assertEquals(dico.getNbOfWords(),22740);
	}

	@Test
	public void testGetWordWithIndex() {
		assertEquals(dico.getWordWithIndex(0),"abaissé".toUpperCase());
		assertEquals(dico.getWordWithIndex(12283),"jaunir".toUpperCase());
		assertEquals(dico.getWordWithIndex(22739),"zygote".toUpperCase());

	}

}
