package com.server.server;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TextArea txtArea;

    public Controller() throws IOException {

    }

    public void addText(String value){
        txtArea.appendText(value);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Date currentDate = new Date();
        txtArea.setText("Server started at " + currentDate + "\n");

    }
}
