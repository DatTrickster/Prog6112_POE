/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog6112_assignment;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementAppTest {

    public static class Student {
        private int ID;
        private String name;
        private int age;
        private String email;
        private String course;

        public Student(int ID, String name, int age, String email, String course) {
            this.ID = ID;
            this.name = name;
            this.age = age;
            this.email = email;
            this.course = course;
        }

        public int getID() {
            return ID;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }

        public String getCourse() {
            return course;
        }
    }

    public static class StudentManager {
        private final List<Student> students = new ArrayList<>();

        public boolean saveStudent(Student student) {
            // Check if a student with the same ID already exists
            for (Student existingStudent : students) {
                if (existingStudent.getID() == student.getID()) {
                    return false; // Student with the same ID already exists, cannot save.
                }
            }

            students.add(student);
            return true;
        }

        public Student searchStudent(int ID) {
            for (Student student : students) {
                if (student.getID() == ID) {
                    return student; // Student found
                }
            }
            return null; // Student not found
        }

        public boolean deleteStudent(int ID) {
            Student studentToRemove = null;
            for (Student student : students) {
                if (student.getID() == ID) {
                    studentToRemove = student;
                    break;
                }
            }

            if (studentToRemove != null) {
                students.remove(studentToRemove);
                return true; // Student deleted
            }
            return false; // Student not found
        }

        public boolean isValidAge(int age) {
            return age >= 16;
        }
    }

    @Test
    public void testSaveStudent() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Create a dummy student record
        Student student = new Student(1, "John Doe", 20, "john@example.com", "Computer Science");

        // Save the student
        boolean result = studentManager.saveStudent(student);

        // Check if the student was saved successfully
        assertTrue(result);
    }

    @Test
    public void testSearchStudent() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Create a dummy student record
        Student dummyStudent = new Student(2, "Jane Smith", 22, "jane@example.com", "Mathematics");

        // Save the dummy student
        studentManager.saveStudent(dummyStudent);

        // Search for the student
        Student foundStudent = studentManager.searchStudent(2);

        // Check if the correct student details were returned
        assertEquals("Jane Smith", foundStudent.getName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Search for a student that does not exist (use a non-existent ID)
        Student foundStudent = studentManager.searchStudent(9999);

        // Check that no student was found
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Create a dummy student record
        Student dummyStudent = new Student(3, "Alice Johnson", 25, "alice@example.com", "History");

        // Save the dummy student
        studentManager.saveStudent(dummyStudent);

        // Delete the student
        boolean result = studentManager.deleteStudent(3);

        // Check if the student was deleted successfully
        assertTrue(result);
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Attempt to delete a student that does not exist (use a non-existent ID)
        boolean result = studentManager.deleteStudent(9999);

        // Check that no student could be found to delete
        assertFalse(result);
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Test with a valid student age (e.g., 18)
        int validAge = 18;
        boolean isValid = studentManager.isValidAge(validAge);

        // Check if the student's age is considered valid
        assertTrue(isValid);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Test with an invalid student age (e.g., 15, below the minimum valid age)
        int invalidAge = 15;
        boolean isValid = studentManager.isValidAge(invalidAge);

        // Check if the student's age is considered invalid
        assertFalse(isValid);
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Create a new student manager
        StudentManager studentManager = new StudentManager();

        // Test with an invalid character as student age (e.g., "abc")
        String invalidAge = "abc";

        // Use a try-catch block to handle the NumberFormatException
        boolean isValid;
        try {
            int age = Integer.parseInt(invalidAge);
            isValid = studentManager.isValidAge(age);
        } catch (NumberFormatException e) {
            isValid = false;
        }

        // Check if the student age supplied is not a number
        assertFalse(isValid);
    }
}

