package dbrestaurant.dbrestaurant;

public class DiningTables {
    int id;
    int max_capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public DiningTables(int id, int max_capacity) {
        this.id = id;
        this.max_capacity = max_capacity;
    }
}
