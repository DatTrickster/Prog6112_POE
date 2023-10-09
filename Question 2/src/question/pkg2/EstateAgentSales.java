/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package question.pkg2;

/**
 *
 * @author Extinction
 */

import java.util.Scanner;

// Creates a subclass called EstateAgentSales that extends EstateAgent
public class EstateAgentSales extends EstateAgent {
    // Constructor for the EstateAgentSales class, takes agentName and propertyPrice as parameters
    public EstateAgentSales(String agentName, double propertyPrice) {
        // Call the constructor of the superclass (EstateAgent) with agentName and propertyPrice
        super(agentName, propertyPrice);
    }

    // Method to print the estate agent report
    public void printReport() {
        System.out.println("ESTATE AGENT REPORT");
        System.out.println("***************************");
        // Get the agent's name using the inherited getAgentName method from EstateAgent
        System.out.println("ESTATE AGENT NAME: " + getAgentName());
        // Get the property price using the inherited getPropertyPrice method from EstateAgent
        System.out.println("PROPERTY PRICE: " + getPropertyPrice());
        // Calculate and get the agent's commission using the inherited getAgentCommission method from EstateAgent
        System.out.println("AGENT COMMISSION: " + getAgentCommission());
    }

    // The main method is the entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the current estate agent name
        System.out.print("Enter the current estate agent name: ");
        // Read the input and store it in the agentName variable
        String agentName = scanner.nextLine();

        double price = 0;
        boolean validInput = false;
        // Loop to ensure that the user enters a valid property sale price
        while (!validInput) {
            // Prompt the user to enter the property sale price
            System.out.print("Enter the property sale price: ");
            // Check if the input is a double (a valid number)
            if (scanner.hasNextDouble()) {
                // Read the valid input and store it in the price variable
                price = scanner.nextDouble();
                validInput = true; // Set the flag to true to exit the loop
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        // Create an instance of EstateAgentSales with the provided agentName and price
        EstateAgentSales estateAgentSales = new EstateAgentSales(agentName, price);
        // Call the printReport method to display the estate agent report
        estateAgentSales.printReport();

        // Close the scanner to release resources
        scanner.close();
    }
}

/*  code reference: 

https://www.javatpoint.com/method-overriding-in-java
https://www.w3resource.com/java-exercises/datatypes/java-datatype-exercise-9.php
https://www.geeksforgeeks.org/find-n-integers-given-difference-product-sum/
https://www.geeksforgeeks.org/java-program-to-find-2-elements-in-the-array-such-that-difference-between-them-is-largest/

https://github.com/fb-shaik/PROG6112-Group1-2023.git
*/ 
