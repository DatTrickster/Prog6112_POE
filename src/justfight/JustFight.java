/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/

package justfight;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class JustFight {
    public static void main(String[] args) {
        ArrayList<CharacterBP> characters = new ArrayList<>();
        int damage = 0; // Initialize damage to 0

        while (true) {
            // Display the main menu options
            String[] options = {"Add Fighter", "Start Battle", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "Fight Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0 -> {
                    // Add Fighter
                    String damageType;
                    while (true) {
                        damageType = JOptionPane.showInputDialog("Enter the damage type for the character (numbers only):");

                        if (damageType == null) {
                            // User clicked Cancel, return to the main menu
                            break;
                        }

                        // Check if the input contains only numeric characters
                        if (damageType.matches("\\d+")) {
                            break; // Exit the loop if the input is valid
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a damage type with numbers only.");
                        }
                    }

                    if (damageType == null) {
                        // User clicked Cancel, return to the main menu
                        continue;
                    }

                    String characterClass = JOptionPane.showInputDialog("Enter the class for the character:");
                    if (characterClass == null || characterClass.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a character class.");
                        continue;
                    }

                    int armor = 0;
                    while (true) {
                        String armorInput = JOptionPane.showInputDialog("Enter armor value (0 if none):");
                        if (armorInput == null) {
                            // User clicked Cancel, return to the main menu
                            break;
                        }

                        try {
                            armor = Integer.parseInt(armorInput);
                            break; // Exit the loop if a valid numeric value is entered
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric armor value.");
                        }
                    }

                    characters.add(new Warrior(damageType, characterClass, armor));
                }

                case 1 -> {
                    // Start Battle
                    if (characters.size() < 2) {
                        JOptionPane.showMessageDialog(null, "You need at least 2 fighters to start a battle.");
                        continue;
                    }

                    String damageInput;
                    while (true) {
                        damageInput = JOptionPane.showInputDialog("Enter the damage to inflict (numbers only):");

                        if (damageInput == null) {
                            // User clicked Cancel, return to the main menu
                            break;
                        }

                        // Check if the input contains only numeric characters
                        if (damageInput.matches("\\d+")) {
                            damage = Integer.parseInt(damageInput);
                            break; // Exit the loop if the input is valid
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric damage value.");
                        }
                    }

                    // Start the battle logic
                    Random random = new Random();
                    while (characters.size() > 1) {
                        int attackerIndex = random.nextInt(characters.size());
                        int defenderIndex = random.nextInt(characters.size());
                        while (defenderIndex == attackerIndex) {
                            defenderIndex = random.nextInt(characters.size());
                        }
                        CharacterBP attacker = characters.get(attackerIndex);
                        CharacterBP defender = characters.get(defenderIndex);

                        int inflictedDamage = random.nextInt(damage + 1);
                        defender.takeDamage(inflictedDamage);
                        System.out.println(attacker.getCharacterClass() + " (" + attacker.getDamageType() + ") attacks " +
                                defender.getCharacterClass() + " (" + defender.getDamageType() + ") for " + inflictedDamage + " damage.");

                        if (!defender.isAlive()) {
                            System.out.println(defender.getCharacterClass() + " (" + defender.getDamageType() + ") has been defeated!");
                            characters.remove(defender);
                        }

                        // Sleep for 3 seconds
                        try {
                            Thread.sleep(1000); // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (!characters.isEmpty()) {
                        CharacterBP winner = characters.get(0);
                        System.out.println("Game over! Winner: " + winner.getCharacterClass() + " (" + winner.getDamageType() + ")");
                    } else {
                        System.out.println("Game over! No winners.");
                    }
                }

                case 2 -> // Exit
                    System.exit(0);
            }
        }
    }
}
