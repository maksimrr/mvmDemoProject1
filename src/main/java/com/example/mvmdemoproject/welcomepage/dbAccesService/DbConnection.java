package com.example.mvmdemoproject.welcomepage.dbAccesService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Утильный класс, создающий подключение к базе данных MariaDB
 */

public class DbConnection {
    private static final String USER = "mmbin";
    private static final String PASSWORD = "123";
    private static final String URL= "jdbc:mariadb://localhost:3306";

    public static Connection open() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }}
