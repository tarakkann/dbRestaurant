package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.models.RegistrationModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;

public class RegistrationController {
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
    private TextField passwordField;

    RegistrationModel registrationModel = new RegistrationModel();

    public void switchToHomeScene(ActionEvent event) throws IOException {
        registrationModel.switchToHomeScene(event);
    }
}
