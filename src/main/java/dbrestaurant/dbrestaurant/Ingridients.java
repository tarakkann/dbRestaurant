package dbrestaurant.dbrestaurant;

public class Ingridients {
    int ingredient_id;
    String name;
    String unit;
    double quantity;

    public Ingridients(int ingredient_id, String name, String unit, double quantity) {
        this.ingredient_id = ingredient_id;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
