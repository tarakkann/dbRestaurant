package dbrestaurant.dbrestaurant;

public class FoodIntakes {
    int id;
    int table_id;
    int waiter_id;
    String start_time;
    String end_time;
    int client_id;
    public FoodIntakes(int id, int table_id, int waiter_id, String start_time,
                                      String end_time, int client_id) {
        this.id = id;
        this.table_id = table_id;
        this.waiter_id = waiter_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(int waiter_id) {
        this.waiter_id = waiter_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }


}
