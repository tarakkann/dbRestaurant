package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField loginField;
    @FXML
    private Button loginSignUpButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authSignInButton;
    private Stage stage;
    private Scene scene;

    public void switchToRegistrationScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("registration.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSignUpScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
}