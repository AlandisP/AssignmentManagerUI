package com.aui.controllers;

import java.io.IOException;

import com.aui.appfolder.App;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}