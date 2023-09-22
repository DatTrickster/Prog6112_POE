/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagelist;

import java.util.Scanner;

public class CollegeEmployee extends Person {
    private String socialSecurityNumber;
    private double annualSalary;
    private String departmentName;

    @Override
    public void setData() {
        super.setData();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Social Security Number: ");
        socialSecurityNumber = input.nextLine();
        System.out.print("Enter Annual Salary: ");
        annualSalary = input.nextDouble();
        input.nextLine(); // Consume the newline character
        System.out.print("Enter Department Name: ");
        departmentName = input.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("SSN: " + socialSecurityNumber);
        System.out.println("Annual Salary: " + annualSalary);
        System.out.println("Department: " + departmentName);
    }
}
