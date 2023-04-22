module com.example.wordapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.wordapp to javafx.fxml;
    exports com.example.wordapp;
}