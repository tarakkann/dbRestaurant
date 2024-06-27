package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.models.SeparateRolesModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SeparateRolesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clientRegButton;

    @FXML
    private Button waiterRegButton;
    SeparateRolesModel separateRolesModel = new SeparateRolesModel();

    @FXML
    void switchToWaiterRegScene(ActionEvent event) throws IOException {
        separateRolesModel.switchToWaiterRegScene(event);
    }

    @FXML
    void switchToClientRegScene(ActionEvent event) throws IOException {
        separateRolesModel.switchToClientRegScene(event);
    }

    @FXML
    void initialize() {
    }

}
