/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question1;

/**
 *
 * @author Extinction
 */

public interface IEstateAgent {
    double estateAgentSales(double[] propertySales);
    double estateAgentCommission(double propertySales);
    int topEstateAgent(double[] totalSales);
}