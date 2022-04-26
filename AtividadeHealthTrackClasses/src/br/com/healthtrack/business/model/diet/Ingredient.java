package br.com.healthtrack.business.model.diet;

public class Ingredient {
    private String name;
    private int quantity;
    private MeasurementUnit unit;

    public Ingredient(String name, int quantity, MeasurementUnit unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(quantity+ " ")
                .append(unit.getDescription()+" de ")
                .append(name)
                .toString();
    }
}
