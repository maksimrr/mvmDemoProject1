package com.example.mvmdemoproject.welcomepage.dbAccesService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 Класс, используемые для инициализации базы данных онлайн-библиотеки с таблицей PERSON
 */


public class DbInitializer {
    public static void initDb(){
        String createDB = "CREATE DATABASE LIBRARY;";
            String initializeDB = """
                    CREATE TABLE LIBRARY.PERSON(person_id int auto_increment,
                    first_name varchar(40),
                    last_name varchar(40),
                 birthday varchar(30),
                 phone_number varchar(20),
                email varchar(60),
                adress varchar(50),
                PRIMARY KEY(person_id));
            """;

            try (Connection connection = DbConnection.open();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(createDB);
                statement.executeUpdate(initializeDB);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public static void main(String[] args) {
        initDb();}
    }

