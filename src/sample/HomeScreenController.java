package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.events.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeScreenController {

    @FXML
    private ImageView addPolicyButton;
    public void addPolicy() {

        Stage addPolicyScreen = new Stage();
        Parent root = null;

        try {
            root = (Parent) FXMLLoader.load(getClass().getResource("AddStandardPolicyScreen.fxml"));
        }
        catch (Exception e) {
            Logger.getLogger(AddStandardPolicyScreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        Stage current = (Stage) addPolicyButton.getScene().getWindow();
        Scene scene = new Scene (root,1360,730);
        addPolicyScreen.setScene(scene);
        addPolicyScreen.initStyle(StageStyle.TRANSPARENT);

        current.hide();

        addPolicyScreen.show();

    }
    @FXML
    private ImageView listPoliciesButton;
    public void listPolicies() {

        Stage ListPoliciesScreen = new Stage();
        Parent root = null;

        try {
            root = (Parent) FXMLLoader.load(getClass().getResource("ListPoliciesScreen.fxml"));
        }
        catch (Exception e) {
            Logger.getLogger(AddStandardPolicyScreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        Stage current = (Stage) listPoliciesButton.getScene().getWindow();
        Scene scene = new Scene (root,1360,730);
        ListPoliciesScreen.setScene(scene);
        ListPoliciesScreen.initStyle(StageStyle.TRANSPARENT);

        current.hide();

        ListPoliciesScreen.show();

    }

    @FXML
    private ImageView twoWeeksPoliciesListButton;

    public void twoWeekstListPolicies() {

        Stage twoWeeksListPoliciesScreen = new Stage();
        Parent root = null;

        try {
            root = (Parent) FXMLLoader.load(getClass().getResource("TwoWeeksPolicyScreen.fxml"));
        }
        catch (Exception e) {
            Logger.getLogger(AddStandardPolicyScreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        Stage current = (Stage) twoWeeksPoliciesListButton.getScene().getWindow();
        Scene scene = new Scene (root,1360,730);
        twoWeeksListPoliciesScreen.setScene(scene);
        twoWeeksListPoliciesScreen.initStyle(StageStyle.TRANSPARENT);

        current.hide();

       twoWeeksListPoliciesScreen.show();

    }
    @FXML
    public void closeApp(javafx.scene.input.MouseEvent mouseEvent) {
        Platform.exit();
    }

}
