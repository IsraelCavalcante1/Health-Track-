package br.com.healthtrack.tests;

import br.com.healthtrack.business.model.diet.Diet;
import br.com.healthtrack.business.model.user.Customer;
import br.com.healthtrack.business.model.user.Nutritionist;
import static br.com.healthtrack.business.model.user.Customer.registerCustomer;
import static br.com.healthtrack.business.model.user.Nutritionist.registerNutritionist;
import static br.com.healthtrack.business.model.user.Nutritionist.showNutritionists;


public class NutritionistTest {
    public static void main(String[] args) {
        // Instanciando um customer
        Customer usuarioComum = ObjectFactory.createCustomer();

        // Instanciando um Nutritionist
        Nutritionist nutricionistaTest = ObjectFactory.createNutritionist();

        // Registrando o customer no banco de dados/lista estatica
        registerCustomer(usuarioComum);
        // Instanciando uma dieta e passando o ID do usuario
        Diet diet = ObjectFactory.createDiet(usuarioComum.getId());
        // Registrando o nutricionista no banco de dados/lista estatica
        registerNutritionist(nutricionistaTest);

        System.out.println("antes da dieta");
        // Exibindo o customer antes da dieta
        Customer.showCustomers();
        // Preescrevendo uma dieta para um usuario, passando o Usuario completo e a dieta
        nutricionistaTest.prescribeDiet(usuarioComum,diet);
        System.out.println("Depois da dieta");
        // Exibindo a lista de usuarios depois da preescrição da dieta
        Customer.showCustomers();

        showNutritionists();
    }

}
