package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.models.ContactModel;
import dbrestaurant.dbrestaurant.models.MenuClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ContactController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;
    ContactModel contactModel = new ContactModel();

    @FXML
    void switchToClientMenuScene(ActionEvent event) throws IOException {
        contactModel.switchToClientMenuScene(event);
    }

    @FXML
    void initialize() {
    }

}
