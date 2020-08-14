package sample;

import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListPoliciesScreenController {
    DBConnection dbConnection = DBConnection.getInstance();
    @FXML
    TextField surnameTextField;
    @FXML
    DatePicker startDate;
    @FXML
    DatePicker endDate;
    @FXML
    TextField registrationNrTextField;

    @FXML
    Button backButton;

    @FXML
    private TreeTableView<CarPolicy> treeView;

    public void loadPoliciesByQuery(String sqlQuery) {

        TreeTableColumn<CarPolicy,String> carPolicyRegistrationNr = new TreeTableColumn<>("Numer rejestracyjny");
        carPolicyRegistrationNr.setPrefWidth(100);
        carPolicyRegistrationNr.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().registrationNr;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyNrPolicy = new TreeTableColumn<>("Numer polisy");
        carPolicyNrPolicy.setPrefWidth(100);
        carPolicyNrPolicy.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().nrPolicy;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyName = new TreeTableColumn<>("Imie");
        carPolicyName.setPrefWidth(100);
        carPolicyName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().name;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicySurname = new TreeTableColumn<>("Nazwisko");
        carPolicySurname.setPrefWidth(100);
        carPolicySurname.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().surname;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyPesel = new TreeTableColumn<>("Pesel");
        carPolicyPesel.setPrefWidth(100);
        carPolicyPesel.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().pesel;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyAddress = new TreeTableColumn<>("adres");
        carPolicyAddress.setPrefWidth(150);
        carPolicyAddress.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().address;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyStartDatePolicy = new TreeTableColumn<>("Data założenia polisy");
        carPolicyStartDatePolicy.setPrefWidth(100);
        carPolicyStartDatePolicy.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().startDatePolicy;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyEndDatePolicy = new TreeTableColumn<>("Data końca polisy");
        carPolicyEndDatePolicy.setPrefWidth(100);
        carPolicyEndDatePolicy.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().endDatePolicy;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyModel = new TreeTableColumn<>("Model");
        carPolicyModel.setPrefWidth(100);
        carPolicyModel.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().model;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyMark = new TreeTableColumn<>("Marka");
        carPolicyMark.setPrefWidth(100);
        carPolicyMark.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().mark;
            }
        });

        TreeTableColumn<CarPolicy,String> carPolicyTypePolicy = new TreeTableColumn<>("typ polisy");
        carPolicyTypePolicy.setPrefWidth(100);
        carPolicyTypePolicy.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CarPolicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CarPolicy, String> carPolicyStringCellDataFeatures) {
                return carPolicyStringCellDataFeatures.getValue().getValue().typePolicy;
            }
        });
        ObservableList<CarPolicy> carPolicies = FXCollections.observableArrayList();
        Connection connection = dbConnection.connection;
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                carPolicies.add(new CarPolicy(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        final TreeItem<CarPolicy> root = new RecursiveTreeItem<CarPolicy>(carPolicies, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(carPolicyRegistrationNr, carPolicyNrPolicy, carPolicyName, carPolicySurname, carPolicyPesel, carPolicyAddress, carPolicyStartDatePolicy, carPolicyEndDatePolicy, carPolicyModel, carPolicyMark, carPolicyTypePolicy);
        treeView.setRoot(root);
        treeView.setShowRoot(false);


    }


    public void loadPoliciesBySurname(MouseEvent mouseEvent) {
        loadPoliciesByQuery("SELECT registrationnr, policies.nrpolicy, name, surname, pesel, address, startdatepolicy, enddatepolicy, model, mark, typepolicy FROM policies, cars WHERE surname='" + surnameTextField.getText().toString().trim()+"' AND policies.nrpolicy=cars.nrpolicy;");
    }

    public void loadPoliciesByDate(MouseEvent mouseEvent) {
        loadPoliciesByQuery("SELECT registrationnr, policies.nrpolicy, name, surname, pesel, address, startdatepolicy, enddatepolicy, model, mark, typepolicy FROM policies, cars WHERE startDatePolicy >= '" + startDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +"' AND endDatePolicy <= '" + endDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+ "' AND policies.nrpolicy=cars.nrpolicy;");
    }
    public void loadPoliciesByRegistrationNr(MouseEvent mouseEvent) {
        loadPoliciesByQuery("SELECT registrationnr, policies.nrpolicy, name, surname, pesel, address, startdatepolicy, enddatepolicy, model, mark, typepolicy FROM policies, cars WHERE registrationnr='" + registrationNrTextField.getText().toString().trim() + "' AND policies.nrpolicy=cars.nrpolicy;");

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
        Stage current = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(root, 1360, 730);
        homeScreen.setScene(scene);
        homeScreen.initStyle(StageStyle.TRANSPARENT);

        current.hide();
        homeScreen.show();
    }
}
