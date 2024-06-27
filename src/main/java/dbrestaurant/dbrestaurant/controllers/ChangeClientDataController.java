package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.SingleWrapper;
import dbrestaurant.dbrestaurant.models.ChangeClientDataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangeClientDataController {

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
    private TextField tax_id;
    private final ChangeClientDataModel changeClientDataModel = new ChangeClientDataModel();

    @FXML
    void changeData(ActionEvent event) throws SQLException, ClassNotFoundException {
        Integer id = SingleWrapper.getInstance().getId();
        String clientName = name.getText();
        String clientAddress = address.getText();
        String clientTaxId = tax_id.getText();
        changeClientDataModel.changeData(id, clientTaxId, clientName, clientAddress);
        showAlert("Успех", "Данные успешно изменены.");
    }

    @FXML
    void switchToClientMenuScene(ActionEvent event) throws IOException {
        changeClientDataModel.switchToClientMenuScene(event);
    }

    @FXML
    void initialize() {
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
