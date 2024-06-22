package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.Dishes;
import dbrestaurant.dbrestaurant.models.DishModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    Connection connection = null;
    PreparedStatement pst = null;

    ObservableList<Dishes> dishList;

    DishModel dishModel = new DishModel();

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

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getBackField() {
        return backField;
    }

    public void setBackField(Button backField) {
        this.backField = backField;
    }

    public TextField getDishId() {
        return dishId;
    }

    public void setDishId(TextField dishId) {
        this.dishId = dishId;
    }

    public TableColumn<Dishes, Integer> getDishIdColumn() {
        return dishIdColumn;
    }

    public void setDishIdColumn(TableColumn<Dishes, Integer> dishIdColumn) {
        this.dishIdColumn = dishIdColumn;
    }

    public TextField getDishName() {
        return dishName;
    }

    public void setDishName(TextField dishName) {
        this.dishName = dishName;
    }

    public TableColumn<Dishes, String> getDishNameColumn() {
        return dishNameColumn;
    }

    public void setDishNameColumn(TableColumn<Dishes, String> dishNameColumn) {
        this.dishNameColumn = dishNameColumn;
    }

    public TableView<Dishes> getDishTable() {
        return dishTable;
    }

    public void setDishTable(TableView<Dishes> dishTable) {
        this.dishTable = dishTable;
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        dishModel.switchToMenuScene(event);
    }

    @FXML
    void initialize() {
        dishIdColumn.setCellValueFactory(new PropertyValueFactory<>("dish_id"));
        dishNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        try {
            dishList = DataConnection.getDish();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        dishTable.setItems(dishList);
    }

    @FXML
    void addDish() throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO DISHES (name) VALUES (?)";
        pst = connection.prepareStatement(sql);
        pst.setString(1, dishName.getText());
        pst.executeUpdate();
    }
}
