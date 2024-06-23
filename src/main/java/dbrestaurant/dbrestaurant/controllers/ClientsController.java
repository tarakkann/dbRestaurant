package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.Clients;
import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.Ingridients;
import dbrestaurant.dbrestaurant.models.ClientsModel;
import dbrestaurant.dbrestaurant.models.IngridientsModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backField;

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
    private TableView<Clients> clientsTable;

    @FXML
    private TextField clientsTaxId;

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

    public TextField getClientsAddress() {
        return clientsAddress;
    }

    public void setClientsAddress(TextField clientsAddress) {
        this.clientsAddress = clientsAddress;
    }

    public TableColumn<Clients, String> getClientsAddressColumn() {
        return clientsAddressColumn;
    }

    public void setClientsAddressColumn(TableColumn<Clients, String> clientsAddressColumn) {
        this.clientsAddressColumn = clientsAddressColumn;
    }

    public TextField getClientsId() {
        return clientsId;
    }

    public void setClientsId(TextField clientsId) {
        this.clientsId = clientsId;
    }

    public TableColumn<Clients, Integer> getClientsIdColumn() {
        return clientsIdColumn;
    }

    public void setClientsIdColumn(TableColumn<Clients, Integer> clientsIdColumn) {
        this.clientsIdColumn = clientsIdColumn;
    }

    public TextField getClientsName() {
        return clientsName;
    }

    public void setClientsName(TextField clientsName) {
        this.clientsName = clientsName;
    }

    public TableColumn<Clients, String> getClientsNameColumn() {
        return clientsNameColumn;
    }

    public void setClientsNameColumn(TableColumn<Clients, String> clientsNameColumn) {
        this.clientsNameColumn = clientsNameColumn;
    }

    public TableView<Clients> getClientsTable() {
        return clientsTable;
    }

    public void setClientsTable(TableView<Clients> clientsTable) {
        this.clientsTable = clientsTable;
    }

    public TextField getClientsTaxId() {
        return clientsTaxId;
    }

    public void setClientsTaxId(TextField clientsTaxId) {
        this.clientsTaxId = clientsTaxId;
    }

    public TableColumn<Clients, String> getClientsTaxIdColumn() {
        return clientsTaxIdColumn;
    }

    public void setClientsTaxIdColumn(TableColumn<Clients, String> clientsTaxIdColumn) {
        this.clientsTaxIdColumn = clientsTaxIdColumn;
    }

    @FXML
    private TableColumn<Clients, String> clientsTaxIdColumn;
    ClientsModel clientsModel = new ClientsModel();
    Connection connection = null;
    PreparedStatement pst = null;
    ObservableList<Clients> clientsList;
    @FXML
    void addClients(ActionEvent event) throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO clients (name, address, tax_id) VALUES (?, ?, ?)";
        pst = connection.prepareStatement(sql);
        pst.setString(1, clientsName.getText());
        pst.setString(2, clientsAddress.getText());
        pst.setString(3, clientsTaxId.getText());
        pst.executeUpdate();
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        clientsModel.switchToMenuScene(event);
    }

    @FXML
    void initialize() {
        clientsIdColumn.setCellValueFactory(new PropertyValueFactory<>("clients_id"));
        clientsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientsAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        clientsTaxIdColumn.setCellValueFactory(new PropertyValueFactory<>("tax_id"));
        try {
            clientsList = DataConnection.getClient();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        clientsTable.setItems(clientsList);
    }

}
