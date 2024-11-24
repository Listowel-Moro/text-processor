module listo.textprocessor {
    requires javafx.controls;
    requires javafx.fxml;


    opens listo.textprocessor to javafx.fxml;
    exports listo.textprocessor;
}