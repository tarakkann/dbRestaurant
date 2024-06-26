package dbrestaurant.dbrestaurant;

public class DishComposition {
    int dish_id;
    int ingredient_id;
    double quantity;

    public DishComposition(int dish_id, int ingredient_id, double quantity) {
        this.dish_id = dish_id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
