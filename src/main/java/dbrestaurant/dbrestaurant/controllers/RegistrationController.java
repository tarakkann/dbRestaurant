package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.HelloApplication;
import dbrestaurant.dbrestaurant.SingleWrapper;
import dbrestaurant.dbrestaurant.models.RegistrationModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    RegistrationModel registrationModel = new RegistrationModel();

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

    public RegistrationController() {
        this.registrationModel = new RegistrationModel();
    }


    private Stage stage;
    private Scene scene;


    @FXML
    void reg(ActionEvent event) throws IOException {
        String address = adressField.getText();
        String phone = phoneField.getText();
        String name = nameField.getText();
        registrationModel.createReg(name, address, phone);
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

}
