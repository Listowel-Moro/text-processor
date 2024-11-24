module listo.textprocessor {
    requires javafx.controls;
    requires javafx.fxml;


    opens listo.textprocessor to javafx.fxml;
    //opens listo.textprocessor.controller to java.base;
    opens listo.textprocessor.controller to javafx.fxml;
    exports listo.textprocessor;
    exports listo.textprocessor.controller;
    exports listo.textprocessor.model;
}