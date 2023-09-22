/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagelist;


import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String zipCode;
    private String phoneNumber;

    public void setData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        firstName = input.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = input.nextLine();
        System.out.print("Enter Street Address: ");
        streetAddress = input.nextLine();
        System.out.print("Enter Zip Code: ");
        zipCode = input.nextLine();
        System.out.print("Enter Phone Number: ");
        phoneNumber = input.nextLine();
    }

    public void display() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + streetAddress + ", " + zipCode);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
