package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.models.MenuModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button changeData;

    @FXML
    private Button clientsList;

    @FXML
    private Button createDish;

    @FXML
    private Button ingridientList;
    @FXML
    private Button dishCompositionButton;

    @FXML
    private Button foodIntakeButton;

    public ResourceBundle getResources() {
        return resources;
    }

    public void setResources(ResourceBundle resources) {
        this.resources = resources;
    }

    public URL getLocation() {
        return location;
    }

    public void setLocation(URL location) {
        this.location = location;
    }

    public Button getBackField() {
        return backField;
    }

    public void setBackField(Button backField) {
        this.backField = backField;
    }

    public Button getChangeData() {
        return changeData;
    }

    public void setChangeData(Button changeData) {
        this.changeData = changeData;
    }

    public Button getClientsList() {
        return clientsList;
    }

    public void setClientsList(Button clientsList) {
        this.clientsList = clientsList;
    }

    public Button getCreateDish() {
        return createDish;
    }

    public void setCreateDish(Button createDish) {
        this.createDish = createDish;
    }

    public Button getIngridientList() {
        return ingridientList;
    }

    public void setIngridientList(Button ingridientList) {
        this.ingridientList = ingridientList;
    }


    @FXML
    void initialize() {

    }

    MenuModel menuModel = new MenuModel();

    @FXML
    void switchToHelloScene(ActionEvent event) throws IOException {
        menuModel.switchToHelloScene(event);

    }

    @FXML
    void switchToDishScene(ActionEvent event) throws IOException {
        menuModel.switchToDishScene(event);
    }

    @FXML
    void switchToIngridientsScene(ActionEvent event) throws IOException {
        menuModel.switchToIngridientScene(event);
    }

    @FXML
    void switchToClientsScene(ActionEvent event) throws IOException {
        menuModel.switchToClientsScene(event);
    }

    @FXML
    void switchToClientOrderScene(ActionEvent event) throws IOException {
        menuModel.switchToClientOrdersScene(event);
    }

    @FXML
    void switchToFoodIntakeScene(ActionEvent event) throws IOException {
        menuModel.switchToFoodIntakeScene(event);
    }
    @FXML
    void switchToDishCompositionScene(ActionEvent event) throws IOException {
        menuModel.switchToDishCompositionScene(event);
    }

}
