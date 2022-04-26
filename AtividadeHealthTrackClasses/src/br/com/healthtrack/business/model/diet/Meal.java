package br.com.healthtrack.business.model.diet;

import java.util.List;

public class Meal {
    private String name;
    private List<MealOption> mealOptions;

    public Meal(String name, List<MealOption> mealOptions) {
        this.name = name;
        this.mealOptions = mealOptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MealOption> getMealOptions() {
        return mealOptions;
    }

    public void setMealOptions(List<MealOption> mealOptions) {
        this.mealOptions = mealOptions;
    }

    @Override
    public String toString() {
        return "Nome da Refeição " + name;

    }
}

