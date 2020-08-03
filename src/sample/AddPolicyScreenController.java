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

public class AddPolicyScreenController {
DBConnection dbConnection = DBConnection.getInstance();
    @FXML
    TextField nrPolicy;
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
        String query = "INSERT INTO " + dbConnection.tableName + "(nrPolicy, typePolicy, startDatePolicy, endDatePolicy) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = dbConnection.connection.prepareStatement(query);
            preparedStatement.setString(1,nrPolicy.getText().toString().trim());
            preparedStatement.setString(2,typePolicy.getValue().toString().trim());
            preparedStatement.setString(3,startDatePolicy.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            preparedStatement.setString(4,endDatePolicy.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

    @FXML
    public void returnMenu(javafx.scene.input.MouseEvent mouseEvent) {
        Stage manageScreen = new Stage();
        Parent root = null;
        try {
            root = (Parent) FXMLLoader.load(getClass().getResource("ManageScreen.fxml"));
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
