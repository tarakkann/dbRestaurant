package dbrestaurant.dbrestaurant;

public class ClientsOrder {
    int id;
    int foodintake_id;
    int dish_id;
    int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodintake_id() {
        return foodintake_id;
    }

    public void setFoodintake_id(int foodintake_id) {
        this.foodintake_id = foodintake_id;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ClientsOrder(int id, int foodintake_id,
                        int dish_id, int quantity) {
        this.id = id;
        this.foodintake_id = foodintake_id;
        this.dish_id = dish_id;
        this.quantity = quantity;
    }
}
