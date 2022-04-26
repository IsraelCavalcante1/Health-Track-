package br.com.healthtrack.business.model.diet;

import java.util.List;

public class Diet {
    private Long idUser;
    private List<Meal> meals;
    private String additionalInstructions;

    public Diet(Long idUser, List<Meal> meals, String additionalInstructions) {
        this.idUser = idUser;
        this.meals = meals;
        this.additionalInstructions = additionalInstructions;
    }

    public Diet(Long idUser, List<Meal> meals) {
        this.idUser = idUser;
        this.meals = meals;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public String getAdditionalInstructions() {
        return additionalInstructions;
    }

    public void setAdditionalInstructions(String additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
    }

    @Override
    public String toString() {
        return "Dieta do Usuário" +
                "idUser=" + idUser +
                ", meals=" + meals +
                ", additionalInstructions='" + additionalInstructions + '\'' +
                '}';
    }
}
