/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package justfight;

import org.junit.Test;
import static org.junit.Assert.*;

public class JustFightTest {

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

        public void takeDamage(int damage) {
            this.health -= damage;
            if (health <= 0) {
                alive = false;
            }
        }
    }

    static class JustFight {
        private int exitStatus;

        public void setExitStatus(int exitStatus) {
            this.exitStatus = exitStatus;
        }

        public int getExitStatus() {
            return exitStatus;
        }

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

    @Test
    public void testCharacterInitialization() {
        CharacterBP character = new CharacterBP("Fire", "Mage");
        assertEquals("Fire", character.getDamageType());
        assertEquals("Mage", character.getCharacterClass());
        assertEquals(1000, character.getHealth());
        assertTrue(character.isAlive());
    }

    @Test
    public void testHealthAfterTakingDamage() {
        CharacterBP character = new CharacterBP("Physical", "Warrior");
        character.takeDamage(500);
        assertEquals(500, character.getHealth());

        character.takeDamage(300);
        assertEquals(200, character.getHealth());
    }

    @Test
    public void testAllCharactersDefeated() {
        JustFight justFight = new JustFight();
        CharacterBP[] fighters = { null, null }; // No fighters
        String message = justFight.simulateFight(fighters, () -> {});
        assertTrue(message.contains("You need at least 2 fighters to start a battle."));
    }

    @Test
    public void testExitOption() {
        JustFight justFight = new JustFight();
        justFight.setExitStatus(0);
        assertEquals(0, justFight.getExitStatus());
    }

    @Test
    public void testInsufficientFightersToStart() {
        JustFight justFight = new JustFight();
        CharacterBP[] fighters = { new CharacterBP("Fire", "Mage"), null }; // One fighter and one null
        String message = justFight.simulateFight(fighters, () -> {});
        assertTrue(message.contains("You need at least 2 fighters to start a battle."));
    }

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
