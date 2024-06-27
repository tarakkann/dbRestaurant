package dbrestaurant.dbrestaurant.models;

import dbrestaurant.dbrestaurant.HelloApplication;
import dbrestaurant.dbrestaurant.SingleWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RegistrationWaiterModel {
    private Stage stage;
    private Scene scene;

    private Connection connection;
    private PreparedStatement preparedStatement;

    public RegistrationWaiterModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restaurant",
                    "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToHomeScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("seperateroles.fxml"));
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

    public boolean createReg(String name, String address, String phone) {
        if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            showAlert("Validation Error", "Все поля должны быть заполнены");
            return false;
        }

        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO waiters (name, address, phone_number) VALUES (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("SELECT id FROM waiters WHERE name = ? AND phone_number = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int waiterId = resultSet.getInt("id");
                SingleWrapper.getInstance().setId(waiterId);
            }
            return true; // Return true to indicate success
        } catch (SQLException e) {
            System.out.println("Ошибка" + e.getMessage());
            return false; // Return false to indicate SQL error
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
