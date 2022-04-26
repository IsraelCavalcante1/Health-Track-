package br.com.healthtrack.business.model.user;

/**
 * Opcoes disponiveis para genero
 */
public enum Gender {
    MALE("Masculino"), FEMALE("Feminino"), OTHER("Outro"), NON_SPECIFIED("Não especificado");

    private String identifier;

    Gender(String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier(){
        return identifier;
    }
}
