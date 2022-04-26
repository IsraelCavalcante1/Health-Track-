package br.com.healthtrack.business.model.user;

import br.com.healthtrack.business.model.diet.Diet;

import java.util.ArrayList;
import java.util.Set;


public class Nutritionist extends Person {

    private String crm;
    private Set<Skill> skillSet;


     // Instanciando uma lista para armazenar os usuarios, de forma que consiga implementar o CRUD (solucao temporaria) ate poder usar algum banco de dados.

    public static ArrayList<Nutritionist> nutritionists = new ArrayList<Nutritionist>();
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Set<Skill> getSkills() {
        return skillSet;
    }

    public void setSkill(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public void addSkill(Skill skill) {
        skillSet.add(skill);
    }

    /**
     * metodo para registrar um nutricionista
     * @param nutritionist recebe um nutricionista, para ser adicionado ao banco de dados/lista
     */

    public static void registerNutritionist(Nutritionist nutritionist){
        nutritionists.add(nutritionist);
    }

    /**
     *
     * @param nutritionist recebe um nutricionista, para excluir um nutricionista
     */

    public static void removeNutritionist(Nutritionist nutritionist){
        nutritionists.remove(nutritionist);
    }

    public static void showNutritionists(){
        System.out.println("----------------------- Buscando nutricionistas Cadastrados ----------------------------");
        if (nutritionists.size() == 0){
            System.out.println("Não há nutricionistas cadastrados no momento");
        }else{
            System.out.println("Atualmente há " + nutritionists.size() + " nutricionistas cadastrados");
        }
        for (Nutritionist nutricionistaSalvo : nutritionists){
            System.out.println(nutricionistaSalvo);
        }

    }
    public void prescribeDiet(Customer customer, Diet diet){
        customer.setDiet(diet);
    }

    /**
     * Construtor completo com as informacoes de uma pessoa
     * @param id numero de identificacao unico para cada usuario, recebe um long
     * @param personName nome da pessoa que utilizara a conta, tanto de usuario, quanto de nutricionista/personal, recebe uma String
     * @param personPass senha unica de usuario, recebe uma String
     * @param photo recebe a foto de um usuario, tipo Blob
     * @param birthDate recebe a data de nascimento do usuario
     * @param email recebe o e-mail do usuario, do tipo String
     * @param gender recebe um gender sendo "MALE", "FEMALE", "OTHER" e NON_SPECIFIED, do tipo Gender
     * @param crm recebe o documento de identificacao de um Personal Trainer, do tipo String
     */

    public Nutritionist(long id, String personName, String personPass, String photo, String birthDate, String email, Gender gender, String crm) {
        super(id, personName, personPass, photo, birthDate, email, gender);
        this.crm = crm;
    }

    public Nutritionist(long id, String crm, Set<Skill> skillSet) {
        super(id);
        this.crm = crm;
    }

    @Override
    public String toString(){
        return  " Nome: " + getName() +
                "\n Data de Nascimento " + getBirthDate() +
                "\n Email: " + getEmail() +
                "\n Crm: " + getCrm() +
                "\n Skills: " + String.valueOf(skillSet);
    }
}