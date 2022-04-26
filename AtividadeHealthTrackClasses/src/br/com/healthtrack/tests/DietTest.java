package br.com.healthtrack.tests;

import br.com.healthtrack.business.model.diet.*;
import br.com.healthtrack.business.model.user.Customer;
import br.com.healthtrack.business.model.user.Gender;
import br.com.healthtrack.business.model.user.WeightRecord;


import static br.com.healthtrack.business.model.user.Customer.registerCustomer;
import static br.com.healthtrack.business.model.user.Customer.showCustomers;

public class DietTest {
    public static void main(String[] args) {
        Customer usuarioComum = new Customer(234, "Leo", "Primeira-Senha", "minhaFoto",
                new WeightRecord(85.7), 180, "08/03/2001", "leo@gmail.com", Gender.MALE );
        Diet dieta = ObjectFactory.createDiet(usuarioComum.getId());
        usuarioComum.setDiet(dieta);
        registerCustomer(usuarioComum);
        showCustomers();
    }
}
