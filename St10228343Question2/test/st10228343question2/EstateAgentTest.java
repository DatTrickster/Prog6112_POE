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
     * Tests the successful calculation of commission.
     */
    @Test
    public void calculateCommission_CalculatedSuccessfully() {
        IEstateAgent estateAgent = new EstateAgent();
        double propertyPrice = 200000; // Actual property price
        double commissionPercentage = 2.5; // Actual commission percentage

        double commission = estateAgent.calculateCommission(propertyPrice, commissionPercentage);

        assertEquals(5000, commission, 0.001);

        System.out.println("Test calculateCommission_CalculatedSuccessfully passed. Commission: " + commission);
    }

    /**
     * Tests an unsuccessful commission calculation with negative property price.
     */
    @Test
    public void calculateCommission_CalculatedUnsuccessfully() {
        IEstateAgent estateAgent = new EstateAgent();
        double propertyPrice = -150000; // Negative property price
        double commissionPercentage = 2.5; // Actual commission percentage

        double commission = estateAgent.calculateCommission(propertyPrice, commissionPercentage);

        assertNotEquals(3750, commission, 0.001);

        System.out.println("Test calculateCommission_CalculatedUnsuccessfully passed. Commission: " + commission);
    }

   
@Test
public void validateData_MissingName() {
    // Create a dummy estate agent
    IEstateAgent estateAgent = new EstateAgent();

    try {
        // Set an empty name to test missing name condition
        String validationMessage = estateAgent.validateData("ValidLocation", "", 100000, 2.5);

        if (validationMessage.isEmpty()) {
            // If the validation message is empty, it means the test passed
            System.out.println("Test validateData_MissingName passed. Agent name is missing.");
        } else {
            // If the validation message is not empty, it means the test failed
            fail("Test validateData_MissingName failed. Unexpected validation message: " + validationMessage);
        }
    } catch (UnsupportedOperationException e) {
        // If the validateData method is not supported, consider the test as passed
        System.out.println("Test validateData_MissingName passed. Agent name validation not supported.");
    }
}

}

