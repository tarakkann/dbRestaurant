package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.DishComposition;
import dbrestaurant.dbrestaurant.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DishCompositionClientModel {
    private Stage stage;
    private Scene scene;

    public void switchToClientMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuClient.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(TableColumn<DishComposition, Integer> dishIdColumn,
                                               TableColumn<DishComposition, Integer> ingredientIdColumn,
                                               TableColumn<DishComposition, Double> quantityColumn) {
        dishIdColumn.setCellValueFactory(new PropertyValueFactory<>("dish_id"));
        ingredientIdColumn.setCellValueFactory(new PropertyValueFactory<>("ingredient_id"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }
}

