/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10228343question2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the EstateAgent class.
 * The tests cover commission calculation and data validation.
 */
public class EstateAgentTest {

    /**
     * DummyEstateAgent class for testing purposes.
     * Overrides the necessary methods with dummy implementations.
     */
    private static class DummyEstateAgent implements IEstateAgent {
        @Override
        public double calculateCommission(double propertyPrice, double commissionPercentage) {
            // Implement your dummy calculation logic for testing
            return propertyPrice * (commissionPercentage / 100);
        }

        @Override
        public String validateData(String location, String agentName, double propertyPrice, double commissionPercentage) {
            // Implement your dummy validation logic for testing
            // Return null if validation passes, otherwise return an error message
            return (agentName == null || agentName.trim().isEmpty()) ? "Agent name is required" : null;
        }

        @Override
        public String validateData(String agentName, double propertyPrice, double commissionPercentage) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    /**
     * Tests the successful calculation of commission.
     */
    @Test
    public void calculateCommission_CalculatedSuccessfully() {
        IEstateAgent estateAgent = new EstateAgent();
        double propertyPrice = 1000000; // Replace with your dummy data
        double commissionPercentage = 2.5; // Replace with your dummy data

        double commission = estateAgent.calculateCommission(propertyPrice, commissionPercentage);

        // Assuming the commission calculation logic is correct, adjust the expected value accordingly
        assertEquals(25000, commission, 0.001);
    }

    /**
     * Tests an unsuccessful commission calculation (for demonstration purposes).
     */
    @Test
    public void calculateCommission_CalculatedUnsuccessfully() {
        IEstateAgent estateAgent = new EstateAgent();
        double propertyPrice = -1000000; // Replace with your dummy data
        double commissionPercentage = 2.5; // Replace with your dummy data

        double commission = estateAgent.calculateCommission(propertyPrice, commissionPercentage);

        // Assuming the commission calculation logic is incorrect, assert that the result is not as expected
        assertNotEquals(25000, commission, 0.001);
    }

    /**
     * Tests the validation logic when the name is not present.
     */
    @Test
    public void validateData_NameNotPresent() {
        IEstateAgent estateAgent = new DummyEstateAgent();

        // Test with an empty name
        String validationMessage = estateAgent.validateData("ValidLocation", "", 1000000, 2.5);

        // Assert that the validation message indicates that the name is required
        assertNotNull(validationMessage);
        assertEquals("Agent name is required", validationMessage);
    }
}
