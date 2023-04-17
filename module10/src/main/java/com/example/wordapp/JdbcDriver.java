package com.example.wordapp;

import java.sql.*;

public class JdbcDriver {

    public static void main(String[] args) throws ClassNotFoundException {

        String url      = "jdbc:mysql://localhost:3306/word_occurences";   //database specific url.
        String user     = "root";
        String password = "FMSE5NqtyJ3nPXbx";

        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from word");

            while(resultSet.next()){
                System.out.println(resultSet.getString("word"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}