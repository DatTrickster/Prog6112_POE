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
                case 0: // Add Fighter
                    String damageType = JOptionPane.showInputDialog("Enter the damage type for the character:");
                    if (damageType == null || damageType.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a damage type.");
                        continue;
                    }

                    String characterClass = JOptionPane.showInputDialog("Enter the class for the character:");
                    if (characterClass == null || characterClass.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a character class.");
                        continue;
                    }
                    characters.add(new CharacterBP(damageType, characterClass));
                    break;

                case 1: // Start Battle
                    if (characters.size() < 2) {
                        JOptionPane.showMessageDialog(null, "You need at least 2 fighters to start a battle.");
                        continue;
                    }

                    String damageInput = JOptionPane.showInputDialog("Enter the damage to inflict:");
                    try {
                        damage = Integer.parseInt(damageInput);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric damage value.");
                        continue;
                    }

                    // Start the battle logic (similar to your previous code)
                    Random random = new Random();
                    while (characters.size() > 1) {
                        int attackerIndex = random.nextInt(characters.size());
                        int defenderIndex = random.nextInt(characters.size());
                        if (defenderIndex == attackerIndex) {
                            defenderIndex = (defenderIndex + 1) % characters.size();
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
                            Thread.sleep(1000); // 1000 milliseconds = 1 seconds
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
                    break;

                case 2: // Exit
                    System.exit(0);
            }
        }
    }
}
