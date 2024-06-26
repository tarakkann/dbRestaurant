package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.models.RegistrationModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController {

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

    @FXML
    private CheckBox userField;

    @FXML
    private CheckBox waitersField;

    private final RegistrationModel registrationModel = new RegistrationModel();

    @FXML
    void switchToHomeScene(ActionEvent event) throws IOException {
        registrationModel.switchToHomeScene(event);
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        registrationModel.switchToMenuScene(event);
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
            registrationModel.createReg(name, address, phone);
            registrationModel.switchToMenuScene(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}