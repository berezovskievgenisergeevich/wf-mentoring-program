package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.model.Friendship;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendshipController extends ConnectionToDB {

    public static void addFriendship(Friendship friendships) throws SQLException {
        String sql = getInsertSql(friendships);
        executeSql(sql);
    }

    private static String getInsertSql(Friendship friendships) {
        return "INSERT INTO friendships(userid1,userid2,timestamp) " +
                "values(" + friendships.userId1 + "," + friendships.userId2 + ",'" + friendships.timestamp + "')";
    }


    public static List<Integer> getIdWhereFriendshipMoreThen(int count) {
        List<Integer> strings = new ArrayList<>();
        try {
            ResultSet resultSet = getIdResultSet(count);
            while (resultSet.next())
                strings.add(resultSet.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static ResultSet getIdResultSet(int count) throws SQLException {
        return statement.executeQuery(getSelectIdSql(count));
    }

    private static String getSelectIdSql(int count) {
        return "SELECT  userid1,COUNT(userid1) \n" +
                "FROM wf_mentoring.friendships  \n" +
                "group by userid1 \n" +
                "HAVING COUNT(userid1) > " + count;
    }
}
