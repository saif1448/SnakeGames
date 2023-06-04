module com.example.snakefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.snakefx to javafx.fxml;
    exports com.example.snakefx;
    exports com.example.snakefx.controllers;
    opens com.example.snakefx.controllers to javafx.fxml;
    exports com.example.snakefx.Handlers;
    opens com.example.snakefx.Handlers to javafx.fxml;
}