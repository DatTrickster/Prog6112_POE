/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package st10228343question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * GUI application for capturing estate agent information and generating commission reports.
 * The application includes features to process reports, clear fields, and save reports to a file.
 * Uses Swing for the graphical user interface.
 *
 * @author Extinction
 */
public class st10228343Question2 extends JFrame {
    // Components for the GUI
    private JComboBox<String> locationComboBox;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField commissionTextField;
    private JTextArea reportTextArea;
    private JLabel estateAgentReportLabel;
    private IEstateAgent estateAgent;

    /**
     * Constructs the EstateAgentCommissionApp.
     * Initializes the GUI components, sets up the layout, and makes the frame visible.
     */
    public st10228343Question2() {
        // Set up the frame
        setTitle("Estate Agent Commission App");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        String[] locations = {"Cape Town", "Durban", "Pretoria"};
        locationComboBox = new JComboBox<>(locations);
        nameTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        commissionTextField = new JTextField(20);
        reportTextArea = new JTextArea(10, 30);
        reportTextArea.setEditable(false);

        estateAgentReportLabel = new JLabel("ESTATE AGENT REPORT");
        estateAgentReportLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        fileMenu.add(exitMenuItem);

        // Create Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processReportMenuItem = new JMenuItem("Process Report");
        processReportMenuItem.addActionListener((ActionEvent e) -> {
            processReport();
        });

        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener((ActionEvent e) -> {
            clearFields();
        });

        JMenuItem saveReportMenuItem = new JMenuItem("Save Report");
        saveReportMenuItem.addActionListener((ActionEvent e) -> {
            saveReportToFile();
        });

        toolsMenu.add(processReportMenuItem);
        toolsMenu.add(clearMenuItem);
        toolsMenu.add(saveReportMenuItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        // Set up layout
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Location:"));
        inputPanel.add(locationComboBox);
        inputPanel.add(new JLabel("Agent Name:"));
        inputPanel.add(nameTextField);
        inputPanel.add(new JLabel("Property Price (ZAR):"));
        inputPanel.add(priceTextField);
        inputPanel.add(new JLabel("Commission Percentage:"));
        inputPanel.add(commissionTextField);

        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate Commission");
        calculateButton.addActionListener((ActionEvent e) -> {
            processReport();
        });
        buttonPanel.add(calculateButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(estateAgentReportLabel, BorderLayout.CENTER);
        add(new JScrollPane(reportTextArea), BorderLayout.SOUTH);

        // Set up visibility
        setLocationRelativeTo(null);
        setVisible(true);

        // Initialize the estate agent instance
        estateAgent = new EstateAgent();
    }

    /**
     * Processes the estate agent report, calculates commission, and displays the report.
     * Validates input, performs calculations, formats currency, and updates the report text area.
     */
    private void processReport() {
        // Validate data
        String agentName = nameTextField.getText();
        String location = (String) locationComboBox.getSelectedItem();  // Get selected location
        double propertyPrice;
        double commissionPercentage;

        try {
            propertyPrice = Double.parseDouble(priceTextField.getText());
            commissionPercentage = Double.parseDouble(commissionTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Property Price or Commission Percentage.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String validationMessage = estateAgent.validateData(agentName, propertyPrice, commissionPercentage);
        if (validationMessage != null) {
            JOptionPane.showMessageDialog(this, validationMessage, "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate commission
        double commission = estateAgent.calculateCommission(propertyPrice, commissionPercentage);

        // Format currency
        CurrencyFormatter currencyFormatter = new CurrencyFormatter();
        String formattedPrice = currencyFormatter.formatCurrency(propertyPrice);
        String formattedCommission = currencyFormatter.formatCurrency(commission);

        // Display report in the text area
        String report = "Location: " + location + "\n"
                + "Agent Name: " + agentName + "\n"
                + "Property Price: " + formattedPrice + "\n"
                + "Commission Percentage: " + commissionPercentage + "%\n"
                + "Commission Earned: " + formattedCommission;
        reportTextArea.setText(report);
    }

    /**
     * Clears all input fields and the report text area.
     */
    private void clearFields() {
        locationComboBox.setSelectedIndex(0);
        nameTextField.setText("");
        priceTextField.setText("");
        commissionTextField.setText("");
        reportTextArea.setText("");
    }

    /**
     * Saves the current estate agent report to a file named "report.txt".
     * Validates input, performs file writing, and displays success or error messages.
     */
    private void saveReportToFile() {
        // Validate data
        String agentName = nameTextField.getText();
        double propertyPrice;
        double commissionPercentage;

        try {
            propertyPrice = Double.parseDouble(priceTextField.getText());
            commissionPercentage = Double.parseDouble(commissionTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Property Price or Commission Percentage.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String validationMessage = estateAgent.validateData(agentName, propertyPrice, commissionPercentage);
        if (validationMessage != null) {
            JOptionPane.showMessageDialog(this, validationMessage, "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save report to file
        String report = reportTextArea.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            writer.write(report);
            JOptionPane.showMessageDialog(this, "Report saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving report", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Entry point for the application.
     * Launches the EstateAgentCommissionApp.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new st10228343Question2();
        });
    }
}

/*

Interfaces (no date) Interfaces (The JavaTM Tutorials &gt; Learning the Java Language &gt; Interfaces and Inheritance).Available at: https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html (Accessed: 22 November 2023). 

Different ways to declare and initialize 2-D array in Java (2023) GeeksforGeeks. Available at: https://www.geeksforgeeks.org/different-ways-to-declare-and-initialize-2-d-array-in-java/ (Accessed: 22 November 2023). 

Interfaces (no date) Interfaces (The JavaTM Tutorials &gt; Learning the Java Language &gt; Interfaces and Inheritance). Available at: https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html (Accessed: 22 November 2023). 

John MulaneyJohn Mulaney&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 10999 bronze badges and Mạnh Quyết NguyễnMạnh Quyết Nguyễn&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 17.8k11 gold badge2323 silver badges5151 bronze badges (1964) How to create an interface based on specific requirements, Stack Overflow. Available at: https://stackoverflow.com/questions/50543702/how-to-create-an-interface-based-on-specific-requirements (Accessed: 22 November 2023). 

[solved] Q11 contain a twodimensional array to contain three property - software development (IPMA6212) (no date) Studocu. Available at: https://www.studocu.com/en-za/messages/question/4655379/q11-contain-a-two-dimensional-array-to-contain-three-property-sales-for-january-february-and (Accessed: 22 November 2023). 

*/
