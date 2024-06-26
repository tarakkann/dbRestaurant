package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.DishComposition;
import dbrestaurant.dbrestaurant.Dishes;
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

public class DishCompositionModel {
    private Stage stage;
    private Scene scene;

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void initializeDishCompositionTable(TableColumn<DishComposition, Integer> dishIdColumn,
                                               TableColumn<DishComposition, Integer> ingredientIdColumn,
                                               TableColumn<DishComposition, Double> quantityColumn) {
        dishIdColumn.setCellValueFactory(new PropertyValueFactory<>("dish_id"));
        ingredientIdColumn.setCellValueFactory(new PropertyValueFactory<>("ingredient_id"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    public ObservableList<DishComposition> getDishCompositions() throws SQLException, ClassNotFoundException {
        ObservableList<DishComposition> dishList = FXCollections.observableArrayList();
        Connection connection = DataConnection.getDBConnection();
        String query = "SELECT * FROM dishcomposition";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            dishList.add(new DishComposition(rs.getInt("dish_id"),
                    rs.getInt("ingredient_id"), rs.getDouble("quantity")));
        }
        rs.close();
        pst.close();
        connection.close();
        return dishList;
    }

    public void addDishComposition(int dish_id, int ingredient_id, double quantity) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO dishcomposition (dish_id, ingredient_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, dish_id);
        pst.setInt(2, ingredient_id);
        pst.setDouble(3, quantity);
        pst.executeUpdate();
        pst.close();
        connection.close();
    }

    public void updateDish(int dish_id, int ingredient_id, double quantity) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "UPDATE dishcomposition SET quantity = ? WHERE dish_id = ? AND ingredient_id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setDouble(1, quantity);
        pst.setInt(2, dish_id);
        pst.setInt(3, ingredient_id);
        pst.execute();
        pst.close();
        connection.close();
    }
    public void deleteDishComposition(int dish_id, int ingredient_id) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "DELETE FROM dishcomposition WHERE dish_id = ? AND ingredient_id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, dish_id);
        pst.setInt(2, ingredient_id);
        pst.executeUpdate();
        pst.close();
        connection.close();
    }
}
