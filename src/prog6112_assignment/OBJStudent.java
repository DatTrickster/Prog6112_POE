/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112_assignment;

// A class to represent a student object
public class OBJStudent {
    // Private fields to store student information
    private final int id;      // Student ID
    private final String name; // Student name
    private final int age;     // Student age
    private final String email; // Student email
    private final String course; // Student course

    // Constructor to initialize a student object with provided information
    public OBJStudent(int id, String name, int age, String email, String course) {
        this.id = id;       // Set the student ID
        this.name = name;   // Set the student name
        this.age = age;     // Set the student age
        this.email = email; // Set the student email
        this.course = course; // Set the student course
    }

    // Getter method to retrieve the student ID
    public int getId() {
        return id;
    }

    // Getter method to retrieve the student name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the student age
    public int getAge() {
        return age;
    }

    // Getter method to retrieve the student email
    public String getEmail() {
        return email;
    }

    // Getter method to retrieve the student course
    public String getCourse() {
        return course;
    }
}
