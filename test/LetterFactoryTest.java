import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LetterFactoryTest {


	@Test
	public void TestgetRandomCharacter (){
		
		ArrayList<Character> letters = new ArrayList<Character>();
		for(int i =0; i<100000;i++){
			
			 letters.add((char)LetterFactory.getLetter().toInt());
			 
		}
		int[] increment = new int [26];
		int index =0;
		for(char letter ='A'; letter<('A'+26);letter++){
			
			for(int j =0; j<letters.size();j++){

				if(letter==letters.get(j)){
					increment[index]++;
				}
			}
			index++;
		}

		for(int i = 0; i<26;i++){
			
				if(increment[i]/1000>40){
					fail("getRandomCharacter n'est pas si Random !");
				}

		}
		
	}
	
}
	
