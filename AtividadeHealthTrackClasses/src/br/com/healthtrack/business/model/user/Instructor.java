package br.com.healthtrack.business.model.user;

import java.util.ArrayList;

public class Instructor extends Person {
    private String cref;
    private ArrayList<Skill> skill;


     // Instanciando uma lista para armazenar os usuarios, de forma que consiga implementar o CRUD (solucao temporaria) ate poder usar algum banco de dados.

    public static ArrayList<Instructor> instructors = new ArrayList<>();

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public ArrayList<Skill> getSkill() {
        return skill;
    }

    public void setSkill(ArrayList<Skill> skill) {
        this.skill = skill;
    }

    /**
     * metodo para registrar um instrutor
     * @param instructor recebe um instrutor, para ser adicionado ao banco de dados/lista
     */

    public static void registerInstructor(Instructor instructor){
        instructors.add(instructor);
    }

    /**
     *
     * @param instructor recebe um instrutor, para excluir um instrutor
     */

    public static void removeInstructor(Instructor instructor){
        instructors.remove(instructor);
    }



    public static void showInstructors(){
        System.out.println("----------------------- Buscando Instrutores Cadastrados ----------------------------");
        if (instructors.size() == 0){
            System.out.println("Não há instrutores cadastrados no momento");
        }else{
            System.out.println("Atualmente há " + instructors.size() + " instrutores cadastrados");
        }
        for (Instructor personalSalvo : instructors){
            System.out.println(personalSalvo);
        }
    }

    /**
     * Construtor completo com as informacoes de uma pessoa
     * @param personId  numero de identificacao unico para cada usuario, recebe um long
     * @param personName nome da pessoa que utilizara a conta, tanto de usuario, quanto de nutricionista/instrutor, recebe uma String
     * @param personPass senha unica de usuario, recebe uma String
     * @param photo recebe a foto de um usuario, tipo Blob
     * @param birthDate recebe a data de nascimento do usuario
     * @param email recebe o e-mail do usuario, do tipo String
     * @param gender recebe um gender sendo "MALE", "FEMALE", "OTHER" e NON_SPECIFIED, do tipo Gender
     * @param cref recebe o documento de identificacao de um instrutor, do tipo String
     */
    public Instructor(long personId, String personName, String personPass, String photo, String birthDate, String email, Gender gender, String cref) {
        super(personId, personName, personPass, photo, birthDate, email, gender);
        this.cref = cref;
    }

    @Override
    public String toString(){
        return  " Nome: " + getName() +
                "\n Data de Nascimento " + getBirthDate() +
                "\n Email: " + getEmail() +
                "\n Cref: " + getCref() +
                "\n Skills: " + String.valueOf(skill);
    }
}
