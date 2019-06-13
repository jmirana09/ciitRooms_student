package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private ImageView dashboardProfileImageID;

    @FXML
    private Label dashboardNameID;

    @FXML
    private Label dashboardStudentNumberID;

    @FXML
    private JFXButton logoutBtnID;

    @FXML
    private JFXButton searchRoomBtnID;

    @FXML
    private JFXButton reservationBtnID;

    @FXML
    private JFXButton dashboardBtnID;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    void setName(String name) {
        dashboardNameID.setText(name);
    }
}
