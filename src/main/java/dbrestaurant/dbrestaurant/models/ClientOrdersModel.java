package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.ClientsOrders;
import dbrestaurant.dbrestaurant.DataConnection;
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

public class ClientOrdersModel {
    private Stage stage;
    private Scene scene;

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void initializeClientsOrdersTable(TableColumn <ClientsOrders, Integer> clientOrdersIdColumn, TableColumn<ClientsOrders, Integer> foodintakeIdColumn,
                                             TableColumn<ClientsOrders, Integer> dishIdColumn, TableColumn<ClientsOrders, Integer> quantityColumn) {
        clientOrdersIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        foodintakeIdColumn.setCellValueFactory(new PropertyValueFactory<>("foodintake_id"));
        dishIdColumn.setCellValueFactory(new PropertyValueFactory<>("dish_id"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    public ObservableList<ClientsOrders> getClientOrders() throws SQLException, ClassNotFoundException {
        ObservableList<ClientsOrders> clientsOrdersList = FXCollections.observableArrayList();
        Connection connection = DataConnection.getDBConnection();
        String query = "SELECT * FROM clientorders";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            clientsOrdersList.add(new ClientsOrders(rs.getInt("id"),
                    (rs.getInt("foodintake_id")),
                    (rs.getInt("dish_id")),
                    (rs.getInt("quantity"))));
        }
        rs.close();
        pst.close();
        connection.close();
        return clientsOrdersList;
    }
    public void addClientOrder(int foodintake_id, int dish_id, int quantity) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO CLIENTORDERS (foodintake_id, dish_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, foodintake_id);
        pst.setInt(2, dish_id);
        pst.setInt(3, quantity);
        pst.executeUpdate();
        pst.close();
        connection.close();
    }
    public void updateClientOrders(int id, int foodintake_id, int dish_id, int quantity) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "UPDATE clientorders SET foodintake_id = ?, dish_id = ?, quantity = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, foodintake_id);
        pst.setInt(2, dish_id);
        pst.setInt(3, quantity);
        pst.setInt(4, id);
        pst.execute();
        pst.close();
        connection.close();
    }

}
