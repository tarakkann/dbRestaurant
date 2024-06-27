package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.DishComposition;
import dbrestaurant.dbrestaurant.models.DishCompositionClientModel;
import dbrestaurant.dbrestaurant.models.DishCompositionModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DishCompositionClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TableView<DishComposition> dishCompositionTable;

    @FXML
    private TableColumn<DishComposition, Integer> dishIdColumn;

    @FXML
    private TableColumn<DishComposition, Integer> ingredientIdColumn;

    @FXML
    private TableColumn<DishComposition, Double> quantityColumn;
    private ObservableList<DishComposition> dishCompositionsList;

    private final DishCompositionModel dishCompositionModel = new DishCompositionModel();
    private final DishCompositionClientModel dishCompositionClientModel = new DishCompositionClientModel();

    @FXML
    void switchToClientMenuScene(ActionEvent event) throws IOException {
        dishCompositionClientModel.switchToClientMenuScene(event);
    }

    @FXML
    void initialize() {
        dishCompositionModel.initializeDishCompositionTable(dishIdColumn, ingredientIdColumn, quantityColumn);
        try {
            dishCompositionsList = dishCompositionModel.getDishCompositions();
            dishCompositionTable.setItems(dishCompositionsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
