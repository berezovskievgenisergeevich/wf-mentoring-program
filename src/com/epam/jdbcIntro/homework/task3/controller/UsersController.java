package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersController extends ConnectionToDB {

    public static void addUser(User users) throws SQLException {
        String sql = getInsertSql(users);
        statement.execute(sql);
        System.out.println(sql + " - SUCCESS");
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = getAllUsersResultSet();
        while (resultSet.next())
            addUserToList(users, resultSet);

        return users;
    }

    public static User getUser(int id) throws SQLException {
        ResultSet resultSet = getUserResultSet(id);
        resultSet.next();
        return new User(resultSet);

    }

    private static ResultSet getUserResultSet(int id) throws SQLException {
        return statement.executeQuery(getSelectUserByIdSql(id));
    }

    private static String getSelectUserByIdSql(int id) {
        return "SELECT * FROM users WHERE id=" + id;
    }

    private static ResultSet getAllUsersResultSet() throws SQLException {
        return statement.executeQuery(getSelectSql());
    }

    private static String getInsertSql(User users) {
        return "INSERT INTO users(name,surname,birthdate) " +
                "values('" + users.name + "','" + users.surname + "','" + users.birthDate + "')";
    }

    private static String getSelectSql() {
        return "SELECT * FROM users";
    }

    private static void addUserToList(List<User> users, ResultSet resultSet) throws SQLException {
        users.add(new User(resultSet)/*new Users(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4))*/);
    }

}
