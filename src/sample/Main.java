package sample;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.helper.DBHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {

    static private DBHandler dbHandler;
    static private Connection connection;
    static private JdbcPreparedStatement preparedStatement;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 630, 380));
        primaryStage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch(args);

        dbHandler = new DBHandler();
        connection = dbHandler.getDbConnection();

       //updateDB("Joe","Mirana", "joebend","ciit123!", 1);
        deleteUserFromDB(2);
    }


    private static void writeToDB() throws SQLException {
        String insert = "INSERT INTO users(firstname, lastname, username, password) " +
                "VALUES (?,?,?,?)";

        preparedStatement = (JdbcPreparedStatement) connection.prepareStatement(insert);
        preparedStatement.setString(1, "Chin");
        preparedStatement.setString(2, "Paez");
        preparedStatement.setString(3, "17171234");
        preparedStatement.setString(4, "test123!");
        preparedStatement.executeUpdate();

    }

    private static void readToDB() throws SQLException {

        String query = "SELECT * FROM users";

        JdbcPreparedStatement preparedStatement = (JdbcPreparedStatement) connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            System.out.println("Name: " + resultSet.getString("firstname") + " "
                    + resultSet.getString("lastname") );
        }

    }

    private static void updateDB(String firstName, String lastName, String username, String password, int userid)
            throws SQLException {

        String query = "UPDATE users SET firstname = ?, lastname = ?, username = ?, password = ? WHERE userid = ?";

        JdbcPreparedStatement preparedStatement = (JdbcPreparedStatement) connection.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, username);
        preparedStatement.setString(4, password);
        preparedStatement.setInt(5, userid);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    private static void deleteUserFromDB(int userid) throws SQLException {
        String query = "DELETE FROM users WHERE userid = ?";

        JdbcPreparedStatement preparedStatement = (JdbcPreparedStatement) connection.prepareStatement(query);
        preparedStatement.setInt(1, userid);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}

interface Drawable {
    public void draw();
}