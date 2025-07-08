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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class EditScreenController implements Initializable{

    @FXML
    private FontAwesomeIconView backButtonEdit;

    @FXML
    private DatePicker calendarBox;

    @FXML
    private ChoiceBox<String> completionBox;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea descriptionTB;

    @FXML
    private Label duedateLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label savedLabel;

    @FXML
    private TextField nameTB;

    @FXML
    private Label statusLabel;

    private AssignmentManager library;
    private User currUser;
    private Assignment currAssignment;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        library = AssignmentManager.getInstance();
        currUser = library.getCurrentUser();
        currAssignment = currUser.getCurrentAssignment();

        nameLabel.setText(currAssignment.getName());
        duedateLabel.setText(currAssignment.getDueDate());
        descriptionLabel.setText(currAssignment.getDescription());
        statusLabel.setText(currAssignment.getIsCompleted()?"True":"False");
        completionBox.setItems(FXCollections.observableArrayList("Yes", "No"));
        savedLabel.setVisible(false);   
    }

    @FXML
    void confirm(ActionEvent e) {

        LocalDate selectedDate = calendarBox.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        if(!(nameTB.getText().trim().isEmpty())) {
            currAssignment.setName(nameTB.getText());
        }
        if(!(descriptionTB.getText().trim().isEmpty())) {
            currAssignment.setDescription(descriptionTB.getText());
        }
        if(!(nameTB.getText().trim().isEmpty())) {
            currAssignment.setName(nameTB.getText());
        }
        if(!(selectedDate == null)) {
            currAssignment.setDueDate(selectedDate.format(formatter));
        }
        if(!(completionBox.getSelectionModel().isEmpty())) {
            String choice = completionBox.getValue();
            if(choice.equals("Yes") && currAssignment.getIsCompleted() == false) {
                currAssignment.changeCompletion();
            } else if(choice.equals("No") && currAssignment.getIsCompleted() == true) {
                currAssignment.changeCompletion();
            }
        }
        playAnimation(); 
        DataManager.saveUsers();
    }

    private void playAnimation() {
        FadeTransition fadeInAnimation = new FadeTransition(Duration.millis(2000), savedLabel);
        fadeInAnimation.setFromValue(0);
        fadeInAnimation.setToValue(1);
        FadeTransition fadeOutAnimation = new FadeTransition(Duration.millis(2000), savedLabel);
        fadeOutAnimation.setFromValue(1);
        fadeInAnimation.setToValue(0);
        SequentialTransition fade = new SequentialTransition(savedLabel, fadeInAnimation, fadeOutAnimation);
        savedLabel.setVisible(true);
        fade.play();
    }

    @FXML
    void backButton(MouseEvent e) throws IOException {
         App.setRoot("taskManagerHome");
    }
}
