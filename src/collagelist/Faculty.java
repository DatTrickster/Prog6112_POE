/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagelist;



import java.util.Scanner;

public class Faculty extends CollegeEmployee {
    private boolean isTenured;

    @Override
    public void setData() {
        super.setData();
        Scanner input = new Scanner(System.in);
        System.out.print("Is Faculty Tenured? (true/false): ");
        isTenured = input.nextBoolean();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Tenured: " + isTenured);
    }
}
