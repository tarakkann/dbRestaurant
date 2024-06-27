package dbrestaurant.dbrestaurant;

public class Dishes {
    int dish_id;
    private String name;

    public Dishes(int dish_id, String name) {
        this.dish_id = dish_id;
        this.name = name;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

