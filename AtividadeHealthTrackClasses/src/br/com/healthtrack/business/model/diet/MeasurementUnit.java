package br.com.healthtrack.business.model.diet;

public enum MeasurementUnit{
    GRAMS("grama(s)","g"),
    KILOS("quilo(s)","k"),
    CALORIES("caloria(s)","cal"),
    KILO_CALORIES("quilo caloria(s)","kcal"),
    LITERS("litro(s)","l"),
    UNIT("unidades","un"),
    MILLI_LITERS("mililitro(s)","ml");


    private String description;
    private String shortForm;

    MeasurementUnit(String description, String shortForm){
        this.description = description;
        this.shortForm = shortForm;
    }

    public String getDescription() {
        return description;
    }

    public String getShortForm() {
        return shortForm;
    }

    public class UNIT {
    }

    @Override
    public String toString() {
        return "MeasurementUnit{" +
                "description='" + description + '\'' +
                ", shortForm='" + shortForm + '\'' +
                '}';
    }
}
