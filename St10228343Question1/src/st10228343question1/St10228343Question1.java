/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st10228343question1;

/**
 * Main class for the Estate Agents Sales Report application.
 * 
 * This program calculates and displays the sales report for two estate agents,
 * including total property sales, 2% commission earned, and the top-performing estate agent.
 * 
 * @author Extinction
 */
public class St10228343Question1 {
    
    /**
     * Main method where the program execution begins.
     * 
     * @param args the command line arguments
     */
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

    /**
     * Helper method to convert a portion of String array to double array.
     * 
     * @param array the input String array
     * @param startIndex the index to start conversion from
     * @return a double array containing the converted values
     */
    private static double[] convertStringArrayToDoubleArray(String[] array, int startIndex) {
        double[] result = new double[array.length - startIndex];
        for (int i = startIndex; i < array.length; i++) {
            result[i - startIndex] = Double.parseDouble(array[i]);
        }
        return result;
    }

}


/*
Code reference:
[solved] Q11 contain a twodimensional array to contain three property - software development (IPMA6212) (no date) Studocu. 
Available at: https://www.studocu.com/en-za/messages/question/4655379/q11-contain-a-two-dimensional-array-to-contain-three-property-sales-for-january-february-and (Accessed: 22 November 2023). 

Different ways to declare and initialize 2-D array in Java (2023) GeeksforGeeks. 
Available at: https://www.geeksforgeeks.org/different-ways-to-declare-and-initialize-2-d-array-in-java/ (Accessed: 22 November 2023). 

*/
