/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10228343question2;

import java.text.NumberFormat;

public class CurrencyFormatter {
    public String formatCurrency(double value) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setCurrency(NumberFormat.getCurrencyInstance().getCurrency());  // Set currency to ZAR
        String formattedValue = currencyFormat.format(value);
        return formattedValue.replace("£", "R");  // Remove currency symbol
    }
}