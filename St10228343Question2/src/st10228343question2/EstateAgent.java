/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question2;

/**
 * Implementation of the IEstateAgent interface providing methods for calculating commission
 * and validating estate agent data.
 */
public class EstateAgent implements IEstateAgent {

    /**
     * Calculates the commission based on the given property price and commission percentage.
     *
     * @param propertyPrice         The price of the property.
     * @param commissionPercentage  The commission percentage.
     * @return                      The calculated commission.
     */
    @Override
    public double calculateCommission(double propertyPrice, double commissionPercentage) {
        return propertyPrice * (commissionPercentage / 100);
    }

    /**
     * Validates estate agent data, checking for empty agent name, non-positive property price,
     * and invalid commission percentage.
     *
     * @param agentName             The name of the estate agent.
     * @param propertyPrice         The price of the property.
     * @param commissionPercentage  The commission percentage.
     * @return                      A validation error message or null if no errors.
     */
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

    /**
     * Placeholder method for validating estate agent data with location (unused).
     * Throws UnsupportedOperationException.
     *
     * @param invalidLocation       Placeholder for location validation (unused).
     * @param agentName             The name of the estate agent.
     * @param propertyPrice         The price of the property.
     * @param commissionPercentage  The commission percentage.
     * @return                      Validation error message (unsupported).
     */
    @Override
    public String validateData(String invalidLocation, String agentName, double propertyPrice, double commissionPercentage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
