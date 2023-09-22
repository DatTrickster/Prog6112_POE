/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dentist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DentistAppointmentApp extends JFrame {
    private JTextField customerNameField;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> timeComboBox;
    private JButton submitButton;
    private DefaultListModel<String> listModel;
    private JList<String> appointmentList;

    public DentistAppointmentApp() {
        setTitle("Dentist Appointment Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10)); // Adjust spacing

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10)); // Adjust spacing

        JLabel nameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField();

        JLabel dayLabel = new JLabel("Appointment Day:");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        dayComboBox = new JComboBox<>(days);

        JLabel timeLabel = new JLabel("Appointment Time:");
        String[] times = {"8:00 AM", "10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"};
        timeComboBox = new JComboBox<>(times);

        submitButton = new JButton("Submit");

        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameField.getText();
                String selectedDay = (String) dayComboBox.getSelectedItem();
                String selectedTime = (String) timeComboBox.getSelectedItem();

                // Save the appointment details to a file (dentist.txt)
                try (FileWriter writer = new FileWriter("dentist.txt", true)) {
                    writer.write(customerName + ", " + selectedDay + ", " + selectedTime + "\n");
                    writer.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Update the list with appointment details
                listModel.addElement(customerName + ", " + selectedDay + ", " + selectedTime);
                customerNameField.setText(""); // Clear the text field
            }
        });

        formPanel.add(nameLabel);
        formPanel.add(customerNameField);
        formPanel.add(dayLabel);
        formPanel.add(dayComboBox);
        formPanel.add(timeLabel);
        formPanel.add(timeComboBox);
        formPanel.add(new JLabel()); // Empty label for spacing
        formPanel.add(submitButton);

        // Add the appointment list to the form panel
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(appointmentList), BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DentistAppointmentApp app = new DentistAppointmentApp();
            app.setVisible(true);
        });
    }
}
