package com.aui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.aui.appfolder.App;
import com.aui.model.AssignmentManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController implements Initializable{

    @FXML
    private Button createAccountBtn;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private Label errorMessage;

    private AssignmentManager lib;
    //initializes the lib
    public void initialize(URL url, ResourceBundle rb) {
        lib = AssignmentManager.getInstance();
    }
    //makes sure details are correct when loggin in. It checks for errors as well.
    @FXML
    void login(ActionEvent e) throws IOException {
        String userName = usernameBox.getText();
        String passWord = passwordBox.getText();
        if(lib.login(userName, passWord)) {
            App.setRoot("taskManagerHome");
        } else {
            errorMessage.setText("Invalid Username/Password");
        }
    }

    @FXML
    void createAccount(ActionEvent e) throws IOException {
        App.setRoot("createAccountScreen");
    }
}

