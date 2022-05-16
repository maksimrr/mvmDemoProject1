package com.example.mvmdemoproject.welcomepage.dbAccesService;


/*
 Класс, инкапсулирующий данные пользователя, полученные из HTML-форм
 */

public class Person {
    private final String firstName;
    private final String lastName;

    private final String birthDate;

    private final String phoneNumber;

    private final String email;

    private final String adress;


    private Person(String firstName, String lastName, String birthDate,
                   String phoneNumber, String email, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

  public static Person getInstance(String firstName, String lastName, String birthDate,
                                   String phoneNumber, String email, String adress){
        return new Person(firstName, lastName,birthDate,phoneNumber,email,adress);
  }
}