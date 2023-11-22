/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package st10228343question1;

public class St10228343Question1 {

    public static void main(String[] args) {
        // Two-dimensional array to store property sales data for two estate agents
        String[][] estateAgentsSales = {
                {"Joe Bloggs", "800000", "1500000", "2000000"},   // Joe Bloggs
                {"Jane Doe", "700000", "1200000", "1600000"}    // Jane Doe
        };

        // Create an instance of the EstateAgent class
        IEstateAgent estateAgentCalculator = new EstateAgent();

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
        displayTotalPropertySales(estateAgentsSales, estateAgentCalculator);

        // Calculate and Display total 2% commission earned by each estate agent
        displaySalesCommission(estateAgentsSales, estateAgentCalculator);

        // Determine and Display the top-performing estate agent
        displayTopPerformingAgent(estateAgentsSales, estateAgentCalculator);
    }

    private static void displayTotalPropertySales(String[][] estateAgentsSales, IEstateAgent estateAgentCalculator) {
        System.out.println("\nTotal Property Sales:");
        for (String[] estateAgent : estateAgentsSales) {
            double totalSales = estateAgentCalculator.estateAgentSales(convertStringArrayToDoubleArray(estateAgent, 1));
            System.out.println("Total property sales for " + estateAgent[0] + " = R" + formatCurrency(totalSales));
        }
    }

    private static void displaySalesCommission(String[][] estateAgentsSales, IEstateAgent estateAgentCalculator) {
        System.out.println("\nSales Commission:");
        for (String[] estateAgent : estateAgentsSales) {
            double totalCommission = estateAgentCalculator.estateAgentCommission(getTotalSales(estateAgent, 1));
            System.out.println("Sales Commission for " + estateAgent[0] + " = R" + formatCurrency(totalCommission));
        }
    }

    private static void displayTopPerformingAgent(String[][] estateAgentsSales, IEstateAgent estateAgentCalculator) {
        double[] totalSales = new double[estateAgentsSales.length];
        for (int i = 0; i < estateAgentsSales.length; i++) {
            totalSales[i] = estateAgentCalculator.estateAgentSales(convertStringArrayToDoubleArray(estateAgentsSales[i], 1));
        }
        int topAgent = estateAgentCalculator.topEstateAgent(totalSales);
        System.out.println("\nTop Performing Estate Agent : " + estateAgentsSales[topAgent][0]);
    }

    private static double[] convertStringArrayToDoubleArray(String[] array, int startIndex) {
        double[] result = new double[array.length - startIndex];
        for (int i = startIndex; i < array.length; i++) {
            result[i - startIndex] = Double.parseDouble(array[i]);
        }
        return result;
    }

    private static double getTotalSales(String[] estateAgent, int startIndex) {
        double totalSales = 0;
        for (int i = startIndex; i < estateAgent.length; i++) {
            totalSales += Double.parseDouble(estateAgent[i].substring(1).replace(",", ""));
        }
        return totalSales;
    }

    private static String formatCurrency(double amount) {
        return String.format("%,.0f", amount);
    }
}


/*
Code reference:
[solved] Q11 contain a twodimensional array to contain three property - software development (IPMA6212) (no date) Studocu. 
Available at: https://www.studocu.com/en-za/messages/question/4655379/q11-contain-a-two-dimensional-array-to-contain-three-property-sales-for-january-february-and (Accessed: 22 November 2023). 

Different ways to declare and initialize 2-D array in Java (2023) GeeksforGeeks. 
Available at: https://www.geeksforgeeks.org/different-ways-to-declare-and-initialize-2-d-array-in-java/ (Accessed: 22 November 2023). 

*/

