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
public void topAgent_ReturnsTopName() {
    // Arrange
    String[][] estateAgentData = {
        {"johnney", "5000"},
        {"Bobby", "3000"},
        {"Alice", "7000"} // Added actual data for a third agent
    };

    // Act
    double highestTotalSales = 0;
    String topAgentName = null;

        for (String[] estateAgentData1 : estateAgentData) {
            double totalSales = Double.parseDouble(estateAgentData1[1]);
            if (totalSales > highestTotalSales) {
                highestTotalSales = totalSales;
                topAgentName = estateAgentData1[0];
            }
        }

    // Assert
    assertNotNull(topAgentName);
    assertEquals("Alice", topAgentName); // Assuming Alice has the highest total sales
    System.out.println("topAgent_ReturnsTopName passed. Top Agent: " + topAgentName);

    // Print out the agent and amount in the top position
    if (topAgentName != null) {
        double topAgentAmount = Double.parseDouble(estateAgentData[2][1]); // Assuming the third agent has the highest total sales
        System.out.println("Agent in Top Position: " + topAgentName + ", Amount: " + topAgentAmount);
    }
}


}
