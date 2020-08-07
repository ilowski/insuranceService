package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddStandardPolicyScreenController {
DBConnection dbConnection = DBConnection.getInstance();
    @FXML
    TextField nrPolicy;
    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField pesel;
    @FXML
    TextField address;
    @FXML
    ChoiceBox typePolicy;
    @FXML
    DatePicker startDatePolicy;
    @FXML
    DatePicker endDatePolicy;

    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void addPolicy(javafx.scene.input.MouseEvent mouseEvent) {
        String query = "INSERT INTO " + dbConnection.tableNamePolicies + "(nrPolicy, name, surname, pesel, address, typePolicy, startDatePolicy, endDatePolicy) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = dbConnection.connection.prepareStatement(query);
            preparedStatement.setString(1,nrPolicy.getText().toString().trim());
            preparedStatement.setString(2,name.getText().toString().trim());
            preparedStatement.setString(3,surname.getText().toString().trim());
            preparedStatement.setString(4,pesel.getText().toString().trim());
            preparedStatement.setString(5,address.getText().toString().trim());
            preparedStatement.setString(6,typePolicy.getValue().toString().trim());
            preparedStatement.setString(7,startDatePolicy.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            preparedStatement.setString(8,endDatePolicy.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

    @FXML
    public void getTypePolicy() {
        if (typePolicy.getValue().toString().trim().equals("Samochodu")) {
            Stage manageScreen = new Stage();
            Parent root = null;
            try {
                root = (Parent) FXMLLoader.load(getClass().getResource("AddCarPolicyScreen.fxml"));
            } catch (Exception e) {
                Logger.getLogger(LoginSreenController.class.getName()).log(Level.SEVERE, null, e);
            }
            Stage current = (Stage) nrPolicy.getScene().getWindow();
            Scene scene = new Scene(root, 1360, 730);
            manageScreen.setScene(scene);
            manageScreen.initStyle(StageStyle.TRANSPARENT);

            current.hide();
            manageScreen.show();
        }
    }
    @FXML
    public void returnMenu(javafx.scene.input.MouseEvent mouseEvent) {
        Stage homeScreen = new Stage();
        Parent root = null;
        try {
            root = (Parent) FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (Exception e) {
            Logger.getLogger(LoginSreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        Stage current = (Stage) nrPolicy.getScene().getWindow();
        Scene scene = new Scene(root, 1360, 730);
        homeScreen.setScene(scene);
        homeScreen.initStyle(StageStyle.TRANSPARENT);

        current.hide();
        homeScreen.show();
    }
}
