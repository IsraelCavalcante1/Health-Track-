package br.com.healthtrack.business.model.user;

import br.com.healthtrack.business.model.diet.Diet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que abstrai um customer e herda da classe Pessoa, ou seja, aquela pessoa que ira utilizar os beneficios do aplicativo Health Track
 * Essa classe e uma entidade, portanto, ira produzir instancias, diferente de Pessoa.
 * @author Israel Cavalcante, Gustavo Lima, Rafaela Nascimento, Luiz Bastos, Jessica Viana
 * @version 1.0<h3> </h3>*/

public class Customer extends Person {

    private List<Goal> goals = new ArrayList<>();
    private WeightHistory weightHistory;
    private Diet diet;
    private int height;


     // Instanciando uma lista para armazenar os customers, de forma que consiga implementar o CRUD (solucao temporaria) ate poder usar algum banco de dados.


    public static ArrayList<Customer> customers = new ArrayList<>();

    public List<Goal> getMeta( ) {
        return goals;
    }

    public void setMeta(Goal goal) {
        this.goals.add(goal);
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Diet getDiet() {
        return diet;
    }

    public List<WeightRecord> getHistoricoPeso() {
        return weightHistory.getWeightRecords();
    }

    public void addWeightRecord(Double weight){
        WeightRecord record = new WeightRecord(weight);
        weightHistory.addWeightRecord(record);
    }

    public Double getCurrentWeight() {
        return weightHistory.getCurrentWeight().getWeight();
    }

    /* Crud básico utilizando lista estática, apenas para efeito de demonstração
    (provavelmente seria feito em um banco de dados) */
    /**
     * Metodo para registrar um customer
     * @param customer que recebera o customer que foi instanciado
     * @return
     */
    public static void registerCustomer(Customer customer){
        customers.add(customer);
    }

    /**
     * Esse metodo tem como objetivo editar um customer, sem mexer no proprio, ou seja, sera editado um customer
     * e depois essas informacoes editadas serao atualizadas no objeto que realmente queremos atualizar.
     * @param customer que recebera o customer que foi instanciado somente para editar
     * @return retorna Customer que foi instanciado para edicao
     */
    public static Customer editCustomer(Customer customer){
        for (Customer customerSave : customers){
            // Ele irá buscar na lista/banco de dados customers, pelo usuário que tenha o mesmo ID do que foi instanciado
            // para editar
            if (customerSave.getId() == customer.getId()){
                // Aqui escolhi quais dados poderão ser atualizados, de acordo com a regra de negócio
                // Lembrando que aqui serão os dados que a pessoa conseguirá editar no Perfil, haverá outras telas
                // Para editar Peso, por exemplo.
                customerSave.setEmail(customer.getEmail());
                customerSave.setPhoto(customer.getPhoto());
            }
        }
        return customer;
    }


    /**
     * Metodo para excluir uma conta/pessoa do sistema
     * @param customer voce tem que passar o objeto pessoa, da classe Pessoa, para que uma pessoa seja excluida
     */

    public static void removeCustomer(Customer customer){
        customers.remove(customer);
    }
    public static void showCustomers(){
        System.out.println("----------------------- Buscando Usuários cadastrados ----------------------------");
        if (customers.size() == 0){
            System.out.println("Não há usuários cadastrados no momento");
        }else{
            System.out.println("Atualmente há " + customers.size() + " usuários cadastrados");
        }
        for (Customer customerSave : customers){
            System.out.println(customerSave);
        }
    }

    /**
     * Busca um customer por idPerson
     * @param idPerson identificador unico de um usuario
     * @return um Person
     */


    public static Person searchCustomerById(long idPerson) {
        Customer customerReturn = null;
        for (Customer customerSave : customers) {
            if (customerSave.getId() == idPerson) {
                customerReturn = customerSave;
                System.out.println("-------------------Buscando Usuário por ID--------------------------");
                System.out.println("Usuário encontrado: ");
                System.out.println(customerSave);
            }else{
                System.out.println("-------------------Buscando Usuário por ID--------------------------");
                System.out.println("Usuário não encontrado");
            }
        }
        return customerReturn;
    }

    /**
     * Sobrescrevendo o metodo toString, para que ele exiba as informacoes Nome, Email e Metas, caso contrario, exibiria apenas o hascode onde esta alocado na memoria
     * @return
     */

    public Customer(long id){
        super(id);
    }

    /**
     * Construtor com as informacoes necessarias para criar um customer
     * @param idPerson e o numero de identificacao unico para cada customer, recebe um long
     * @param namePerson nome da pessoa que utilizara a conta, tanto de customer, quanto de nutricionista/personal, recebe uma String
     * @param passPerson senha unica de customer, recebe uma String
     * @param photo recebe a photo de um customer, tipo Blob
     * @param weight recebe o weight de um customer, tipo float
     * @param height recebe a height de um usuario, tipo float
     * @param birthDate recebe a data de nascimento do usuario
     * @param email recebe o e-mail do customer, do tipo String
     * @param gender recebe um gender sendo "MALE", "FEMALE", "OTHER" e NON_SPECIFIED, do tipo Gender
     */

    public Customer(long idPerson, String namePerson, String passPerson, String photo, WeightRecord weight,
                    float height, String birthDate, String email, Gender gender){
        super(idPerson, namePerson, passPerson, photo, height, birthDate, email, gender);
        this.weightHistory = new WeightHistory(weight);
    }

    @Override
    public String toString() {
        return  " Nome: " + getName() +
                "\n Data de Nascimento " + getBirthDate() +
                "\n Email: " + getEmail() +
                "\n Peso: " + getCurrentWeight() +
                "\n Dieta atual: " + getDiet() +
                "\n Metas: " + String.valueOf(goals);
    }
}

