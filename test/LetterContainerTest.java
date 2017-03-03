import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

public class LetterContainerTest {

	static LetterContainer container = new LetterContainer();
	static ArrayList<Character> mot = new ArrayList<Character>();
	static int min=255;
	static int minIndex;

	@BeforeClass
	public static void setBeforeClass(){
		Letter c;
		Random rand = new Random();
		for(int i =0; i<10;i++){
			c=new Letter( (char)(rand.nextInt(26) + 'a'));
			mot.add(c.toString().charAt(0));
			container.letters.add(c);
			if(min>c.toInt()){
				min=c.toInt();
				minIndex =i;
			}
		}
	}
	@Test
	public void TestgetLetters(){
		fail("Not yet implemented");
	}
	
	@Test
	public void TestaddLetters(){
		Random rand = new Random();
		Letter c= new Letter( (char)(rand.nextInt(26) + 'a'));
		container.addLetter(c);
		assertEquals(c,container.letters.get(container.letters.size()-1));
	}
	@Test
	public void TestMinimumLetterIndex(){
		assertEquals(container.getMinimumLetterIndex(),minIndex);
		
	}
}
