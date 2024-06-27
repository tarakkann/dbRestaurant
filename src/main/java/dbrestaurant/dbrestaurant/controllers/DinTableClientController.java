package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.DiningTables;
import dbrestaurant.dbrestaurant.Dishes;
import dbrestaurant.dbrestaurant.models.DinTableClientModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DinTableClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TableColumn<DiningTables, Integer> dinTableIdColumn;

    @FXML
    private TableView<DiningTables> dinTableTable;
    private ObservableList <DiningTables> diningTablesList;

    @FXML
    private TableColumn<DiningTables, Integer> maxCapacityColumn;
    private final DinTableClientModel dinTableClientModel = new DinTableClientModel();

    @FXML
    void switchToClientMenuScene(ActionEvent event) throws IOException {
        dinTableClientModel.switchToClientMenuScene(event);
    }

    @FXML
    void initialize() {
        dinTableClientModel.initialize(dinTableIdColumn, maxCapacityColumn);
        try {
            diningTablesList = dinTableClientModel.getDiningTablesList();
            dinTableTable.setItems(diningTablesList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
