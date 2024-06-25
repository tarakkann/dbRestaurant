package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.HelloApplication;
import dbrestaurant.dbrestaurant.Clients;
import dbrestaurant.dbrestaurant.controllers.ClientsController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClientsModel {
    Connection connection;
    int index = -1;

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void addClient(String name, String address, String taxId) throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO clients (name, address, tax_id) VALUES (?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, address);
        pst.setString(3, taxId);
        pst.executeUpdate();
    }

    public ObservableList<Clients> getClientsList() throws ClassNotFoundException, SQLException {
        ObservableList<Clients> clientsList = DataConnection.getClient();
        return clientsList;
    }
//    public void edit() throws SQLException, ClassNotFoundException {
//        connection = DataConnection.getDBConnection();
//        String value1 =
//    }

}
