package com.ironyard.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbService {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "admin";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}