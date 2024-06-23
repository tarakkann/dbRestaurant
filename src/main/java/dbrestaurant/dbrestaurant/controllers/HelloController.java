package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.HelloApplication;
import dbrestaurant.dbrestaurant.models.SignInModel;
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
    private TextField loginField1;

    @FXML
    private Button lognSgnUBuon;

    @FXML
    private Button thSgnInButton;


    private Scene scene;
    private Stage stage;

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
    SignInModel signInModel = new SignInModel();
    @FXML
    void login(ActionEvent event) throws IOException {
        String phone = loginField1.getText();
        String name = loginField.getText();
        if (signInModel.createLog(name, phone)) {
            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
        } else {
            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("registration.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
        }
    }

}