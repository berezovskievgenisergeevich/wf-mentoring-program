package com.epam.jdbcIntro.lectures;

import java.io.File;
import java.sql.*;
import java.util.Properties;


/**
 * скачать mysql-installer-web-community-8.0.18.0
 * установить сервер (настроить )
 * установить workbanch
 * <p>
 * <p>
 * создать конекшен
 * jdbc:mysql://127.0.0.1:3306/wf_mentoring
 * wf_mentoring - имя базы данных на сервере(test)
 * root - креды к базе данных (test)
 */
public class TestConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/wf_mentoring";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        File file = new File("C:\\Windows\\System32\\cmd.exe");
  /*      Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world","root","root");*/
        Connection connection = getConnection();

        System.out.println(connection.getCatalog());
        System.out.println(connection.getTransactionIsolation());


   /*     Statement st = connection.createStatement();
        st.execute("CREATE TABLE IF NOT EXISTS user(id INT NULL)");
        ResultSet resultSet = st.executeQuery("SELECT * FROM driver WHERE lastname LIKE 'De%'");
        while (resultSet.next()) {
            System.out.println(resultSet.getRow() + " " + resultSet.getString(2) + " " + resultSet.getString("lastname") + " "
                    + resultSet.getDate("birthdate").toLocalDate().getYear());
        }*/
    }


    protected static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER_NAME);
        props.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, props);
    }

}
