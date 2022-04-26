package br.com.healthtrack.tests;

import br.com.healthtrack.business.model.diet.*;
import br.com.healthtrack.business.model.user.*;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    public static Diet createDiet(long idUser) {

        Ingredient ingredient1 = new Ingredient("banana",2, MeasurementUnit.UNIT);
        Ingredient ingredient2 = new Ingredient("canela",2, MeasurementUnit.GRAMS);
        Ingredient ingredient3 = new Ingredient("aveia",100, MeasurementUnit.GRAMS);

        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);

        MealOption mealOption = new MealOption(ingredients,"Amasse as bananas, a canela e a aveia.");

        List<MealOption> mealOptions = new ArrayList<>();
        mealOptions.add(mealOption);

        Meal meal = new Meal("café da manha", mealOptions);

        List<Meal> meals = new ArrayList<>();
        meals.add(meal);

        Diet dieta = new Diet(idUser, meals, "Tomar dois copos de água ao acordar e antes de dormir");
        return dieta;
    }

    public static Instructor createInstructor(){
        Instructor instrutorTeste = new Instructor(334, "Luizinho", "3232456",
                "PhotoLuizinho", "08/05/1983", "luizinho@gmail.com", Gender.MALE, "392832-235");
        return instrutorTeste;
    }

    public static Customer createCustomer(){
        Customer customerTest = new Customer(224, "Leo", "Primeira-Senha", "minhaFoto",
                new WeightRecord(85.7), 180, "08/03/2001", "leo@gmail.com", Gender.MALE );
        return customerTest;
    }

    public static Nutritionist createNutritionist(){
        Nutritionist nutritionistTest = new Nutritionist(233, "Fernandinha", "2324690",
                "PhotoFernandinha", "08/05/1973", "Fernandinha@gmail.com", Gender.OTHER, "684472-235");
        return nutritionistTest;
    }

    public static Goal createGoal(){
        Goal goalTest = new Goal(2, "Natação", 1.45f);
        goalTest.goalAdd(goalTest, 224);
        return goalTest;
    }

}
