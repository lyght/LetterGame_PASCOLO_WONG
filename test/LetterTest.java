import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class LetterTest {


		
		@Test
		public void TesttoString(){
			Random rand = new Random();
			
			char min = (char) (rand.nextInt(26) + 'a');
			Letter lettre_min = new Letter(min);
			assertEquals(lettre_min.toString().charAt(0),min);
			
			char maj = (char) (rand.nextInt(26) + 'A');
			Letter lettre_maj = new Letter(maj);
			assertEquals(lettre_maj.toString().charAt(0),maj);

		}
		@Test
		public void TesttoInt()
		{
Random rand = new Random();
			
			int min = (char) (rand.nextInt(26) + 'a');
			Letter lettre_min = new Letter((char)min);
			assertEquals(lettre_min.toInt(),min);
			
			int maj = (char) (rand.nextInt(26) + 'A');
			Letter lettre_maj = new Letter((char)maj);
			assertEquals(lettre_maj.toInt(),maj);
		}
}

