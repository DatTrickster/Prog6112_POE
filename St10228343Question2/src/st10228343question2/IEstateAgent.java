/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question2;

/**
 * Interface defining methods for calculating commission and validating estate agent data.
 */
public interface IEstateAgent {

    /**
     * Calculates the commission based on the given property price and commission percentage.
     *
     * @param propertyPrice         The price of the property.
     * @param commissionPercentage  The commission percentage.
     * @return                      The calculated commission.
     */
    double calculateCommission(double propertyPrice, double commissionPercentage);

    /**
     * Validates estate agent data, checking for empty agent name, non-positive property price,
     * and invalid commission percentage.
     *
     * @param agentName             The name of the estate agent.
     * @param propertyPrice         The price of the property.
     * @param commissionPercentage  The commission percentage.
     * @return                      A validation error message or null if no errors.
     */
    String validateData(String agentName, double propertyPrice, double commissionPercentage);

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
    String validateData(String invalidLocation, String agentName, double propertyPrice, double commissionPercentage);
}
