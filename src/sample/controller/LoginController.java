package sample.controller;

import javafx.application.Application;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField usernameID;

    @FXML
    private JFXPasswordField passwordID;

    @FXML
    private JFXButton loginBtnID;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginBtnID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginUser();
            }
        });


    }

    private void loginUser() {



        if(!usernameID.getText().toString().trim().equals("") && !passwordID.getText().toString().trim().equals("")) {
            loginBtnID.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/dashboard.fxml"));
            try {
                loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage dashboardStage = new Stage();
            Parent root = loader.getRoot();

            dashboardStage.setScene(new Scene(root));

            DashboardController dashboardController = loader.getController();
            dashboardController.setName(usernameID.getText());

            dashboardStage.show();
            dashboardStage.setResizable(false);


        }

    }
}
