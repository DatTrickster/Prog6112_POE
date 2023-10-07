public abstract class Recipes implements RecipePrinter {
    protected String ingredients;
    protected int timeToMake;
    protected String difficultyLevel;

    public Recipes(String ingredients, int timeToMake, String difficultyLevel) {
        this.ingredients = ingredients;
        this.timeToMake = timeToMake;
        this.difficultyLevel = difficultyLevel;
    }

    public abstract void printRecipes();
}