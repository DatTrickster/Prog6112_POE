public class ProcessRecipes extends Recipes {
    public ProcessRecipes(String ingredients, int timeToMake, String difficultyLevel) {
        super(ingredients, timeToMake, difficultyLevel);
    }


    @Override
    public void printRecipes() {
        System.out.println("Recipe Details:");
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Time to Make: " + timeToMake + " minutes");
        System.out.println("Difficulty Level: " + difficultyLevel);
        
    }
}