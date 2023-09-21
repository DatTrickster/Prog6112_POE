/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package justfight;

// Base class for characters in the game
public class CharacterBP {
    private String damageType;    // The type of damage the character can inflict
    private String characterClass; // The class of the character
    private int health;           // The current health of the character

    // Constructor to initialize a character with damage type and character class
    public CharacterBP(String damageType, String characterClass) {
        this.damageType = damageType;       // Set the damage type
        this.characterClass = characterClass; // Set the character class
        this.health = 1000; // Set initial health to 1000 HP
    }

    // Getter method to retrieve the damage type of the character
    public String getDamageType() {
        return damageType;
    }

    // Getter method to retrieve the character class
    public String getCharacterClass() {
        return characterClass;
    }

    // Getter method to retrieve the current health of the character
    public int getHealth() {
        return health;
    }

    // Method to reduce the character's health by a specified amount (damage)
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    // Method to check if the character is alive (health greater than 0)
    public boolean isAlive() {
        return health > 0;
    }

    // Override the toString method to provide a string representation of the character
    @Override
    public String toString() {
        return "Damage Type = " + damageType + ", Class = " + characterClass + ", Health = " + health;
    }
}

