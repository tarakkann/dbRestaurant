package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.Ingredients;
import dbrestaurant.dbrestaurant.models.IngridientsModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IngridientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField ingridientId;

    @FXML
    private TableColumn<Ingredients, Integer> ingridientIdColumn;

    @FXML
    private TextField ingridientName;

    @FXML
    private TableColumn<Ingredients, String> ingridientNameColumn;

    @FXML
    private TextField ingridientQuantity;

    @FXML
    private TableColumn<Ingredients, Double> ingridientQuantityColumn;

    @FXML
    private TextField ingridientUnit;

    @FXML
    private TableColumn<Ingredients, String> ingridientUnitColumn;

    @FXML
    private TableView<Ingredients> IngridientTable;

    @FXML
    private Button updateButton;

    private ObservableList<Ingredients> ingredientsList;

    private final IngridientsModel ingridientsModel = new IngridientsModel();

    @FXML
    void initialize() {
        ingridientIdColumn.setCellValueFactory(new PropertyValueFactory<>("ingredient_id"));
        ingridientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ingridientUnitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        ingridientQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        try {
            ingredientsList = ingridientsModel.getIngridients();
            IngridientTable.setItems(ingredientsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addIngridient() {
        try {
            ingridientsModel.addIngridient(ingridientName.getText(),
                    ingridientUnit.getText(), Double.parseDouble(ingridientQuantity.getText()));
            ingredientsList.setAll(ingridientsModel.getIngridients());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void updateIngridients() {
        try {
            ingridientsModel.updateIngridient(ingridientId.getText(),
                    ingridientName.getText(), ingridientUnit.getText(), Double.parseDouble(ingridientQuantity.getText()));
            ingredientsList.setAll(ingridientsModel.getIngridients());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        int index = IngridientTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        ingridientId.setText(ingridientIdColumn.getCellData(index).toString());
        ingridientName.setText(ingridientNameColumn.getCellData(index));
        ingridientUnit.setText(ingridientUnitColumn.getCellData(index));
        ingridientQuantity.setText(ingridientQuantityColumn.getCellData(index).toString());
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        ingridientsModel.switchToMenuScene(event);
    }
}
