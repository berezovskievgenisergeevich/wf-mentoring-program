package com.epam.jdbcIntro.homework.task1;

import java.sql.*;
import java.util.Properties;

public class MyFirstConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/wf_mentoring";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        printAllTables(connection);

    }

    private static void printAllTables(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet rs = metaData.getTables(null, null, "%", null)) {
            ResultSetMetaData rsMeta = rs.getMetaData();
            while (rs.next()) {
                System.out.println("Table name is:" + rs.getString("TABLE_NAME"));
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER_NAME);
        props.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, props);
    }

    private static Connection getConnection(String url, String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }


}
