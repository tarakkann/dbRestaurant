package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.DishComposition;
import dbrestaurant.dbrestaurant.Dishes;
import dbrestaurant.dbrestaurant.models.DishCompositionModel;
import dbrestaurant.dbrestaurant.models.DishModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DishCompositionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backField;

    @FXML
    private TableView<DishComposition> dishCompositionTable;

    @FXML
    private TextField dishId;

    @FXML
    private TableColumn<DishComposition, Integer> dishIdColumn;

    @FXML
    private TextField ingredientId;

    @FXML
    private TableColumn<DishComposition, Integer> ingredientIdColumn;

    @FXML
    private TextField quantity;

    @FXML
    private TableColumn<DishComposition, Double> quantityColumn;

    @FXML
    private Button updateButton;
    private ObservableList<DishComposition> dishCompositionsList;

    private final DishCompositionModel dishCompositionModel = new DishCompositionModel();

    @FXML
    void addDishComposition(ActionEvent event) {
        try {
            dishCompositionModel.addDishComposition(Integer.parseInt(dishId.getText()), Integer.parseInt(ingredientId.getText()),
                    Double.parseDouble(quantity.getText()));
            dishCompositionsList.setAll(dishCompositionModel.getDishCompositions());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        int index = dishCompositionTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        dishId.setText(dishIdColumn.getCellData(index).toString());
        ingredientId.setText(ingredientIdColumn.getCellData(index).toString());
        quantity.setText(quantityColumn.getCellData(index).toString());
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        dishCompositionModel.switchToMenuScene(event);
    }

    @FXML
    void updateDishComposition(ActionEvent event) {
        try {
            dishCompositionModel.updateDish(Integer.parseInt(dishId.getText()), Integer.parseInt(ingredientId.getText()),
                    Double.parseDouble(quantity.getText()));
            dishCompositionsList.setAll(dishCompositionModel.getDishCompositions());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
