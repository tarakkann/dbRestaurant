package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationModel {
    private Scene scene;
    private Stage stage;

    public void switchToHomeScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMenuScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


    PreparedStatement preparedStatement;
    Connection connection;

    public RegistrationModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restaurant",
                    "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createReg(String name, String phone, String address) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO waiters (name, address, phone_number) VALUES (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, address);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
