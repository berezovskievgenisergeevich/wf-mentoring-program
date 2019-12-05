package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task1.MyFirstConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        return MyFirstConnection.getConnection();
    }
}
