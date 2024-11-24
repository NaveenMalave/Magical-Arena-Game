package com.MegicalArena;

public class ArenaTest {

	public void testFightOutcome_PlayerAWins() {
        Player playerA = new Player(50, 5, 10); // Health: 50, Strength: 5, Attack: 10
        Player playerB = new Player(40, 3, 5);  // Health: 40, Strength: 3, Attack: 5
        
        Arena arena = new Arena(playerA, playerB);
        arena.startFight();

        assertFalse(playerB.isAlive(), "Player B should be defeated");
        assertTrue(playerA.isAlive(), "Player A should still be alive");
    }

	private void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    // Custom implementation of assertFalse for demonstration purposes
    private void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    public void testFightOutcome_PlayerBWins() {
        Player playerA = new Player(30, 2, 5); // Health: 30, Strength: 2, Attack: 5
        Player playerB = new Player(60, 10, 15); // Health: 60, Strength: 10, Attack: 15
        
        Arena arena = new Arena(playerA, playerB);
        arena.startFight();

        assertFalse(playerA.isAlive(), "Player A should be defeated");
        assertTrue(playerB.isAlive(), "Player B should still be alive");
    }

   
    public void testFightOutcome_EqualHealth() {
        Player playerA = new Player(50, 5, 10); // Health: 50, Strength: 5, Attack: 10
        Player playerB = new Player(50, 5, 10); // Health: 50, Strength: 5, Attack: 10
        
        Arena arena = new Arena(playerA, playerB);
        
        // Since both players are equal in strength and attack,
        // we can't predict who will win purely based on attributes,
        // but we can check that one of them will lose.
        
        boolean playerAWins = false;
        
        for (int i = 0; i < 100; i++) { // Run multiple simulations to observe outcomes
            arena.startFight();
            if (!playerA.isAlive()) {
                playerAWins = true; // If A loses at least once
                break;
            }
            // Reset health for the next simulation
            playerA = new Player(50, 5, 10);
            playerB = new Player(50, 5, 10);
            arena = new Arena(playerA, playerB);
        }

        assertFalse(playerAWins, "One of the players should eventually lose.");
    }

   
    public void testFightOutcome_HealthZero() {
        Player playerA = new Player(0, 5, 10); // Health is already zero
        Player playerB = new Player(50, 5, 10); // Normal health
        
        Arena arena = new Arena(playerA, playerB);
        
        assertFalse(playerA.isAlive(), "Player A should be defeated from the start");
        assertTrue(playerB.isAlive(), "Player B should still be alive");
    }
}