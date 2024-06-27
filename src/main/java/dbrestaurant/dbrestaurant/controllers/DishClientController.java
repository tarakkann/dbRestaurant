package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.Dishes;
import dbrestaurant.dbrestaurant.models.DishClientModel;
import dbrestaurant.dbrestaurant.models.DishModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class DishClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TableColumn<Dishes, Integer> dishIdColumn;

    @FXML
    private TableColumn<Dishes, String> dishNameColumn;

    @FXML
    private TableView<Dishes> dishTable;
    private final  DishClientModel dishClientModel = new DishClientModel();
    private ObservableList<Dishes> dishList;

    private final DishModel dishModel = new DishModel();


    @FXML
    void switchToClientMenuScene(ActionEvent event) throws IOException {
        dishClientModel.switchToClientMenuScene(event);
    }

    @FXML
    void initialize() {
        dishModel.initializeDishTable(dishIdColumn, dishNameColumn);
        try {
            dishList = dishModel.getDishes();
            dishTable.setItems(dishList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
