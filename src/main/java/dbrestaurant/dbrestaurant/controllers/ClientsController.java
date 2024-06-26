package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.Clients;
import dbrestaurant.dbrestaurant.models.ClientsModel;
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

public class ClientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField clientsAddress;

    @FXML
    private TableColumn<Clients, String> clientsAddressColumn;

    @FXML
    private TextField clientsId;

    @FXML
    private TableColumn<Clients, Integer> clientsIdColumn;

    @FXML
    private TextField clientsName;

    @FXML
    private TableColumn<Clients, String> clientsNameColumn;

    @FXML
    private TextField clientsTaxId;

    @FXML
    private TableColumn<Clients, String> clientsTaxIdColumn;

    @FXML
    private TableView<Clients> clientsTable;

    @FXML
    private Button updateButton;

    private ObservableList<Clients> clientsList;

    private final ClientsModel clientsModel = new ClientsModel();

    @FXML
    void initialize() {
        clientsIdColumn.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        clientsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientsAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        clientsTaxIdColumn.setCellValueFactory(new PropertyValueFactory<>("tax_id"));
        try {
            clientsList = clientsModel.getClientsList();
            clientsTable.setItems(clientsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addClient() {
        try {
            clientsModel.addClient(clientsName.getText(), clientsAddress.getText(), clientsTaxId.getText());
            clientsList.setAll(clientsModel.getClientsList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void updateClient() {
        try {
            clientsModel.updateClient(clientsId.getText(), clientsName.getText(), clientsAddress.getText(), clientsTaxId.getText());
            clientsList.setAll(clientsModel.getClientsList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        int index = clientsTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        clientsId.setText(clientsIdColumn.getCellData(index).toString());
        clientsName.setText(clientsNameColumn.getCellData(index));
        clientsAddress.setText(clientsAddressColumn.getCellData(index));
        clientsTaxId.setText(clientsTaxIdColumn.getCellData(index));
    }


    public void switchToMenuScene(ActionEvent event) throws IOException {
        clientsModel.switchToMenuScene(event);
    }
}