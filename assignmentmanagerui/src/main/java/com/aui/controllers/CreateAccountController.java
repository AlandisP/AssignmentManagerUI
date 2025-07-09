package com.aui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.aui.appfolder.App;
import com.aui.model.AssignmentManager;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateAccountController implements Initializable{

    @FXML
    private FontAwesomeIconView backButton;

    @FXML
    private Button createAccountBtn;

    @FXML
    private Label errorMessage2;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private PasswordField passwordBox2;

    @FXML
    private TextField usernameBox;

    @FXML
    private Label usernameError;

    private AssignmentManager lib;
    //initializes the lib.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lib = AssignmentManager.getInstance();
    }

    @FXML
    void back(MouseEvent event) throws IOException{
        App.setRoot("loginScreen");
    }
    //creates a new account, but makes sure details are correct with simple logic
    @FXML
    void createAccount(ActionEvent event) throws IOException {
        String userName = usernameBox.getText();
        String passWord = passwordBox.getText();
        String passWord2 = passwordBox2.getText();

        if(lib.getUserList().findUserByName(userName)) {
            usernameError.setText("Username is already taken!");

        } else if(!(passWord.equals(passWord2))) {
            errorMessage2.setText("Passwords don't match!");
        } else {
            lib.createAccount(userName, passWord, passWord2);
            App.setRoot("taskManagerHome");
        }
    }

    

}
