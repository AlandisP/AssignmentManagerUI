module com.aui.appfolder {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires javafx.graphics;
    requires javafx.base;
    requires de.jensd.fx.glyphs.fontawesome;
    

    opens com.aui.appfolder to javafx.fxml;
    exports com.aui.appfolder;

    opens com.aui.controllers to javafx.fxml;

    exports com.aui.controllers;

    opens com.aui.model to javafx.fxml;

    exports com.aui.model;
}
