package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageScreenController {

    @FXML
    private ImageView addPolicyButton;
    public void addPolicy() {

        Stage addPolicyScreen = new Stage();
        Parent root = null;

        try {
            root = (Parent) FXMLLoader.load(getClass().getResource("AddPolicyScreen.fxml"));
        }
        catch (Exception e) {
            Logger.getLogger(AddPolicyScreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        Stage current = (Stage) addPolicyButton.getScene().getWindow();
        Scene scene = new Scene (root,1360,730);
        addPolicyScreen.setScene(scene);
        addPolicyScreen.initStyle(StageStyle.TRANSPARENT);

        current.hide();

        addPolicyScreen.show();

    }

}
