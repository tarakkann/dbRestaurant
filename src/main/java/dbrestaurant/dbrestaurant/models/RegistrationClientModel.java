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

public class RegistrationClientModel {
    private Stage stage;
    private Scene scene;

    private Connection connection;
    private PreparedStatement preparedStatement;

    public RegistrationClientModel() {
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

    public void switchToMenuClientScene(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuClient.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public boolean createReg(String taxId, String name, String address) {
        if (taxId.isEmpty() || name.isEmpty() || address.isEmpty()) {
            showAlert("Error", "Все поля должны быть заполнены");
            return false;
        }

        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO clients (tax_id, name, address) VALUES (?,?,?)");
            preparedStatement.setString(1, taxId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, address);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT id FROM clients WHERE tax_id = ?");
            preparedStatement.setString(1, taxId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int clientId = resultSet.getInt("id");
                SingleWrapper.getInstance().setId(clientId);
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Ошибка" + e.getMessage());
            return false;
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
