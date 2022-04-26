package br.com.healthtrack.business.model.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que remete ao historico de peso do customer
 */
public class WeightHistory {
    private List<WeightRecord> weightRecords = new ArrayList<>();

    public WeightRecord getCurrentWeight() {
        return weightRecords.get(weightRecords.size()-1);
    }

    public List<WeightRecord> getWeightRecords() {
        return weightRecords;
    }

    /**
     * Adiciona um novo peso ao customer
     * @param weight peso do customer
     */
    public void addWeightRecord(WeightRecord weight){
        weightRecords.add(weight);
    }

    public WeightHistory(WeightRecord weight){
        this.weightRecords.add(weight);
    }
    public WeightHistory(Double weight) {
        WeightRecord record = new WeightRecord(weight);
        weightRecords.add(record);
    }
}


