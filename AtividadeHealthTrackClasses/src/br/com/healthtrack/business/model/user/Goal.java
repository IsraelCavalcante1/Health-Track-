package br.com.healthtrack.business.model.user;

import static br.com.healthtrack.business.model.user.Customer.customers;

/**
 * Goal cria uma meta para o customer com os parametros idGoal, goalType e goalTimer
 */
public class Goal {

    private long idGoal;
    private String goalType;
    private float goalTimer;

    public long getGoalId() {
        return idGoal;
    }

    public void setGoalId(long idGoal) {
        this.idGoal = idGoal;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public float getGoalTimer() {
        return goalTimer;
    }

    public void setGoalTimer(float goalTimer) {
        this.goalTimer = goalTimer;
    }
    /**
     * Metodo para adicionar uma goal a um usuario especifico
     * @param goal recebe uma goal a qual sera adicionado ao usuario
     * @param idPessoa recebe o identificador unico do usuario, para atribuir a ele a goal
     * @return
     */

    public Goal goalAdd(Goal goal, long idPessoa){
        for (Customer usuario : customers)
        {
            if (usuario.getId() == idPessoa){
                usuario.setMeta(goal);
            }
        }
        return goal;
    }

    /**
     * Construtor com os parametros necessarios para adicionar uma goal a um usuario
     * @param idGoal recebe um identificador unico
     * @param goalType recebe o nome da goal ex: musculacao
     * @param goalTimer recebe o tempo que voce praticou aquele exercicio em horas ex: 1.30 = uma hora e meia
     */

    public Goal(long idGoal, String goalType, float goalTimer) {
        this.idGoal = idGoal;
        this.goalType = goalType;
        this.goalTimer = goalTimer;
    }


     // Estou sobrescrevendo o método ToString para printar os valores de forma correta


    @Override
    public String toString() {
        return " ID: " + idGoal +
                " Tipo Meta: " + goalType +
                 " Meta em hora: "+ goalTimer;
    }
}
