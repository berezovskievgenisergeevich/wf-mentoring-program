package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.urils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDB {
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void executeSql(String sql) throws SQLException {
        statement.execute(sql);
        System.out.println(sql + " - SUCCESS");
    }
}
