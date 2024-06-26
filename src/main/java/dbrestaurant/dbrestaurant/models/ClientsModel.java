package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.Clients;
import dbrestaurant.dbrestaurant.DataConnection;
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

public class ClientsModel {

    private Stage stage;
    private Scene scene;

    public ObservableList<Clients> getClientsList() throws SQLException, ClassNotFoundException {
        ObservableList<Clients> clientsList = FXCollections.observableArrayList();
        Connection connection = DataConnection.getDBConnection();
        String query = "SELECT * FROM clients";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            clientsList.add(new Clients(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("tax_id")));
        }
        rs.close();
        pst.close();
        connection.close();
        return clientsList;
    }

    public void addClient(String name, String address, String taxId) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO clients (name, address, tax_id) VALUES (?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, address);
        pst.setString(3, taxId);
        pst.executeUpdate();
        pst.close();
        connection.close();
    }

    public void updateClient(String id, String name, String address, String taxId) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "UPDATE clients SET name = ?, address = ?, tax_id = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, address);
        pst.setString(3, taxId);
        pst.setString(4, id);
        pst.execute();
        pst.close();
        connection.close();
    }

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
}
