package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.DiningTables;
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

public class DinTableClientModel {
    private Stage stage;
    private Scene scene;

    public void switchToClientMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuClient.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(TableColumn<DiningTables, Integer> dinTableIdColumn, TableColumn<DiningTables, Integer> maxCapacityColumn) {
        dinTableIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        maxCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("max_capacity"));
    }

    public ObservableList<DiningTables> getDiningTablesList() throws SQLException, ClassNotFoundException {
        ObservableList<DiningTables> diningTablesList = FXCollections.observableArrayList();
        Connection connection = DataConnection.getDBConnection();
        String query = "SELECT * FROM diningtables";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            diningTablesList.add(new DiningTables(rs.getInt("id"), rs.getInt("max_capacity")));
        }
        rs.close();
        pst.close();
        connection.close();
        return diningTablesList;
    }
}
