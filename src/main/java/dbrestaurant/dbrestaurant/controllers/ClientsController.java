package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.Client;
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
import java.sql.SQLException;
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
    private TableColumn<Client, String> clientsAddressColumn;

    @FXML
    private TextField clientsId;

    @FXML
    private TableColumn<Client, Integer> clientsIdColumn;

    @FXML
    private TextField clientsName;

    @FXML
    private TableColumn<Client, String> clientsNameColumn;

    @FXML
    private TextField clientsTaxId;

    @FXML
    private TableColumn<Client, String> clientsTaxIdColumn;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private Button updateButton;

    private ObservableList<Client> clientList;

    private final ClientsModel clientsModel = new ClientsModel();

    @FXML
    void initialize() {
        clientsIdColumn.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        clientsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientsAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        clientsTaxIdColumn.setCellValueFactory(new PropertyValueFactory<>("tax_id"));
        try {
            clientList = clientsModel.getClientsList();
            clientsTable.setItems(clientList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addClient() {
        try {
            clientsModel.addClient(clientsName.getText(), clientsAddress.getText(), clientsTaxId.getText());
            clientList.setAll(clientsModel.getClientsList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void updateClient() {
        try {
            clientsModel.updateClient(clientsId.getText(), clientsName.getText(), clientsAddress.getText(), clientsTaxId.getText());
            clientList.setAll(clientsModel.getClientsList());
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

    @FXML
    void deleteClient() throws SQLException, ClassNotFoundException {
        clientsModel.deleteClient(Integer.parseInt(clientsId.getText()));
        try {
            clientList = clientsModel.getClientsList();
            clientsTable.setItems(clientList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}