package dbrestaurant.dbrestaurant;

public class SingleWrapper {
    private final static SingleWrapper instance = new SingleWrapper();

    public static SingleWrapper getInstance() {
        return instance;
    }
    private Integer id;
    private boolean isClient;

    public int getId() {
        return id;
    }

    public boolean getIsClient() {
        return isClient;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }
}
