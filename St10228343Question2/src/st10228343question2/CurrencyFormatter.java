/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question2;

import java.text.NumberFormat;

/**
 * A utility class for formatting currency values in South African Rand (ZAR).
 */
public class CurrencyFormatter {

    /**
     * Formats the given value as currency in South African Rand (ZAR).
     *
     * @param value The numeric value to be formatted.
     * @return A string representing the formatted currency value.
     */
    public String formatCurrency(double value) {
        // Create a NumberFormat instance for currency formatting
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        
        // Set the currency to South African Rand (ZAR)
        currencyFormat.setCurrency(NumberFormat.getCurrencyInstance().getCurrency());

        // Format the value as currency
        String formattedValue = currencyFormat.format(value);

        // Replace the currency symbol with "R" for South African Rand
        return formattedValue.replace("£", "R");
    }
}
