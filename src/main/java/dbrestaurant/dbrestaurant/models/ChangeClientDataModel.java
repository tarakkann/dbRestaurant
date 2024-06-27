package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.DataConnection;
import dbrestaurant.dbrestaurant.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeClientDataModel {
    private Stage stage;
    private Scene scene;

    public void switchToClientMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuClient.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void changeData(Integer id, String tax_id, String name, String address) throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.getDBConnection();
        String sql = "UPDATE clients SET tax_id = ?, name = ?, address = ? WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, tax_id);
        pst.setString(2, name);
        pst.setString(3, address);
        pst.setInt(4, id);
        pst.execute();
        pst.close();
        connection.close();
    }
}
