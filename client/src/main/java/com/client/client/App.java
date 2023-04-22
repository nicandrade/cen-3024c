package com.client.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class App extends Application {

    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    public App() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 400);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }

}