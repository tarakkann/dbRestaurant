//package dbrestaurant.dbrestaurant.controllers;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//import dbrestaurant.dbrestaurant.DataConnection;
//import dbrestaurant.dbrestaurant.Dishes;
//import dbrestaurant.dbrestaurant.FoodIntakes;
//import dbrestaurant.dbrestaurant.models.DishModel;
//import dbrestaurant.dbrestaurant.models.FoodIntakeModel;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//
//public class FoodIntakeController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button addButton;
//
//    @FXML
//    private Button backField;
//
//    @FXML
//    private TextField clientId;
//
//    @FXML
//    private TableColumn<FoodIntakes, Integer> clientIdColumn;
//
//    @FXML
//    private TextField endTime;
//
//    @FXML
//    private TableColumn<FoodIntakes, String> endTimeColumn;
//
//    @FXML
//    private TextField foodIntakeId;
//
//    @FXML
//    private TableColumn<FoodIntakes, Integer> foodIntakeIdColumn;
//
//    @FXML
//    private TableView<FoodIntakes> foodIntakeTable;
//
//    @FXML
//    private TextField startTime;
//
//    @FXML
//    private TableColumn<FoodIntakes, String> startTimeColumn;
//
//    @FXML
//    private TextField table_id;
//
//    @FXML
//    private TableColumn<FoodIntakes, Integer> table_idColumn;
//
//    @FXML
//    private Button updateButton;
//
//    @FXML
//    private TextField waiterId;
//
//    @FXML
//    private TableColumn<FoodIntakes, Integer> waiterIdColumn;
//    Connection connection = null;
//    PreparedStatement pst = null;
//    int index = -1;
//
//    ObservableList<FoodIntakes> foodIntakeList;
//
//    FoodIntakeModel foodIntakeModel = new FoodIntakeModel();
//
//    @FXML
//    void addFoodIntake(ActionEvent event) throws SQLException, ClassNotFoundException {
//        connection = DataConnection.getDBConnection();
//        String sql = "INSERT INTO foodintake (table_id, waiter_id, start_time, end_time, client_id) VALUES (?, ?, ?, ?, ?)";
//        pst = connection.prepareStatement(sql);
//        pst.setString(1, table_id.getText());
//        pst.setString(2, waiterId.getText());
//        pst.setString(3, startTime.getText());
//        pst.setString(4, endTime.getText());
//        pst.setString(5, clientId.getText());
//        pst.executeUpdate();
//    }
//
//    @FXML
//    void getSelected(MouseEvent event) {
//        index = foodIntakeTable.getSelectionModel().getSelectedIndex();
//        if (index <= -1){
//            return;
//        }
//        foodIntakeId.setText(foodIntakeIdColumn.getCellData(index).toString());
//        table_id.setText(table_idColumn.getCellData(index).toString());
//        waiterId.setText(waiterIdColumn.getCellData(index).toString());
//        startTime.setText(startTimeColumn.getCellData(index));
//        endTime.setText(endTimeColumn.getCellData(index));
//        clientId.setText(clientIdColumn.getCellData(index).toString());
//    }
//
//    @FXML
//    void switchToMenuScene(ActionEvent event) throws IOException {
//        foodIntakeModel.switchToMenuScene(event);
//    }
//
//    @FXML
//    void updateFoodIntake(ActionEvent event) throws SQLException, ClassNotFoundException {
//        connection = DataConnection.getDBConnection();
//        String value1 = foodIntakeId.getText();
//        String value2 = table_id.getText();
//        String value3 = waiterId.getText();
//        String value4 = startTime.getText();
//        String value5 = endTime.getText();
//        String value6 = clientId.getText();
//        String sql = "UPDATE foodintake SET id = '"+value1+
//                "', table_id = '"+value2+
//                "', waiter_id = '"+value3+
//                "', start_time = '"+value4+
//                "', end_time = '"+value5+
//                "', client_id = '"+value6+
//                "' WHERE id = '"+value1+"' ";
//        PreparedStatement pst = connection.prepareStatement(sql);
//        pst.execute();
//    }
//
//    @FXML
//    void initialize() {
//        foodIntakeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        table_idColumn.setCellValueFactory(new PropertyValueFactory<>("table_id"));
//        waiterIdColumn.setCellValueFactory(new PropertyValueFactory<>("waiter_id"));
//        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("start_time"));
//        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("end_time"));
//        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("client_id"));
//        try {
//            foodIntakeList = DataConnection.getFoodIntake();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//        foodIntakeTable.setItems(foodIntakeList);
//
//    }
//
//}
package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.FoodIntakes;
import dbrestaurant.dbrestaurant.models.FoodIntakeModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FoodIntakeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backField;

    @FXML
    private TextField clientId;

    @FXML
    private TableColumn<FoodIntakes, Integer> clientIdColumn;

    @FXML
    private TextField endTime;

    @FXML
    private TableColumn<FoodIntakes, String> endTimeColumn;

    @FXML
    private TextField foodIntakeId;

    @FXML
    private TableColumn<FoodIntakes, Integer> foodIntakeIdColumn;

    @FXML
    private TableView<FoodIntakes> foodIntakeTable;

    @FXML
    private TextField startTime;

    @FXML
    private TableColumn<FoodIntakes, String> startTimeColumn;

    @FXML
    private TextField table_id;

    @FXML
    private TableColumn<FoodIntakes, Integer> table_idColumn;

    @FXML
    private Button updateButton;

    @FXML
    private TextField waiterId;

    @FXML
    private TableColumn<FoodIntakes, Integer> waiterIdColumn;
    Connection connection = null;
    PreparedStatement pst = null;
    int index = -1;

    ObservableList<FoodIntakes> foodIntakeList;

    FoodIntakeModel foodIntakeModel = new FoodIntakeModel();

    @FXML
    void addFoodIntake(ActionEvent event) throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO foodintake (table_id, waiter_id, start_time, end_time, client_id) VALUES (?, ?, ?, ?, ?)";
        pst = connection.prepareStatement(sql);
        pst.setString(1, table_id.getText());
        pst.setString(2, waiterId.getText());
        pst.setString(3, startTime.getText());
        pst.setString(4, endTime.getText());
        pst.setString(5, clientId.getText());
        pst.executeUpdate();
    }

    @FXML
    void getSelected(MouseEvent event) {
        index = foodIntakeTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        foodIntakeId.setText(foodIntakeIdColumn.getCellData(index).toString());
        table_id.setText(table_idColumn.getCellData(index).toString());
        waiterId.setText(waiterIdColumn.getCellData(index).toString());
        startTime.setText(startTimeColumn.getCellData(index));
        endTime.setText(endTimeColumn.getCellData(index));
        clientId.setText(clientIdColumn.getCellData(index).toString());
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        foodIntakeModel.switchToMenuScene(event);
    }

    @FXML
    void updateFoodIntake(ActionEvent event) throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String value1 = foodIntakeId.getText();
        String value2 = table_id.getText();
        String value3 = waiterId.getText();
        String value4 = startTime.getText();
        String value5 = endTime.getText();
        String value6 = clientId.getText();
        String sql = "UPDATE foodintake SET id = '"+value1+
                "', table_id = '"+value2+
                "', waiter_id = '"+value3+
                "', start_time = '"+value4+
                "', end_time = '"+value5+
                "', client_id = '"+value6+
                "' WHERE id = '"+value1+"' ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.execute();
    }

    @FXML
    void initialize() {
        foodIntakeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_idColumn.setCellValueFactory(new PropertyValueFactory<>("table_id"));
        waiterIdColumn.setCellValueFactory(new PropertyValueFactory<>("waiter_id"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("end_time"));
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        try {
            foodIntakeList = DataConnection.getFoodIntake();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        foodIntakeTable.setItems(foodIntakeList);
    }
}
