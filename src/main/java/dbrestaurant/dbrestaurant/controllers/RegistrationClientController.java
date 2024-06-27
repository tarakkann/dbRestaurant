package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.models.RegistrationClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrationClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField taxIdField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField nameField;

    @FXML
    private Button registrationButton;
    private final RegistrationClientModel registrationClientModel = new RegistrationClientModel();

    @FXML
    void switchToHomeScene(ActionEvent event) throws IOException {
        registrationClientModel.switchToHomeScene(event);
    }

    @FXML
    void reg(ActionEvent event) {
        try {
            String name = nameField.getText();
            String taxId = taxIdField.getText();
            String address = addressField.getText();
            if (registrationClientModel.createReg(taxId, name, address)) {
                registrationClientModel.switchToMenuClientScene(event);
            }
        } catch (IOException e) {
            showError("Error", "Error");
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
    }
}
