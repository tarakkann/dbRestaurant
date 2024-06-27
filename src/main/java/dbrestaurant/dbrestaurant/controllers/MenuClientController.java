package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.models.MenuClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button changeData;

    @FXML
    private Button createDish;

    @FXML
    private Button didngTables;

    @FXML
    private Button dishCompositionButton;
    private final MenuClientModel menuClientModel = new MenuClientModel();

    @FXML
    void switchToDishCompositionScene(ActionEvent event) throws IOException {
        menuClientModel.switchToDishCompositionScene(event);
    }

    @FXML
    void switchToDishScene(ActionEvent event) throws IOException {
        menuClientModel.switchToDishScene(event);
    }

    @FXML
    void switchToHelloScene(ActionEvent event) throws IOException {
        menuClientModel.switchToHelloScene(event);

    }

    @FXML
    void switchToTablesScene(ActionEvent event) throws IOException {
        menuClientModel.switchToTablesScene(event);
    }

    @FXML
    void switchToContactPage(ActionEvent event) throws IOException {
        menuClientModel.switchToContactPage(event);
    }

    @FXML
    void switchToChangeDataPage(ActionEvent event) throws IOException {
        menuClientModel.switchToChangeDataPage(event);
    }

    @FXML
    void initialize() {

    }

}
