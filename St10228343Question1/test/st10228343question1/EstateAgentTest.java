/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10228343question1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Extinction
 */
public class EstateAgentTest {
    
    public EstateAgentTest() {
    }

     @Test
    public void calculateTotalSales_ReturnsTotalSales() {
        // Arrange
        EstateAgent estateAgent = new EstateAgent();
        double[] propertySales = {1000, 2000, 3000}; // Dummy data for property sales

        // Act
        double totalSales = estateAgent.estateAgentSales(propertySales);

        // Assert
        assertEquals(6000, totalSales, 0.01); // Expected total sales
        System.out.println("calculateTotalSales_ReturnsTotalSales passed. Total Sales: " + totalSales);
    }

    @Test
    public void calculateTotalCommission_ReturnsCommission() {
        // Arrange
        EstateAgent estateAgent = new EstateAgent();
        double totalPropertySales = 10000; // Dummy data for total property sales

        // Act
        double commission = estateAgent.estateAgentCommission(totalPropertySales);

        // Assert
        assertEquals(200, commission, 0.01); // Expected commission
        System.out.println("calculateTotalCommission_ReturnsCommission passed. Commission: " + commission);
    }

    @Test
    public void topAgent_ReturnsTopPosition() {
        // Arrange
        EstateAgent estateAgent = new EstateAgent();
        double[] totalSales = {5000, 3000}; // Dummy data for total sales of two estate agents

        // Act
        int topAgentPosition = estateAgent.topEstateAgent(totalSales);

        // Assert
        assertEquals(0, topAgentPosition); // Assuming the first estate agent has the highest total sales
        System.out.println("topAgent_ReturnsTopPosition passed. Top Position: " + topAgentPosition);
    }
  
}
