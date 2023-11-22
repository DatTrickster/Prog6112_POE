/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question2;


public interface IEstateAgent {
    double calculateCommission(double propertyPrice, double commissionPercentage);

    String validateData(String agentName, double propertyPrice, double commissionPercentage);

    public String validateData(String invalidLocation, String agentName, double propertyPrice, double commissionPercentage);
}