package com.epam.jdbcIntro.homework.task3.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public int id;
    public String name;
    public String surname;
    public String birthDate;

    public User(String name, String surname, String birthDate) {
        id = -1;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public User(int id, String name, String surname, String birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public User(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt(1);
        name = resultSet.getString(2);
        surname = resultSet.getString(3);
        birthDate = resultSet.getString(4);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
