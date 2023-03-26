module com.word.module6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.word.module7 to javafx.fxml;
    exports com.word.module7;
}