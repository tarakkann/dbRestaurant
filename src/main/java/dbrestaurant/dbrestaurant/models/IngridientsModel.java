package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.HelloApplication;
import dbrestaurant.dbrestaurant.Ingredients;
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

public class IngridientsModel {
    private Stage stage;
    private Scene scene;

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<Ingredients> getIngridients() throws SQLException, ClassNotFoundException {
        ObservableList<Ingredients> ingredientsList = FXCollections.observableArrayList();
        Connection connection = DataConnection.getDBConnection();
        String query = "SELECT * FROM ingridients";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            ingredientsList.add(new Ingredients(rs.getInt("id"), rs.getString("name"), rs.getString("unit"), rs.getDouble("quantity")));
        }
        rs.close();
        pst.close();
        connection.close();
        return ingredientsList;
    }

    public void addIngridient(String name, String unit, double quantity) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO ingridients (name, unit, quantity) VALUES (?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, unit);
        pst.setDouble(3, quantity);
        pst.executeUpdate();
        pst.close();
        connection.close();
    }

    public void updateIngridient(String id, String name, String unit, double quantity) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "UPDATE ingridients SET name = ?, unit = ?, quantity = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, unit);
        pst.setDouble(3, quantity);
        pst.setInt(4, Integer.parseInt(id));
        pst.execute();
        pst.close();
        connection.close();
    }
}
