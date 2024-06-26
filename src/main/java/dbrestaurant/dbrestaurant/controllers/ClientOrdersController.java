package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.ClientsOrders;
import dbrestaurant.dbrestaurant.Dishes;
import dbrestaurant.dbrestaurant.Ingridients;
import dbrestaurant.dbrestaurant.models.ClientOrdersModel;
import dbrestaurant.dbrestaurant.models.DishModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClientOrdersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backField;

    @FXML
    private TableColumn<ClientsOrders, Integer> clientOrdersIdColumn;

    @FXML
    private TextField clientOrdersQuantity;

    @FXML
    private TableView<ClientsOrders> clientOrdersTable;

    @FXML
    private TextField clientsOrdersId;

    @FXML
    private TextField dishId;

    @FXML
    private TableColumn<ClientsOrders, Integer> dishIdColumn;

    @FXML
    private TextField foodintakeId;

    @FXML
    private TableColumn<ClientsOrders, Integer> foodintakeIdColumn;

    @FXML
    private TableColumn<ClientsOrders, Integer> quantityColumn;

    @FXML
    private Button updateButton;
    private ObservableList<ClientsOrders> clientOrdersList;

    private final ClientOrdersModel clientOrdersModel = new ClientOrdersModel();

    @FXML
    void addClientOrder(ActionEvent event) {
        try {
            clientOrdersModel.addClientOrder(Integer.parseInt(foodintakeId.getText()), Integer.parseInt(dishId.getText()),
                    Integer.parseInt(clientOrdersQuantity.getText()));
            clientOrdersList.setAll(clientOrdersModel.getClientOrders());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        int index = clientOrdersTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        clientsOrdersId.setText(clientOrdersIdColumn.getCellData(index).toString());
        foodintakeId.setText(foodintakeIdColumn.getCellData(index).toString());
        dishId.setText(dishIdColumn.getCellData(index).toString());
        clientOrdersQuantity.setText(quantityColumn.getCellData(index).toString());
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        clientOrdersModel.switchToMenuScene(event);
    }

    @FXML
    void updateClientOrder(ActionEvent event) {
        try {
            clientOrdersModel.updateClientOrders(Integer.parseInt(clientsOrdersId.getText()),
                    Integer.parseInt(foodintakeId.getText()),
                    Integer.parseInt(dishId.getText()),
                    Integer.parseInt(clientOrdersQuantity.getText()));
            clientOrdersList.setAll(clientOrdersModel.getClientOrders());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        clientOrdersModel.initializeClientsOrdersTable(clientOrdersIdColumn, foodintakeIdColumn, dishIdColumn, quantityColumn);
        try {
            clientOrdersList = clientOrdersModel.getClientOrders();
            clientOrdersTable.setItems(clientOrdersList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
