package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.Dishes;
import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishModel {
    private Stage stage;
    private Scene scene;

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void initializeDishTable(TableColumn<Dishes, Integer> dishIdColumn, TableColumn<Dishes, String> dishNameColumn) {
        dishIdColumn.setCellValueFactory(new PropertyValueFactory<>("dish_id"));
        dishNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public ObservableList<Dishes> getDishes() throws SQLException, ClassNotFoundException {
        ObservableList<Dishes> dishList = FXCollections.observableArrayList();
        Connection connection = DataConnection.getDBConnection();
        String query = "SELECT * FROM dishes";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            dishList.add(new Dishes(rs.getInt("id"), rs.getString("name")));
        }
        rs.close();
        pst.close();
        connection.close();
        return dishList;
    }

    public void addDish(String name) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO DISHES (name) VALUES (?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.executeUpdate();
        pst.close();
        connection.close();
    }

    public void updateDish(String id, String name) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "UPDATE dishes SET name = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, id);
        pst.execute();
        pst.close();
        connection.close();
    }

    public void deleteDish(int id) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "DELETE FROM dishes WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        pst.close();
        connection.close();
    }
}
