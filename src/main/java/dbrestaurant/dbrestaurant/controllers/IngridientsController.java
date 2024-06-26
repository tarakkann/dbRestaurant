package dbrestaurant.dbrestaurant.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.Ingridients;
import dbrestaurant.dbrestaurant.models.IngridientsModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class IngridientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<Ingridients> IngridientTable;

    @FXML
    private Button addButton;

    @FXML
    private Button backField;

    @FXML
    private TextField ingridientId;
    @FXML
    private TableColumn<Ingridients, Integer> ingridientIdColumn;

    @FXML
    private TextField ingridientName;

    @FXML
    private TableColumn<Ingridients, String> ingridientNameColumn;

    @FXML
    private TextField ingridientQuantity;

    @FXML
    private TableColumn<Ingridients, Double> ingridientQuantityColumn;

    @FXML
    private TextField ingridientUnit;

    @FXML
    private TableColumn<Ingridients, String> ingridientUnitColumn;
    IngridientsModel ingridientsModel = new IngridientsModel();
    Connection connection = null;
    PreparedStatement pst = null;

    ObservableList<Ingridients> ingridientsList;

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

    public TableView<Ingridients> getIngridientTable() {
        return IngridientTable;
    }

    public void setIngridientTable(TableView<Ingridients> ingridientTable) {
        ingridientTable = ingridientTable;
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

    public TableColumn<Ingridients, Integer> getIngridientIdColumn() {
        return ingridientIdColumn;
    }

    public void setIngridientId(TableColumn<Ingridients, Integer> ingridientId) {
        this.ingridientIdColumn = ingridientIdColumn;
    }

    public TextField getIngridientName() {
        return ingridientName;
    }

    public void setIngridientName(TextField ingridientName) {
        this.ingridientName = ingridientName;
    }

    public TableColumn<Ingridients, String> getIngridientNameColumn() {
        return ingridientNameColumn;
    }

    public void setIngridientNameColumn(TableColumn<Ingridients, String> ingridientNameColumn) {
        this.ingridientNameColumn = ingridientNameColumn;
    }

    public TextField getIngridientQuantity() {
        return ingridientQuantity;
    }

    public void setIngridientQuantity(TextField ingridientQuantity) {
        this.ingridientQuantity = ingridientQuantity;
    }

    public TableColumn<Ingridients, Double> getIngridientQuantityColumn() {
        return ingridientQuantityColumn;
    }

    public void setIngridientQuantityColumn(TableColumn<Ingridients, Double> ingridientQuantityColumn) {
        this.ingridientQuantityColumn = ingridientQuantityColumn;
    }

    public TextField getIngridientUnit() {
        return ingridientUnit;
    }

    public void setIngridientUnit(TextField ingridientUnit) {
        this.ingridientUnit = ingridientUnit;
    }

    public TableColumn<Ingridients, String> getIngridientUnitColumn() {
        return ingridientUnitColumn;
    }

    public void setIngridientUnitColumn(TableColumn<Ingridients, String> ingridientUnitColumn) {
        this.ingridientUnitColumn = ingridientUnitColumn;
    }


    @FXML
    void switchToMenuScene(ActionEvent event) throws IOException {
        ingridientsModel.switchToMenuScene(event);
    }

    @FXML
    void initialize() {
        ingridientIdColumn.setCellValueFactory(new PropertyValueFactory<>("ingredient_id"));
        ingridientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ingridientUnitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        ingridientQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        try {
            ingridientsList = DataConnection.getIngridient();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        IngridientTable.setItems(ingridientsList);
    }

    @FXML
    void addIngridient() throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String sql = "INSERT INTO INGRIDIENTS (name, unit, quantity) VALUES (?, ?, ?)";
        pst = connection.prepareStatement(sql);
        pst.setString(1, ingridientName.getText());
        pst.setString(2, ingridientUnit.getText());
        pst.setString(3, ingridientQuantity.getText());
        pst.executeUpdate();
    }
    int index = -1;
    @FXML
    void updateIngridients(ActionEvent event) throws SQLException, ClassNotFoundException {
        connection = DataConnection.getDBConnection();
        String value1 = ingridientId.getText();
        String value2 = ingridientName.getText();
        String value3 = ingridientUnit.getText();
        String value4 = ingridientQuantity.getText();


        String sql = "UPDATE ingridients SET id = '"+value1+"', name = '"+value2+"'," +
                " unit = '"+value3+"', quantity = '"+value4+
                "' WHERE id = '"+value1+"' ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.execute();
    }
    @FXML
    void getSelected(MouseEvent event) throws IOException {
        index = IngridientTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        ingridientId.setText(ingridientIdColumn.getCellData(index).toString());
        ingridientName.setText(ingridientNameColumn.getCellData(index));
        ingridientUnit.setText(ingridientUnitColumn.getCellData(index));
        ingridientQuantity.setText(ingridientQuantityColumn.getCellData(index).toString());
    }


}
