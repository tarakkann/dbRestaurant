package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.FoodIntakes;
import dbrestaurant.dbrestaurant.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodIntakeModel {
    private Stage stage;
    private Scene scene;

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<FoodIntakes> getFoodIntakes() throws SQLException, ClassNotFoundException {
        ObservableList<FoodIntakes> foodIntakeList = FXCollections.observableArrayList();
        Connection connection = DataConnection.getDBConnection();
        String query = "SELECT * FROM foodintake";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            foodIntakeList.add(new FoodIntakes(rs.getInt("id"), rs.getInt("table_id"), rs.getInt("waiter_id"),
                    rs.getString("start_time"), rs.getString("end_time"), rs.getInt("client_id")));
        }
        rs.close();
        pst.close();
        connection.close();
        return foodIntakeList;
    }

    public void addFoodIntake(String table_id, String waiter_id, String start_time, String end_time, String client_id) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO foodintake (table_id, waiter_id, start_time, end_time, client_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(table_id));
        pst.setInt(2, Integer.parseInt(waiter_id));
        pst.setString(3, start_time);
        pst.setString(4, end_time);
        pst.setInt(5, Integer.parseInt(client_id));
        pst.executeUpdate();
        pst.close();
        connection.close();
    }

    public void updateFoodIntake(String id, String table_id, String waiter_id, String start_time, String end_time, String client_id) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "UPDATE foodintake SET table_id = ?, waiter_id = ?, start_time = ?, end_time = ?, client_id = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(table_id));
        pst.setInt(2, Integer.parseInt(waiter_id));
        pst.setString(3, start_time);
        pst.setString(4, end_time);
        pst.setInt(5, Integer.parseInt(client_id));
        pst.setInt(6, Integer.parseInt(id));
        pst.execute();
        pst.close();
        connection.close();
    }
}