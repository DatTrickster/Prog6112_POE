/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package st10228343question1;

/**
 * Interface for Estate Agents.
 * This interface defines methods for calculating estate agent sales, commission, and finding the top-performing estate agent.
 * Each method represents a specific functionality related to estate agent performance metrics.
 * 
 * @author Your Name
 */
public interface IEstateAgent {

    /**
     * Calculates the total sales for an estate agent based on monthly property sales.
     * 
     * @param propertySales an array containing monthly property sales
     * @return the total sales for the estate agent
     */
    double estateAgentSales(double[] propertySales);

    /**
     * Calculates the commission earned by an estate agent based on total property sales.
     * 
     * @param propertySales the total property sales for the estate agent
     * @return the commission earned by the estate agent
     */
    double estateAgentCommission(double propertySales);

    /**
     * Finds the top-performing estate agent based on an array of total sales for multiple agents.
     * 
     * @param totalSales an array containing total sales for multiple estate agents
     * @return the index of the top-performing estate agent
     */
    int topEstateAgent(double[] totalSales);
}
