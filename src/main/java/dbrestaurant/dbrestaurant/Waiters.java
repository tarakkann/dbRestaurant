package dbrestaurant.dbrestaurant;

public class Waiters {
    int waiter_id;
    String name;
    String address;
    String phone_number;

    public Waiters(int id, String name, String address, String phone_number) {
        this.waiter_id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    public int getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(int waiter_id) {
        this.waiter_id = waiter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
