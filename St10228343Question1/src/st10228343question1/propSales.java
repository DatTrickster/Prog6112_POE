/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question1;

/**
 *
 * @author Extinction
 */
public class propSales {
    // Helper method to calculate total sales for an estate agent
    public static double getTotalSales(String[] estateAgent, int startIndex) {
        double totalSales = 0;
        for (int i = startIndex; i < estateAgent.length; i++) {
            totalSales += Double.parseDouble(estateAgent[i].substring(1).replace(",", ""));
        }
        return totalSales;
    }

    // Helper method to display total property sales for each estate agent
    public static void displayTotalPropertySales(String[][] estateAgentsSales) {
        System.out.println("\nTotal Property Sales:");
        for (String[] estateAgent : estateAgentsSales) {
            double totalSales = getTotalSales(estateAgent, 1);
            System.out.println("Total property sales for " + estateAgent[0] + " = R" + formatCurrency(totalSales));
        }
    }

    // Helper method to display total 2% commission earned by each estate agent
    public static void displaySalesCommission(String[][] estateAgentsSales) {
        System.out.println("\nSales Commission:");
        for (String[] estateAgent : estateAgentsSales) {
            double totalCommission = 0.02 * getTotalSales(estateAgent, 1);
            System.out.println("Sales Commission for " + estateAgent[0] + " = R" + formatCurrency(totalCommission));
        }
    }

    // Helper method to find the top-performing estate agent
    public static int findTopAgent(String[][] estateAgentsSales) {
        int topAgent = 0;
        double maxSales = getTotalSales(estateAgentsSales[0], 1);

        for (int i = 1; i < estateAgentsSales.length; i++) {
            double agentSales = getTotalSales(estateAgentsSales[i], 1);
            if (agentSales > maxSales) {
                maxSales = agentSales;
                topAgent = i;
            }
        }

        return topAgent;
    }

    // Helper method to format currency
    private static String formatCurrency(double amount) {
        return String.format("%,.0f", amount);
    }
}