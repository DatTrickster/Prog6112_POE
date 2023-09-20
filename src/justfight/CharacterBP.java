/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package justfight;

public class CharacterBP {
    private String damageType;
    private String characterClass;
    private int health;

    public CharacterBP(String damageType, String characterClass) {
        this.damageType = damageType;
        this.characterClass = characterClass;
        this.health = 1000; // Set initial health to 1000 HP
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

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Damage Type = " + damageType + ", Class = " + characterClass + ", Health = " + health;
    }
}
