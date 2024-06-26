package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.SingleWrapper;

import java.sql.*;
import java.util.Collection;

public class SignInModel {
    Collection collection;
    PreparedStatement preparedStatement;
    Connection connection;

    public SignInModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restaurant",
                    "root", "");


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createLog(String name, String phone) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM waiters WHERE name=? and phone_number=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Integer id = rs.getInt("id");
                SingleWrapper.getInstance().setId(id);
                SingleWrapper.getInstance().setIsClient(true);
                return true;
            }
            else
                return false;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
