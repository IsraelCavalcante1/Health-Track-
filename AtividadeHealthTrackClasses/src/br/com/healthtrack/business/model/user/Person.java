package br.com.healthtrack.business.model.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Classe que abstrai uma Pessoa, ela e abstract, portanto, nao podera ser instanciada, apenas servindo de generalizacao para as outras tres classes: usuario, instrutor e nutricionista
 * @author Israel Cavalcante, Gustavo Lima, Rafaela Nascimento, Luiz Bastos, Jessica Viana
 * @version 1.0<h3> </h3>*/

public abstract class Person {
    private final long id;
    private String name;
    private String password;
    private String photo;
    private Date birthDate;
    private String email;
    private Gender gender;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String namePerson) {
        this.name = namePerson;
    }

    public void setPassword(String passPerson) {
        this.password = passPerson;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Construtor completo com as informacoes de uma pessoa
     * @param idPerson  numero de identificacao unico para cada usuario, recebe um long
     * @param namePerson nome da pessoa que utilizara a conta, tanto de usuario, quanto de nutricionista/personal, recebe uma String
     * @param passPerson senha unica de usuario, recebe uma String
     * @param photo recebe a photo de um usuario, tipo Blob
     * @param birthDate recebe a data de nascimento do usuario
     * @param email recebe o e-mail do usuario, do tipo String
     * @param gender recebe um gender sendo "MALE", "FEMALE", "OTHER" ou "NON_SPECIFIED" do tipo Gender
     */

    public Person(long idPerson, String namePerson, String passPerson, String photo, float height, String birthDate, String email, Gender gender) {
        this.id = idPerson;
        this.name = namePerson;
        this.password = passPerson;
        this.photo = photo;
        try {
            this.birthDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.email = email;
        this.gender = gender;
    }


     // Construtor para o Personal/Instrutor e Nutricionista, com menos parametros que o do Customer/Consumidor


    public Person(long id){
        this.id = id;
    }

    public Person(long idPerson, String namePerson, String passPerson, String photo, String birthDate, String email, Gender gender) {
        this.id = idPerson;
        this.name = namePerson;
        this.password = passPerson;
        try {
            this.birthDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.photo = photo;
        this.email = email;
        this.gender = gender;
    }
}