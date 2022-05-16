package com.example.mvmdemoproject.welcomepage.dbAccesService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    Класс, передающий SQL-запрос для создания записи в БД
 */
public class DbContentProcessing {

    public static void createUser(Person person) throws SQLException {
       String ppdStatement = "INSERT INTO LIBRARY.PERSON(first_name, last_name, birthday," +
               " phone_number, email, adress) VALUES (?,?,?,?,?,?)";
        try (Connection connection = DbConnection.open()){
            PreparedStatement PS1 = connection.prepareStatement(ppdStatement);
            PS1.setString(1, person.getFirstName());
            PS1.setString(2, person.getLastName());
            PS1.setString(3, person.getBirthDate());
            PS1.setString(4, person.getPhoneNumber());
            PS1.setString(5, person.getEmail());
            PS1.setString(6, person.getAdress());
            PS1.executeUpdate();
        }
    }
}
