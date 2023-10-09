/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question.pkg2;

/**
 *
 * @author Extinction
 */

// Define the iEstateAgent interface
interface iEstateAgent {
    // Method to get the agent's name
    String getAgentName();

    // Method to get the property price
    double getPropertyPrice();

    // Method to calculate and get the agent's commission
    double getAgentCommission();
}

// Create an abstract class named EstateAgent implementing the iEstateAgent interface
abstract class EstateAgent implements iEstateAgent {
    private String agentName;     // Variable to store the agent's name
    private double propertyPrice; // Variable to store the property price

    // Constructor for the EstateAgent class, accepts agent's name and property price
    public EstateAgent(String agentName, double propertyPrice) {
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
    }

    // Implementing the getAgentName method from the interface
    @Override
    public String getAgentName() {
        return agentName;
    }

    // Implementing the getPropertyPrice method from the interface
    @Override
    public double getPropertyPrice() {
        return propertyPrice;
    }

    // Implementing the getAgentCommission method from the interface
    @Override
    public double getAgentCommission() {
        // Calculate the agent's commission as 20% of the property price
        return 0.20 * propertyPrice;
    }
}

/*  code reference: 

https://www.javatpoint.com/method-overriding-in-java
https://www.w3resource.com/java-exercises/datatypes/java-datatype-exercise-9.php
https://www.geeksforgeeks.org/find-n-integers-given-difference-product-sum/
https://www.geeksforgeeks.org/java-program-to-find-2-elements-in-the-array-such-that-difference-between-them-is-largest/


*/ 
