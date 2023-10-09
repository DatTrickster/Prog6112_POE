/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package question1;

/**
 *
 * @author Extinction
 */
/*
                        Question 1

                        Write a Java application to display the price difference between two types of camera
                        technologies, DSLR and Mirrorless. Display the camera manufacturer and the cost of a DSLR versus
                        a Mirrorless camera. The table below represents the camera cost comparisons:

                                    MIRRORLESS   DSLR
                        CANON       R 10 500     R 8 500
                        SONY        R 9 500      R 7 200
                        NIKON       R 12 000     R 8 000

                        Using single and two-dimensional arrays, produce the camera technology report and include the
                        total calculated difference for each camera manufacturer. If the difference between the
                        Mirrorless camera and DSLR is greater than or equal to R2 500, then display three stars ***.
                        In your solution, include the camera manufacturer with the greatest cost difference.


*/

public class Question1 {

    public static void main(String[] args) {

        // Camera Product and their prices for Mirrorless and DSLR cameras
        String[] Product = {"CANON", "SONY", "NIKON"};
        double[][] prices = {{10500.00, 8500.00}, {9500.00, 7200.00}, {12000.00, 8000.00}};

        // Display the camera technology report
        System.out.println("CAMERA TECHNOLOGY REPORT");
        System.out.println("-------------------------------------------");
        System.out.printf("%-13s%-15s%-15s%n", "","Mirrorless", "  DSLR");
// spacing controls
        // Iterate through each manufacturer and their prices
        for (int i = 0; i < Product.length; i++) {
            System.out.printf("%-13sR %,13.2f  R %,13.2f%n", Product[i], prices[i][0], prices[i][1]);
        }
// format controls



         System.out.println("-------------------------------------------");

         // Calculate and display the camera technology results
             System.out.println("CAMERA TECHNOLOGY RESULTS");
         System.out.println("-------------------------------------------");

         double maxDifference = 0.0;
              String MaxDifResult = "";

         // Iterate through each manufacturer to calculate and print the cost difference
                        for (int i = 0; i < Product.length; i++) {
                            String manufacturer = Product[i];
                            double difference = prices[i][0] - prices[i][1];
                            System.out.printf("%-15sR %.2f", manufacturer, difference);

                            // Check if the current difference is greater than or equal to R2,500 and add stars
                            if (difference >= 2500) {
                                System.out.print("   ***");
                            }

                            System.out.println(); // Move to the next line

                            // Check if the current difference is greater than the maximum difference found so far
                            if (difference > maxDifference) {
                                maxDifference = difference;
                                MaxDifResult = manufacturer;
                            }
         }

         // Display the manufacturer with the most cost difference in the bottom section
         System.out.println("-------------------------------------------");
         System.out.println("CAMERA WITH THE MOST COST DIFFERENCE : " + MaxDifResult);
         System.out.println("-------------------------------------------");
     }     
}


/* code reference 
https://www.geeksforgeeks.org/java-string-format-method-with-examples/
https://www.w3resource.com/java-exercises/datatypes/java-datatype-exercise-9.php
https://www.geeksforgeeks.org/find-n-integers-given-difference-product-sum/
https://www.geeksforgeeks.org/java-program-to-find-2-elements-in-the-array-such-that-difference-between-them-is-largest/
*/
