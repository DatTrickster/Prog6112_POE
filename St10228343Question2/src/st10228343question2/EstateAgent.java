/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question2;

public class EstateAgent implements IEstateAgent {
    @Override
    public double calculateCommission(double propertyPrice, double commissionPercentage) {
        return propertyPrice * (commissionPercentage / 100);
    }

    @Override
    public String validateData(String agentName, double propertyPrice, double commissionPercentage) {
        if (agentName == null || agentName.trim().isEmpty()) {
            return "Agent Name cannot be empty.";
        }

        if (propertyPrice <= 0) {
            return "Property Price must be greater than zero.";
        }

        if (commissionPercentage <= 0 || commissionPercentage > 100) {
            return "Commission Percentage must be greater than zero and less than or equal to 100.";
        }

        return null; // No validation errors
    }

    @Override
    public String validateData(String invalidLocation, String agentName, double propertyPrice, double commissionPercentage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}