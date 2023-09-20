package justfight;

public class Warrior extends CharacterBP {
    private int armor;

    public Warrior(String damageType, String characterClass, int armor) {
        super(damageType, characterClass);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void takeDamage(int damage) {
        // Reduce damage taken based on armor
        int actualDamage = damage - armor;
        if (actualDamage < 0) {
            actualDamage = 0;
        }
        super.takeDamage(actualDamage); // Call the superclass's takeDamage method
    }

    @Override
    public String toString() {
        return super.toString() + ", Armor = " + armor;
    }
}
