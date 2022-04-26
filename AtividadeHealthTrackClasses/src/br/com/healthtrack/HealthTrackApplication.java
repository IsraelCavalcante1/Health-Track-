package br.com.healthtrack;
import br.com.healthtrack.business.model.diet.Diet;
import br.com.healthtrack.business.model.user.*;
import br.com.healthtrack.tests.ObjectFactory;

import static br.com.healthtrack.business.model.user.Customer.searchCustomerById;
import static br.com.healthtrack.business.model.user.Customer.*;
import static br.com.healthtrack.business.model.user.Instructor.*;
import static br.com.healthtrack.business.model.user.Nutritionist.registerNutritionist;
import static br.com.healthtrack.business.model.user.Nutritionist.showNutritionists;

public class HealthTrackApplication {

    public static void main(String[] args) {

        // Os valores dessa instancia ja estao no ObjectFactory, para otimizacao de codigo.
        Customer customerTest = ObjectFactory.createCustomer();

        // Registrando o customer no banco de dados/lista estatica
        registerCustomer(customerTest);

        // Instanciando o objeto que so servira para editar o usuarioComum
        Customer customerEdit = new Customer(224);

        // Escolhendo os novos atributos a serem editados
        customerEdit.setEmail("leopontorua@gmail.com");
        customerEdit.setPassword("Nova-Senha");
        customerEdit.setPhoto("Nova-Foto");

        /*
        Aqui chamamos a funcao atraves do usuarioComum passando o customerEdit que foi instanciado apenas para essa edicao
        Optamos por essa logica, visto que nao estava descrito se poderia utilizar Banco de Dados na atividade
         estamos utilizando uma lista estatica, para simular um banco de dados, esse e o unico metodo para fazer a edicao
        sem mexer diretamente no usuario que esta na lista estatica, visto que utilizar set diretamente no usuario e errado.
         */
        editCustomer(customerEdit);

        /*
         Atribui uma meta ao customer, esse metodo ja esta preenchido com os atributos corretos em ObjectFactory para
         otimizacao do codigo
         */
        Goal goal = ObjectFactory.createGoal();

        // Exibe todos os customers que estao cadastrados no banco de dados
        showCustomers();

        // Removo o customer do banco de dados
        removeCustomer(customerTest);

        // Exibe o banco de dados sem nenhum customer registrado
        showCustomers();

        // --------------------------- FIM TESTES NO CUSTOMER E SEUS METODOS ----------------------------

        // Os valores dessa instancia ja estao no ObjectFactory, para otimizacao de codigo.
        Instructor instrutorTeste = ObjectFactory.createInstructor();

        // Registrando o Instructor no banco de dados/lista estatica
        registerInstructor(instrutorTeste);

        // Exibe todos os instructors que estao cadastrados no banco de dados
        showInstructors();

        // Remove um Instructor do banco de dados
        removeInstructor(instrutorTeste);

        // Exibe o banco de dados sem nenhum Instructor registrado
        showInstructors();

        // --------------------------- FIM TESTES NO INSTRUCTOR E SEUS METODOS ----------------------------

        /*
         Instanciando um customer para o Nutritionist preescrever uma dieta. Seus parametros foram passados na classe
         ObjectFactory para otimizacao do codigo.
         */
        Customer usuarioComum = ObjectFactory.createCustomer();

        /*
         Instanciando um Nutritionist. Seus parametros foram passados na classe ObjectFactory para otimizacao do codigo.
         */
        Nutritionist nutritionistTest = ObjectFactory.createNutritionist();

        // Registrando o customer no banco de dados/lista estatica
        registerCustomer(usuarioComum);

        // Instanciando uma dieta e passando o ID do usuario
        Diet diet = ObjectFactory.createDiet(usuarioComum.getId());

        // Registrando o nutricionista no banco de dados/lista estatica
        registerNutritionist(nutritionistTest);

        // Exibindo o customer antes da dieta
        System.out.println("antes da dieta");
        Customer.showCustomers();

        // Preescrevendo uma dieta para um usuario, passando o Usuario completo e a dieta
        nutritionistTest.prescribeDiet(usuarioComum,diet);

        // Exibindo a lista de usuarios depois da preescrição da dieta
        System.out.println("Depois da dieta");
        Customer.showCustomers();

        showNutritionists();
    }
}
