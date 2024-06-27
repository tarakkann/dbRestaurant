package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.HelloApplication;
import dbrestaurant.dbrestaurant.models.HelloClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private TextField loginField2;

    @FXML
    private Button lognSgnUBuon;

    @FXML
    private Button thSgnInButton;


    HelloClientModel helloClientModel = new HelloClientModel();
    private Scene scene;
    private Stage stage;

    @FXML
    void switchToRegistrationClientScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("registrationClient.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        String name = loginField.getText();
        String tax_id = loginField2.getText();
        if (helloClientModel.createLog(name, tax_id)) {
            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuClient.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
        } else {
            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("registrationClient.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
        }
    }
}
