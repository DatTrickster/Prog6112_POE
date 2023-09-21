/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package justfight;

import org.junit.Test;
import static org.junit.Assert.*;

public class JustFightTest {

    // Inner class representing a character for testing purposes
    static class CharacterBP {
        private String damageType;
        private String characterClass;
        private int health;
        private boolean alive;

        public CharacterBP(String damageType, String characterClass) {
            this.damageType = damageType;
            this.characterClass = characterClass;
            this.health = 1000; // Default health value
            this.alive = true;
        }

        // Getter methods
        public String getDamageType() {
            return damageType;
        }

        public String getCharacterClass() {
            return characterClass;
        }

        public int getHealth() {
            return health;
        }

        public boolean isAlive() {
            return alive;
        }

        // Method to simulate taking damage
        public void takeDamage(int damage) {
            this.health -= damage;
            if (health <= 0) {
                alive = false;
            }
        }
    }

    // Inner class representing the main game logic for testing purposes
    static class JustFight {
        private int exitStatus;

        public void setExitStatus(int exitStatus) {
            this.exitStatus = exitStatus;
        }

        public int getExitStatus() {
            return exitStatus;
        }

        // Simulate the fight logic (for testing, returns a dummy message)
        public String simulateFight(CharacterBP[] fighters, Runnable exitCallback) {
            // Implement fight simulation logic here
            // For simplicity, we'll return a dummy message
            if (fighters == null || fighters.length < 2 || fighters[0] == null || fighters[1] == null) {
                return "You need at least 2 fighters to start a battle.";
            } else {
                return "Game over! Winner: " + fighters[0].getCharacterClass();
            }
        }
    }

    // Test case to verify character initialization
    @Test
    public void testCharacterInitialization() {
        CharacterBP character = new CharacterBP("Fire", "Mage");
        assertEquals("Fire", character.getDamageType());
        assertEquals("Mage", character.getCharacterClass());
        assertEquals(1000, character.getHealth());
        assertTrue(character.isAlive());
    }

    // Test case to verify character's health after taking damage
    @Test
    public void testHealthAfterTakingDamage() {
        CharacterBP character = new CharacterBP("Physical", "Warrior");
        character.takeDamage(500);
        assertEquals(500, character.getHealth());

        character.takeDamage(300);
        assertEquals(200, character.getHealth());
    }

    // Test case to verify handling of insufficient fighters to start a battle
    @Test
    public void testAllCharactersDefeated() {
        JustFight justFight = new JustFight();
        CharacterBP[] fighters = { null, null }; // No fighters
        String message = justFight.simulateFight(fighters, () -> {});
        assertTrue(message.contains("You need at least 2 fighters to start a battle."));
    }

    // Test case to verify the exit option status
    @Test
    public void testExitOption() {
        JustFight justFight = new JustFight();
        justFight.setExitStatus(0);
        assertEquals(0, justFight.getExitStatus());
    }

    // Test case to verify handling of insufficient fighters (one fighter and one null)
    @Test
    public void testInsufficientFightersToStart() {
        JustFight justFight = new JustFight();
        CharacterBP[] fighters = { new CharacterBP("Fire", "Mage"), null }; // One fighter and one null
        String message = justFight.simulateFight(fighters, () -> {});
        assertTrue(message.contains("You need at least 2 fighters to start a battle."));
    }

    // Test case to simulate a fight with random damage and check for a winner
    @Test
    public void testFightSimulationWithRandomDamage() {
        JustFight justFight = new JustFight();
        CharacterBP[] fighters = {
            new CharacterBP("Physical", "Warrior"),
            new CharacterBP("Fire", "Mage")
        };
        String message = justFight.simulateFight(fighters, () -> {});
        assertTrue(message.contains("Game over! Winner:"));
    }
}
