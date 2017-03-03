import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class LetterTest {

	Letter lettre = new Letter('T');

		@Test 
		public void TestLetter(){
			
			Letter test = new Letter('T');
			Letter test2 = new Letter('A');

			assertTrue(lettre.equals(test));
			assertTrue(test.equals(lettre));
			assertFalse(lettre.equals(test2));
			assertFalse(test2.equals(lettre));


			
		}
		@Test
		public void TesttoString(){
			Random rand = new Random();
			
			
			char maj = (char) (rand.nextInt(26) + 'A');
			Letter lettre_maj = new Letter(maj);
			assertEquals(lettre_maj.toString().charAt(0),maj);

		}
		@Test
		public void TesttoInt()
		{
Random rand = new Random();
			
			int min = (char) (rand.nextInt(26) + 'A');
			Letter lettre_min = new Letter((char)min);
			assertEquals(lettre_min.toInt(),min);
			

		}
}

