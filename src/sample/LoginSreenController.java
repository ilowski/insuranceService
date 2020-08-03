package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginSreenController {
    DBConnection dbConnection = DBConnection.getInstance();
    @FXML
    private TextField login;
    @FXML
    private TextField password;



    public void initialize(URL url, ResourceBundle rb) {

    }


    @FXML
    public void loginButton(javafx.scene.input.MouseEvent mouseEvent) {

/*
        if (login.getText().toString().equals("")) {
            Notifications notification =  Notifications.create()
                    .title("error")
                    .text("podaj login")
                    .graphic(null)
                    .hideAfter(Duration.seconds(4))
                    .position(Pos.BOTTOM_LEFT);
            notification.show();
        } else if (password.getText().toString().equals("")) {
            Notifications notification =  Notifications.create()
                    .title("error")
                    .text("podaj haslo")
                    .graphic(null)
                    .hideAfter(Duration.seconds(4))
                    .position(Pos.BOTTOM_LEFT);
            notification.show();

     */
            boolean isExist = false;
            String userPass = "";
            String query = "SELECT * FROM " + dbConnection.tableName + " WHERE login='" + login.getText().toString().trim() + "'";
            Statement statement = null;

            try {
                statement = dbConnection.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    isExist = true;
                    userPass = resultSet.getString("password");

                }

                if (isExist) {

                    if (password.getText().toString().trim().equals(userPass)) {
                        Stage manageScreen = new Stage();
                        Parent root = null;
                        try {
                            root = (Parent) FXMLLoader.load(getClass().getResource("ManageScreen.fxml"));
                        } catch (Exception e) {
                            Logger.getLogger(LoginSreenController.class.getName()).log(Level.SEVERE, null, e);
                        }
                        Stage current = (Stage) login.getScene().getWindow();
                        Scene scene = new Scene(root, 1360, 730);
                        manageScreen.setScene(scene);
                        manageScreen.initStyle(StageStyle.TRANSPARENT);

                        current.hide();
                        manageScreen.show();
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }







