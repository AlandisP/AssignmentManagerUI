package com.aui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.aui.appfolder.App;
import com.aui.model.Assignment;
import com.aui.model.AssignmentManager;
import com.aui.model.DataManager;
import com.aui.model.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TaskManagerHome implements Initializable {

    @FXML
    private Button addTaskButton;

    @FXML
    private Button deleteTaskButton;

    @FXML
    private Button editTaskButton;

    @FXML
    private Label userLabel;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private TableView<Assignment> taskTable;

    @FXML
    private TableColumn<Assignment, String> nameColumn;

    @FXML
    private TableColumn<Assignment, String> descriptionColumn;

    @FXML
    private TableColumn<Assignment, String> dateColumn;

    @FXML
    private TableColumn<Assignment, Boolean> completionColumn;

    private AssignmentManager library;
    private User currUser;

    //Inits. all objects and objects used in scene builder. Displays user information too.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        library = AssignmentManager.getInstance();
        currUser = library.getCurrentUser();
        userLabel.setText(currUser.getUsername());

        nameColumn.setCellValueFactory(new PropertyValueFactory<Assignment, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Assignment, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Assignment, String>("displayDate"));
        completionColumn.setCellValueFactory(new PropertyValueFactory<Assignment, Boolean>("isCompleted"));

        taskTable.setItems(getTasks());
        progressIndicator.setProgress(currUser.getProgressPercentage());
    }
    //gets the tasks for the tableview
    public ObservableList<Assignment> getTasks() {
        ObservableList<Assignment> tasks = FXCollections.observableArrayList();

        ArrayList<Assignment> tasksList = currUser.getAssignments();
        for(int i = 0; i < tasksList.size(); i++) {
            tasks.add(tasksList.get(i));
        }


        return tasks;   
    }
    //deletes the task. 
    @FXML
    void deleteTask(ActionEvent e) {
        Assignment selectedA = taskTable.getSelectionModel().getSelectedItem();
        if (selectedA != null) {
            currUser.deleteAssignment(selectedA);

            taskTable.getItems().clear();
            taskTable.setItems(getTasks());


            DataManager.saveUsers();
            updateProgress();
        }
    }
    //sends you to the edit task screen with the selected task
    //may be some bugs.
    @FXML
    void editTask(ActionEvent e) throws IOException {
        Assignment selectedAssignment = taskTable.getSelectionModel().getSelectedItem();
         if (selectedAssignment != null) {
            currUser.changeCurrentAssignment(selectedAssignment);    
            App.setRoot("editScreen");     
         }
         
    }
    //sends you to the add task screen
    @FXML
    void addTask(ActionEvent e) throws IOException {
        App.setRoot("addScreen");
    }
    //updates the progress percentage to show
    private void updateProgress() {
        progressIndicator.setProgress(currUser.getProgressPercentage());
    }
    //logs the user out.
    @FXML
    void logout(ActionEvent e) throws IOException {
        library.logout();
        App.setRoot("loginScreen");

    }



}
