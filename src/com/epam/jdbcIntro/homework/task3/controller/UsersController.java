package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsersController extends ConnectionToDB {

    public static void addUser(User users) throws SQLException {
        String sql = getInsertSql(users);
        executeSql(sql);
    }

    public static List<User> getUsersWithParams(int friendsCount, int likesCount) {
        Set<Integer> usersId = getUsersIdWithParams(friendsCount, likesCount);
        List<User> users = new ArrayList<>();
        usersId.forEach(id -> {
            try {
                users.add(getUser(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        return users;

    }

    public static Set<Integer> getUsersIdWithParams(int friendsCount, int likesCount) {
        List<Integer> idWhereLikesMoreThen = LikeController.getIdWhereLikesMoreThen(likesCount);
        List<Integer> idWhereFriendshipMoreThen = FriendshipController.getIdWhereFriendshipMoreThen(friendsCount);
        Set<Integer> ids = new HashSet<>();
        ids.addAll(idWhereFriendshipMoreThen);
        ids.addAll(idWhereLikesMoreThen);
        return ids;
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
        users.add(new User(resultSet));
    }

}
