/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collagelist;


import java.util.Scanner;

public class CollegeList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Person[] people = new Person[14];
        int collegeEmployeeCount = 0;
        int facultyCount = 0;
        int studentCount = 0;

        System.out.println("Welcome to the CollegeList application!");

        while (true) {
            System.out.print("\nEnter the type of person's data to be entered (C for CollegeEmployee, F for Faculty, S for Student, Q to quit): ");
            char choice = input.nextLine().charAt(0);

            if (choice == 'Q' || choice == 'q') {
                break;
            }

            if ((choice == 'C' || choice == 'c') && collegeEmployeeCount < 4) {
                people[collegeEmployeeCount] = new CollegeEmployee();
                people[collegeEmployeeCount].setData();
                collegeEmployeeCount++;
            } else if ((choice == 'F' || choice == 'f') && facultyCount < 3) {
                people[collegeEmployeeCount + facultyCount] = new Faculty();
                people[collegeEmployeeCount + facultyCount].setData();
                facultyCount++;
            } else if ((choice == 'S' || choice == 's') && studentCount < 7) {
                people[collegeEmployeeCount + facultyCount + studentCount] = new Student();
                people[collegeEmployeeCount + facultyCount + studentCount].setData();
                studentCount++;
            } else {
                System.out.println("Error: You've reached the limit for entering data of this type.");
            }
        }

        System.out.println("\nCollege Employees:");
        for (int i = 0; i < collegeEmployeeCount; i++) {
            people[i].display();
            System.out.println();
        }

        System.out.println("\nFaculty:");
        for (int i = collegeEmployeeCount; i < collegeEmployeeCount + facultyCount; i++) {
            people[i].display();
            System.out.println();
        }

        System.out.println("\nStudents:");
        for (int i = collegeEmployeeCount + facultyCount; i < collegeEmployeeCount + facultyCount + studentCount; i++) {
            people[i].display();
            System.out.println();
        }

        input.close();
    }
}
