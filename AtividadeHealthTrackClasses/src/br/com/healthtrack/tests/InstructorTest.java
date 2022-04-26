package br.com.healthtrack.tests;

import br.com.healthtrack.business.model.user.Instructor;

import static br.com.healthtrack.business.model.user.Instructor.registerInstructor;
import static br.com.healthtrack.business.model.user.Instructor.showInstructors;

public class InstructorTest {
    public static void main(String[] args) {
        Instructor instrutorTeste = ObjectFactory.createInstructor();
        registerInstructor(instrutorTeste);
        showInstructors();
    }
}
