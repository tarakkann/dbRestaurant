package dbrestaurant.dbrestaurant.controllers;

import dbrestaurant.dbrestaurant.Clients;
import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.models.ClientsModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientsController {

    @FXML
    private Button addButton;
    @FXML
    private Button backField;
    @FXML
    private TextField clientsName;
    @FXML
    private TextField clientsAddress;
    @FXML
    private TextField clientsTaxId;
    @FXML
    private TextField clientsId;
    @FXML
    private TableView<Clients> clientsTable;
    @FXML
    private TableColumn<Clients, String> clientsNameColumn;
    @FXML
    private TableColumn<Clients, String> clientsAddressColumn;
    @FXML
    private TableColumn<Clients, Integer> clientsIdColumn;
    @FXML
    private TableColumn<Clients, String> clientsTaxIdColumn;
    @FXML
    private Button updateButton;

    public Button getUpdateButton() {
        return updateButton;
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

    public TextField getClientsName() {
        return clientsName;
    }

    public void setClientsName(TextField clientsName) {
        this.clientsName = clientsName;
    }

    public TextField getClientsAddress() {
        return clientsAddress;
    }

    public void setClientsAddress(TextField clientsAddress) {
        this.clientsAddress = clientsAddress;
    }

    public TextField getClientsTaxId() {
        return clientsTaxId;
    }

    public void setClientsTaxId(TextField clientsTaxId) {
        this.clientsTaxId = clientsTaxId;
    }

    public TextField getClientsId() {
        return clientsId;
    }

    public void setClientsId(TextField clientsId) {
        this.clientsId = clientsId;
    }

    public TableView<Clients> getClientsTable() {
        return clientsTable;
    }

    public void setClientsTable(TableView<Clients> clientsTable) {
        this.clientsTable = clientsTable;
    }

    public TableColumn<Clients, String> getClientsNameColumn() {
        return clientsNameColumn;
    }

    public void setClientsNameColumn(TableColumn<Clients, String> clientsNameColumn) {
        this.clientsNameColumn = clientsNameColumn;
    }

    public TableColumn<Clients, String> getClientsAddressColumn() {
        return clientsAddressColumn;
    }

    public void setClientsAddressColumn(TableColumn<Clients, String> clientsAddressColumn) {
        this.clientsAddressColumn = clientsAddressColumn;
    }

    public TableColumn<Clients, Integer> getClientsIdColumn() {
        return clientsIdColumn;
    }

    public void setClientsIdColumn(TableColumn<Clients, Integer> clientsIdColumn) {
        this.clientsIdColumn = clientsIdColumn;
    }

    public TableColumn<Clients, String> getClientsTaxIdColumn() {
        return clientsTaxIdColumn;
    }

    public void setClientsTaxIdColumn(TableColumn<Clients, String> clientsTaxIdColumn) {
        this.clientsTaxIdColumn = clientsTaxIdColumn;
    }

    public ClientsModel getClientsModel() {
        return clientsModel;
    }

    public void setClientsModel(ClientsModel clientsModel) {
        this.clientsModel = clientsModel;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }

    private ClientsModel clientsModel = new ClientsModel();

    @FXML
    void addClients(ActionEvent event) throws ClassNotFoundException, SQLException {
        clientsModel.addClient(clientsName.getText(), clientsAddress.getText(), clientsTaxId.getText());
    }

    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        clientsModel.switchToMenuScene(event);
    }
    int index = -1;
    Connection connection;

    @FXML
    void getSelected(MouseEvent event) throws IOException {
        index = clientsTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
       clientsId.setText(clientsIdColumn.getCellData(index).toString());
       clientsName.setText(clientsNameColumn.getCellData(index));
       clientsAddress.setText(clientsAddressColumn.getCellData(index));
       clientsTaxId.setText(clientsTaxIdColumn.getCellData(index));
    }
    public void updateClients() throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String value1 = clientsId.getText();
        String value2 = clientsName.getText();
        String value3 = clientsAddress.getText();
        String value4 = clientsTaxId.getText();

        String sql = "UPDATE clients SET client_id = '"+value1+"', name = '"+value2+"', address = '"+value3+
                "', tax_id = '"+value4+"' WHERE client_id = '"+value1+"' ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.execute();

    }

    @FXML
    void initialize() {
        clientsIdColumn.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        clientsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientsAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        clientsTaxIdColumn.setCellValueFactory(new PropertyValueFactory<>("tax_id"));
        try {
            ObservableList<Clients> clientsList = clientsModel.getClientsList();
            clientsTable.setItems(clientsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
