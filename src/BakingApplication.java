import java.util.Scanner;

public class BakingApplication {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter ingredients and store it in the 'ingredients' variable
        System.out.println("Enter ingredients: ");
        String ingredients = scanner.nextLine();

        // Prompt the user to enter time to make (in minutes) and store it in the 'timeToMake' variable
        System.out.println("Enter time to make (in minutes): ");
        int timeToMake = scanner.nextInt();

        // Consume the newline character left in the input buffer
        scanner.nextLine();

        // Prompt the user to enter difficulty level and store it in the 'difficultyLevel' variable
        System.out.println("Enter difficulty level: ");
        String difficultyLevel = scanner.nextLine();

        // Create an instance of ProcessRecipes using user input
        ProcessRecipes cakeRecipe = new ProcessRecipes(ingredients, timeToMake, difficultyLevel);

        // Print the recipe details using the printRecipes method from the ProcessRecipes class
        cakeRecipe.printRecipes();

        // Close the scanner to release resources
        scanner.close();
    }
}




