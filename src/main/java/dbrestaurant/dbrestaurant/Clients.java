package dbrestaurant.dbrestaurant;

public class Clients {
    Integer client_id;
    String name;
    String address;
    String tax_id;

    public Clients(Integer client_id, String name, String address, String tax_id) {
        this.client_id = client_id;
        this.name = name;
        this.address = address;
        this.tax_id = tax_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
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

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }
}
