package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.SingleWrapper;
import dbrestaurant.dbrestaurant.models.ChangeWaiterDataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangeWaiterDataController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField address;

    @FXML
    private Button backField;

    @FXML
    private Button changeButton;

    @FXML
    private TextField name;

    @FXML
    private TextField phone_number;
    private final ChangeWaiterDataModel changeWaiterDataModel = new ChangeWaiterDataModel();

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        changeWaiterDataModel.switchToMenuScene(event);
    }

    @FXML
    void initialize() {
    }

    @FXML
    void changeData() throws SQLException, ClassNotFoundException {
        Integer id = SingleWrapper.getInstance().getId();
        String waiterName = name.getText();
        String waiterAddress = address.getText();
        String waiterPhoneNumber = phone_number.getText();
        changeWaiterDataModel.changeData(id, waiterName, waiterAddress, waiterPhoneNumber);
        showAlert("Успех", "Данные успешно изменены.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
