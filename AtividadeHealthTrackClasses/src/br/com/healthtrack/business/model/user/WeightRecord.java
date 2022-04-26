package br.com.healthtrack.business.model.user;
import br.com.healthtrack.business.model.diet.MeasurementUnit;

import java.time.Instant;
import java.util.Date;

/**
 * Classe que faz o registro do peso do customer em determinada data para complementar a classe WeightHistory
 */
public class WeightRecord {
    private Date date;
    private Double weight;

    public Date getDate() {
        return date;
    }

    public Double getWeight() {
        return weight;
    }

    /**
     * Construtor que recebe o peso do customer numa data especifica
     * @param weight peso do customer
     */
    public WeightRecord(Double weight){
        this.weight = weight;
        this.date = Date.from(Instant.now());
    }

    public WeightRecord(Date date, Double weight) {
        this.date = date;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return date.toString() + ":" + weight.toString() + MeasurementUnit.KILOS.getDescription();
    }
}
