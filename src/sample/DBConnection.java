package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static DBConnection instance = null;
    public final String databaseName = "management";
    public final String tableNamePolicies = "policies";
    public final String tableNameCars = "cars";
    public final String tableName = "users";
    public  final String user = "root";
    public final String password = "test123";
    public Connection connection;


    private DBConnection() {
        init();
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }


    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
            System.out.println("Conneted database " + databaseName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
