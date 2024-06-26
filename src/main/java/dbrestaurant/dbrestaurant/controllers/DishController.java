package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.Dishes;
import dbrestaurant.dbrestaurant.models.DishModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DishController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backField;

    @FXML
    private TextField dishId;

    @FXML
    private TableColumn<Dishes, Integer> dishIdColumn;

    @FXML
    private TextField dishName;

    @FXML
    private TableColumn<Dishes, String> dishNameColumn;

    @FXML
    private TableView<Dishes> dishTable;

    @FXML
    private Button updateButton;

    private ObservableList<Dishes> dishList;

    private final DishModel dishModel = new DishModel();

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

    @FXML
    void addDish() {
        try {
            dishModel.addDish(dishName.getText());
            dishList.setAll(dishModel.getDishes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void updateDish(ActionEvent event) {
        try {
            dishModel.updateDish(dishId.getText(), dishName.getText());
            dishList.setAll(dishModel.getDishes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        int index = dishTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        dishId.setText(dishIdColumn.getCellData(index).toString());
        dishName.setText(dishNameColumn.getCellData(index));
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        dishModel.switchToMenuScene(event);
    }
    @FXML
    void deleteDish() throws SQLException, ClassNotFoundException {
        dishModel.deleteDish(Integer.parseInt(dishId.getText()));
        try {
            dishList = dishModel.getDishes();
            dishTable.setItems(dishList);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
