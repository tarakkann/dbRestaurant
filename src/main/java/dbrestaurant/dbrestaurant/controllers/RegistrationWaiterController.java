package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.models.RegistrationWaiterModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationWaiterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adressField;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button registrationButton;


    private final RegistrationWaiterModel registrationWaiterModel = new RegistrationWaiterModel();

    @FXML
    void switchToHomeScene(ActionEvent event) throws IOException {
        registrationWaiterModel.switchToHomeScene(event);
    }

    @FXML
    void initialize() {
    }

    @FXML
    void reg(ActionEvent event) {
        try {
            String address = adressField.getText();
            String phone = phoneField.getText();
            String name = nameField.getText();
            registrationWaiterModel.createReg(name, address, phone);
            registrationWaiterModel.switchToMenuScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
