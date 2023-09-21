/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog6112_assignment;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementApp {

    // A list to store student objects
    private final List<OBJStudent> students;

    // Constructor initializes the students list
    public StudentManagementApp() {
        students = new ArrayList<>();
    }

    // The main entry point of the application
    public void start() {
        while (true) {
            // Display the menu and get the user's choice as a string
            String choiceStr = JOptionPane.showInputDialog(null, getMenu(), "Student Management Application", JOptionPane.PLAIN_MESSAGE);

            if (choiceStr == null) {
                continue; // Return to the main menu on Cancel
            }

            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric choice.", "Error", JOptionPane.ERROR_MESSAGE);
                continue; // Return to the main menu on invalid input
            }

            // Process the user's choice
            switch (choice) {
                case 1 -> captureNewStudent();
                case 2 -> searchForStudent();
                case 3 -> deleteStudent();
                case 4 -> displayStudentReport();
                case 5 -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Generates the menu options as a string
    private String getMenu() {
        return "Please select an option:\n" +
                "1. Capture a New Student\n" +
                "2. Search for a Student\n" +
                "3. Delete a Student\n" +
                "4. Print Student Report\n" +
                "5. Exit Application";
    }

    // Method to capture information for a new student
    private void captureNewStudent() {
        int id;
        while (true) {
            String idStr = JOptionPane.showInputDialog(null, "Enter student ID:", "Capture a New Student", JOptionPane.PLAIN_MESSAGE);

            if (idStr == null) {
                return; // Return to the main menu on Cancel
            }

            try {
                id = Integer.parseInt(idStr);
                boolean exists = false;
                for (OBJStudent student : students) {
                    if (student.getId() == id) {
                        JOptionPane.showMessageDialog(null, "Student with ID " + id + " already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    break; // Continue to the next step
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String name;
        while (true) {
            name = JOptionPane.showInputDialog(null, "Enter student name:", "Capture a New Student", JOptionPane.PLAIN_MESSAGE);
            if (name != null && !name.isEmpty()) {
                break;
            }
        }

        int age;
        while (true) {
            String ageStr = JOptionPane.showInputDialog(null, "Enter student age:", "Capture a New Student", JOptionPane.PLAIN_MESSAGE);

            if (ageStr == null) {
                return; // Return to the main menu on Cancel
            }

            try {
                age = Integer.parseInt(ageStr);
                if (age >= 16) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid age. Age must be 16 or older.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric age.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String email;
        while (true) {
            email = JOptionPane.showInputDialog(null, "Enter student email:", "Capture a New Student", JOptionPane.PLAIN_MESSAGE);
            if (email != null && !email.isEmpty()) {
                break;
            }
        }

        String course;
        while (true) {
            course = JOptionPane.showInputDialog(null, "Enter student course:", "Capture a New Student", JOptionPane.PLAIN_MESSAGE);
            if (course != null && !course.isEmpty()) {
                break;
            }
        }

        // Create a new student object and add it to the list
        students.add(new OBJStudent(id, name, age, email, course));
        JOptionPane.showMessageDialog(null, "Student details have been successfully saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to search for a student by ID
    private void searchForStudent() {
        int id;
        while (true) {
            String idStr = JOptionPane.showInputDialog(null, "Enter student ID to search:", "Search for a Student", JOptionPane.PLAIN_MESSAGE);

            if (idStr == null) {
                return; // Return to the main menu on Cancel
            }

            try {
                id = Integer.parseInt(idStr);
                boolean found = false;

                for (OBJStudent student : students) {
                    if (student.getId() == id) {
                        displayStudent(student);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Student with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    break; // Continue to the next step
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to delete a student by ID
    private void deleteStudent() {
        int id;
        while (true) {
            String idStr = JOptionPane.showInputDialog(null, "Enter student ID to delete:", "Delete a Student", JOptionPane.PLAIN_MESSAGE);

            if (idStr == null) {
                return; // Return to the main menu on Cancel
            }

            try {
                id = Integer.parseInt(idStr);
                boolean found = false;

                for (OBJStudent student : students) {
                    if (student.getId() == id) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete student " + id + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            students.remove(student);
                            JOptionPane.showMessageDialog(null, "Student with student ID " + id + " was deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Student with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    break; // Continue to the next step
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to display details of a student
    private void displayStudent(OBJStudent student) {
        String studentDetails = "Student ID: " + student.getId() + "\n" +
                "Student Name: " + student.getName() + "\n" +
                "Student Age: " + student.getAge() + "\n" +
                "Student Email: " + student.getEmail() + "\n" +
                "Student Course: " + student.getCourse();

        JOptionPane.showMessageDialog(null, studentDetails, "Student Details", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to display a report of all students
    private void displayStudentReport() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No student records found. Capture a student first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder report = new StringBuilder("STUDENT REPORT\n\n");

        int count = 1;
        for (OBJStudent student : students) {
            report.append("STUDENT ").append(count).append("\n");
            report.append("--------------------------------------\n");
            report.append("Student ID: ").append(student.getId()).append("\n");
            report.append("Student Name: ").append(student.getName()).append("\n");
            report.append("Student Age: ").append(student.getAge()).append("\n");
            report.append("Student Email: ").append(student.getEmail()).append("\n");
            report.append("Student Course: ").append(student.getCourse()).append("\n");
            report.append("--------------------------------------\n\n");
            count++;
        }

        // Print the report to the console (optional)
        System.out.println(report.toString());

        JOptionPane.showMessageDialog(null, report.toString(), "Student Report", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagementApp app = new StudentManagementApp();
            app.start();
        });
    }
}
