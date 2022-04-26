package br.com.healthtrack.tests;
import br.com.healthtrack.business.model.user.Customer;
import static br.com.healthtrack.business.model.user.Customer.*;

public class CustomerTest {
    public static void main(String[] args) {
        // Primeira instância de um usuário comum, que apenas irá utilizar os benefícios do aplicativo.
        Customer usuarioComum = ObjectFactory.createCustomer();

        // Salvando o usuário na lista estática que simula um banco de dados
        registerCustomer(usuarioComum);

        // Exibindo o usuário após ser instanciado e registrado no banco de dados"
        showCustomers();

        // Instanciando o objeto que só servirá para editar o usuarioComum
        Customer usuarioEditar = new Customer(224);

        // Escolhendo os novos atributos a serem editados
        usuarioEditar.setEmail("leopontorua@gmail.com");
        usuarioEditar.setPassword("Nova-Senha");
        usuarioEditar.setPhoto("Nova-Foto");

        /*
        Aqui chamo a função, através do usuarioComum passando o usuarioEditar que foi instanciando apenas para essa edição
        Optei por essa lógica, por conta de que não estava descrito se poderia utilizar Banco de Dados na atividade
        E por estar utilizando uma lista estática, para simular um banco de dados, esse é o único método para fazer a edição
        sem mexer diretamente no usuário que está na lista estática, visto que utilizar set diretamente no usuário é errado.
         */
        editCustomer(usuarioEditar);

        // Aqui já irá retornar o usuário com os novos dados
        showCustomers();

        // Testando o método buscar por ID
        searchCustomerById(224);

        // Testando o método de remover Usuario
        removeCustomer(usuarioComum);
        showCustomers();
    }
}