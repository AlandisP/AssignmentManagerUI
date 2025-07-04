package com.aui.controllers;

import java.io.IOException;

import com.aui.appfolder.App;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
