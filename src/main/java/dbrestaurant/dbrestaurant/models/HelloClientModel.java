package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.SingleWrapper;

import java.sql.*;
import java.util.Collection;

public class HelloClientModel {
    PreparedStatement preparedStatement;
    Connection connection;

    public HelloClientModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createLog(String name, String tax_id) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE name = ? and tax_id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, tax_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Integer id = rs.getInt("id");
                SingleWrapper.getInstance().setId(id);
                SingleWrapper.getInstance().setIsClient(true);
                return true;
            } else
                return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
