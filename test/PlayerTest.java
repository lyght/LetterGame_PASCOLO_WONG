import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	
Player name = new Player(1,"Test");

	
	@Test
	public void testPlayer() {
		Player name2 = new Player(1,"Test");

		assertTrue(this.name.equals(name2));
		assertEquals(this.name.hashCode(),name2.hashCode());
		
		Player name3 = new Player(1,"Faux");

		assertFalse(this.name.equals(name3));
		assertNotEquals(this.name.hashCode(), name3.hashCode());
		
		Player name4 = new Player(2,"Faux");
		assertFalse(this.name.equals(name4));
		assertNotEquals(this.name.hashCode(), name4.hashCode());
	}

	@Test
	public void testGetName() {
		Player name2 = new Player(1,this.name.name);
		assertEquals(name2.getName(),this.name.getName());
		Player name3 = new Player(1,"Faux");
		assertNotEquals(name3.getName(),this.name.getName());
	}


}
