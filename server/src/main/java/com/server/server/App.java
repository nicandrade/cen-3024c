package com.server.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 300);
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.show();


        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Socket socket = serverSocket.accept();

                InputStreamReader in = new InputStreamReader(socket.getInputStream());
                BufferedReader bf = new BufferedReader(in);

                int value = Integer.parseInt(bf.readLine());
                System.out.println("Value Sent: " + value);

                String response = "";

                if (value % 2 == 0){
                    response = "not prime.";
                }else {
                    response = "prime";
                }

                Controller controller = fxmlLoader.getController();
                controller.addText("Number received from client to check prime number is: " + value + "\n");

                PrintWriter pr = new PrintWriter(socket.getOutputStream());
                pr.println(response);
                pr.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }


    public static void main(String[] args) {
        launch();
    }
}