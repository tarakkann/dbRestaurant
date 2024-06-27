package dbrestaurant.dbrestaurant;

import java.sql.*;

public class DataConnection {
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
        return connection;
    }
}
