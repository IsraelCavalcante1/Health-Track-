package br.com.healthtrack.business.model.diet;

import java.util.List;

public class MealOption {
    private List<Ingredient> ingredients;
    private String instructions;

    public MealOption(List<Ingredient> ingredients, String instructions) {
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public MealOption(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        ingredients.forEach((ingredient) ->
                builder.append("\n")
                        .append(ingredient.toString())

        );
       return builder.toString();
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
