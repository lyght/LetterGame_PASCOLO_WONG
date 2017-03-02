import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Test;

public class PlayerTest {
	
Player name = new Player(1,"Test");

	
	@Test
	public void testPlayer() {
		Player name2 = new Player(1,"Test");

		assertTrue(this.name.equals(name2));
		assertEquals(this.name.hashCode(),name2.hashCode());
	}

	@Test
	public void testGetName() {
		Player name2 = new Player(1,this.name.name);
		assertEquals(name2.getName(),this.name.getName());
	}


}
