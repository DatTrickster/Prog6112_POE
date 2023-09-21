package justfight;

// Warrior is a subclass of CharacterBP
public class Warrior extends CharacterBP {
    private int armor; // Private field to store the armor value for the warrior

    // Constructor to initialize a Warrior object with damage type, character class, and armor
    public Warrior(String damageType, String characterClass, int armor) {
        super(damageType, characterClass); // Call the superclass constructor to set damage type and character class
        this.armor = armor; // Set the armor value for the warrior
    }

    // Getter method to retrieve the armor value
    public int getArmor() {
        return armor;
    }

    // Override the takeDamage method to account for armor
    @Override
    public void takeDamage(int damage) {
        // Reduce damage taken based on armor
        int actualDamage = damage - armor;
        if (actualDamage < 0) {
            actualDamage = 0;
        }
        super.takeDamage(actualDamage); // Call the superclass's takeDamage method to update character's health
    }

    // Override the toString method to provide a string representation of the warrior
    @Override
    public String toString() {
        return super.toString() + ", Armor = " + armor; // Include armor in the string representation
    }
}
