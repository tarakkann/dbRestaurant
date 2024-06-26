package dbrestaurant.dbrestaurant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataConnection {
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
        return  connection;
    }

    public static ObservableList<Waiters> getWaiter() throws SQLException, ClassNotFoundException{
        Connection connection1 = getDBConnection();
        ObservableList<Waiters> list = FXCollections.observableArrayList();
        PreparedStatement ps = connection1.prepareStatement("SELECT * FROM waiters");
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            list.add(new Waiters(Integer.parseInt(rs.getString("waiter_id")),
                    rs.getString("name"), rs.getString("address"),rs.getString("phone_number")));
        }
        return list;
    }

    public static ObservableList<Dishes> getDish() throws SQLException, ClassNotFoundException{
        Connection connection1 = getDBConnection();
        ObservableList<Dishes> list = FXCollections.observableArrayList();
        PreparedStatement ps = connection1.prepareStatement("SELECT * FROM dishes");
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            list.add(new Dishes(Integer.parseInt(rs.getString("id")),
                    rs.getString("name")));
        }
        return list;
    }
    public static ObservableList<Ingridients> getIngridient() throws SQLException, ClassNotFoundException{
        Connection connection1 = getDBConnection();
        ObservableList<Ingridients> list = FXCollections.observableArrayList();
        PreparedStatement ps = connection1.prepareStatement("SELECT * FROM ingridients");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            list.add(new Ingridients(Integer.parseInt(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("unit"), Double.parseDouble(rs.getString("quantity"))));
        }
        return list;
    }

    public static ObservableList<Clients> getClient() throws SQLException, ClassNotFoundException{
        Connection connection1 = getDBConnection();
        ObservableList<Clients> list = FXCollections.observableArrayList();
        PreparedStatement ps = connection1.prepareStatement("SELECT * FROM clients");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            list.add(new Clients(Integer.parseInt(rs.getString("id")), rs.getString("tax_id"),
                    rs.getString("address"),rs.getString("name")));
        }
        return list;
    }
    public static ObservableList<FoodIntakes> getFoodIntake() throws SQLException, ClassNotFoundException{
        Connection connection1 = getDBConnection();
        ObservableList<FoodIntakes> list = FXCollections.observableArrayList();
        PreparedStatement ps = connection1.prepareStatement("SELECT * FROM foodintake");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            list.add(new FoodIntakes(Integer.parseInt(rs.getString("id")),
                    Integer.parseInt(rs.getString("table_id")),
                    Integer.parseInt(rs.getString("waiter_id")),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    Integer.parseInt(rs.getString("client_id"))));
        }
        return list;
    }
}
