package com.MegicalArena;


public class PlayerTest {

 
    public void testTakeDamage() {
        Player player = new Player(50, 5, 10);
        player.takeDamage(20);
        assertEquals(30, player.getHealth());
        
        player.takeDamage(40);
        assertEquals(0, player.getHealth());
    }

    private void assertEquals(int expected, int actual) {
		// TODO Auto-generated method stub
    	if (expected != actual) {
            throw new AssertionError("Expected: " + expected + ", but was: " + actual);
        }
		
	}

	
    public void testIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
        
        player.takeDamage(50);
        assertFalse(player.isAlive());
    }

	private void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true, but it was false.");
        }
    }

    // Custom implementation of assertFalse for demonstration purposes
    private void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Expected condition to be false, but it was true.");
        }
    }
}
