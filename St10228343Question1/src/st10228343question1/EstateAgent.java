/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package st10228343question1;

/**
 * Implementation of the IEstateAgent interface representing an Estate Agent.
 * This class provides methods to calculate estate agent sales, commission, and find the top-performing estate agent.
 * 
 * @author Your Name
 */
public class EstateAgent implements IEstateAgent {

    /**
     * Calculates the total sales for an estate agent based on monthly property sales.
     * 
     * @param propertySales an array containing monthly property sales
     * @return the total sales for the estate agent
     */
    @Override
    public double estateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }

    /**
     * Calculates the commission earned by an estate agent based on total property sales.
     * 
     * @param propertySales the total property sales for the estate agent
     * @return the commission earned by the estate agent
     */
    @Override
    public double estateAgentCommission(double propertySales) {
        return 0.02 * propertySales;
    }

    /**
     * Finds the top-performing estate agent based on an array of total sales for multiple agents.
     * 
     * @param totalSales an array containing total sales for multiple estate agents
     * @return the index of the top-performing estate agent
     */
    @Override
    public int topEstateAgent(double[] totalSales) {
        int topAgent = 0;
        double maxSales = totalSales[0];

        // Loop through the array to find the top-performing estate agent
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topAgent = i;
            }
        }

        return topAgent;
    }
}

/*
Code reference:
[solved] Q11 contain a twodimensional array to contain three property - software development (IPMA6212) (no date) Studocu. 
Available at: https://www.studocu.com/en-za/messages/question/4655379/q11-contain-a-two-dimensional-array-to-contain-three-property-sales-for-january-february-and (Accessed: 22 November 2023). 

Different ways to declare and initialize 2-D array in Java (2023) GeeksforGeeks. 
Available at: https://www.geeksforgeeks.org/different-ways-to-declare-and-initialize-2-d-array-in-java/ (Accessed: 22 November 2023). 

*/



