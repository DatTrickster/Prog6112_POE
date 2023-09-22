/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagelist;


import java.util.Scanner;

public class Student extends Person {
    private String major;
    private double gpa;

    @Override
    public void setData() {
        super.setData();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Major: ");
        major = input.nextLine();
        System.out.print("Enter GPA: ");
        gpa = input.nextDouble();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
    }
}
