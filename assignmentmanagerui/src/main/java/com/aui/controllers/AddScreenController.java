package com.aui.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.aui.appfolder.App;
import com.aui.model.Assignment;
import com.aui.model.AssignmentManager;
import com.aui.model.DataManager;
import com.aui.model.User;
import com.aui.model.UserList;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class AddScreenController implements Initializable {

    @FXML
    private Label addedAlert;

    @FXML
    private FontAwesomeIconView backButtonEdit;

    @FXML
    private DatePicker calendarBox;

    @FXML
    private Button confirmButton;

    @FXML
    private TextArea descriptionText;

    @FXML
    private TextField nameText;

    private AssignmentManager library;
    private User currUser;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        library = AssignmentManager.getInstance();   
        currUser = library.getCurrentUser();
        addedAlert.setVisible(false);
    }


    @FXML
    void confirm(ActionEvent e) {
        String name = "No Name";
        String description = "No Description";

        LocalDate today = LocalDate.now();
        LocalDate selectedDate = calendarBox.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        String date = today.format(formatter);
        
        if(!(nameText.getText().trim().isEmpty())) {
            name = nameText.getText();
        }
        if(!(descriptionText.getText().trim().isEmpty())) {
            description = descriptionText.getText();
        }
        if(!(selectedDate == null)) {
            date = selectedDate.format(formatter);
        }

        Assignment a = new Assignment(name, description, date);
        currUser.addAssignment(a);
        playAnimation();
        DataManager.saveUsers();
    }

    @FXML
    void backButton(MouseEvent event) throws IOException{
        App.setRoot("taskManagerHome");
    }

    private void playAnimation() {
        FadeTransition fadeInAnimation = new FadeTransition(Duration.millis(2000), addedAlert);
        fadeInAnimation.setFromValue(0);
        fadeInAnimation.setToValue(1);
        FadeTransition fadeOutAnimation = new FadeTransition(Duration.millis(2000), addedAlert);
        fadeOutAnimation.setFromValue(1);
        fadeInAnimation.setToValue(0);
        SequentialTransition fade = new SequentialTransition(addedAlert, fadeInAnimation, fadeOutAnimation);
        addedAlert.setVisible(true);
        fade.play();
    }

    

}
