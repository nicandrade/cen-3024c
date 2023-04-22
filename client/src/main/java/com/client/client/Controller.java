package com.client.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller {

    @FXML
    private Button btnCheck;

    @FXML
    private TextField txtNumberToCheck;

    @FXML
    private TextArea txtResponseField;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick(ActionEvent event) throws IOException {
        try {
            int numberValue = Integer.parseInt(txtNumberToCheck.getText());
            txtResponseField.appendText("Number is: " + numberValue + "\n");
            Socket socket = new Socket("localhost", 8000);
            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println(numberValue);
            pr.flush();

            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String result = bf.readLine();
            txtResponseField.appendText(numberValue + " is " + result + "\n");
            System.out.println(numberValue + " is " + result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}