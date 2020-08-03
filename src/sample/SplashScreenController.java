package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;

import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {
    public ImageView image;

    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000), image);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage loginScreen = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
                } catch (Exception e) {

                }

                Stage current = (Stage) image.getScene().getWindow();
                Scene scene = new Scene (root,720,600);

                loginScreen.setScene(scene);
                loginScreen.initStyle(StageStyle.TRANSPARENT);
                current.hide();
                loginScreen.show();

            }
        });
        fadeTransition.play();
    }


}
