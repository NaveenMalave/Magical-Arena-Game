package com.MegicalArena;
import java.util.Random;

public class Arena {
    private Player playerA;
    private Player playerB;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void startFight() {
        Random rand = new Random();
        
        // Determine who attacks first based on health
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (attacker.isAlive() && defender.isAlive()) {
            // Attacker's turn
            int attackRoll = rand.nextInt(6) + 1; // 1-6
            int defendRoll = rand.nextInt(6) + 1; // 1-6
            
            int damageDealt = attackRoll * attacker.getAttack();
            int damageBlocked = defendRoll * defender.getStrength();
            int damageTaken = Math.max(damageDealt - damageBlocked, 0);
            defender.takeDamage(damageTaken);

            System.out.println(defender + " takes " + damageTaken + " damage. Health: " + defender.getHealth());

            // Swap roles for next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println((attacker.isAlive() ? defender : attacker) + " has been defeated!");
    }
}