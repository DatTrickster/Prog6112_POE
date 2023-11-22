/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question1;

/**
 *
 * @author Extinction
 */

public class EstateAgent implements IEstateAgent {

    // Calculate total sales for an estate agent
    @Override
    public double estateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }

    // Calculate 2% commission for an estate agent
    @Override
    public double estateAgentCommission(double propertySales) {
        return 0.02 * propertySales;
    }

    // Find the top-performing estate agent
    @Override
    public int topEstateAgent(double[] totalSales) {
        int topAgent = 0;
        double maxSales = totalSales[0];

        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topAgent = i;
            }
        }

        return topAgent;
    }
}
