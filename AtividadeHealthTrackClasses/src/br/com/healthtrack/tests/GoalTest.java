package br.com.healthtrack.tests;

import br.com.healthtrack.business.model.user.Customer;
import br.com.healthtrack.business.model.user.Goal;
import static br.com.healthtrack.business.model.user.Customer.registerCustomer;
import static br.com.healthtrack.business.model.user.Customer.showCustomers;

public class GoalTest {
    public static void main(String[] args) {
        Customer customerTest = ObjectFactory.createCustomer();
        registerCustomer(customerTest);
        Goal meta = ObjectFactory.createGoal();
        showCustomers();
    }
}