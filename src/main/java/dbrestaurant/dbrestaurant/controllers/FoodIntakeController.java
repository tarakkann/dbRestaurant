package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.FoodIntakes;
import dbrestaurant.dbrestaurant.models.FoodIntakeModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

    private ObservableList<FoodIntakes> foodIntakeList;

    private final FoodIntakeModel foodIntakeModel = new FoodIntakeModel();

    @FXML
    void initialize() {
        foodIntakeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_idColumn.setCellValueFactory(new PropertyValueFactory<>("table_id"));
        waiterIdColumn.setCellValueFactory(new PropertyValueFactory<>("waiter_id"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("end_time"));
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        try {
            foodIntakeList = foodIntakeModel.getFoodIntakes();
            foodIntakeTable.setItems(foodIntakeList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addFoodIntake() {
        try {
            foodIntakeModel.addFoodIntake(table_id.getText(), waiterId.getText(), startTime.getText(), endTime.getText(), clientId.getText());
            foodIntakeList.setAll(foodIntakeModel.getFoodIntakes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void updateFoodIntake() {
        try {
            foodIntakeModel.updateFoodIntake(foodIntakeId.getText(), table_id.getText(), waiterId.getText(), startTime.getText(), endTime.getText(), clientId.getText());
            foodIntakeList.setAll(foodIntakeModel.getFoodIntakes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        int index = foodIntakeTable.getSelectionModel().getSelectedIndex();
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
    void deleteFoodIntake() throws SQLException, ClassNotFoundException {
        foodIntakeModel.deleteFoodIntake(Integer.parseInt(foodIntakeId.getText()));
        try {
            foodIntakeList = foodIntakeModel.getFoodIntakes();
            foodIntakeTable.setItems(foodIntakeList);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}