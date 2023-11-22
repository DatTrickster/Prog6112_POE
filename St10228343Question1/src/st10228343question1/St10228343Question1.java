/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st10228343question1;

/**
 *
 * @author Extinction
 */
public class St10228343Question1 {
public static void main(String[] args) {
        // Two-dimensional array to store property sales data for two estate agents
        String[][] estateAgentsSales = {
                {"Joe Bloggs", "800000", "1500000", "2000000"},   // Joe Bloggs
                {"Jane Doe", "700000", "1200000", "1600000"}    // Jane Doe
        };

        // Create an instance of the EstateAgent class
        EstateAgent estateAgentCalculator = new EstateAgent();

        // Display the Sales Report Header
        System.out.println("Estate Agents Sales Report");
        System.out.println("...................................................................................................................");
        System.out.printf("%-15s %-15s %-23s %-15s%n", "", "Jan", "Feb", "Mar");

        // Display the Sales Report Data
        for (String[] estateAgent : estateAgentsSales) {
            System.out.printf("%-15s ", estateAgent[0]); // Display estate agent names
            for (int j = 1; j < estateAgent.length; j++) {
                System.out.printf("R%s\t\t", estateAgent[j]);
            }
            System.out.println();
        }

        // Calculate and Display total property sales for each estate agent
        propSales.displayTotalPropertySales(estateAgentsSales);

        // Calculate and Display total 2% commission earned by each estate agent
        propSales.displaySalesCommission(estateAgentsSales);

        // Determine and Display the top-performing estate agent
        double[] totalSales = new double[estateAgentsSales.length];
        for (int i = 0; i < estateAgentsSales.length; i++) {
            totalSales[i] = estateAgentCalculator.estateAgentSales(convertStringArrayToDoubleArray(estateAgentsSales[i], 1));
        }
        int topAgent = estateAgentCalculator.topEstateAgent(totalSales);
        System.out.println("\nThe Top-Selling Estate Agent is: " + estateAgentsSales[topAgent][0]);
    }

    // Helper method to convert a portion of String array to double array
    private static double[] convertStringArrayToDoubleArray(String[] array, int startIndex) {
        double[] result = new double[array.length - startIndex];
        for (int i = startIndex; i < array.length; i++) {
            result[i - startIndex] = Double.parseDouble(array[i]);
        }
        return result;
    }

}
