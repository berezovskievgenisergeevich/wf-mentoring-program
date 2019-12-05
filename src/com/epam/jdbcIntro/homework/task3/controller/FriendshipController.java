package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.model.Friendship;

import java.sql.SQLException;

public class FriendshipController extends ConnectionToDB {

    public static void addFriendship(Friendship friendships) throws SQLException {
        String sql = getInsertSql(friendships);
        statement.execute(sql);
        System.out.println(sql + " - SUCCESS");
    }

    private static String getInsertSql(Friendship friendships) {
        return "INSERT INTO friendships(userid1,userid2,timestamp) " +
                "values(" + friendships.userId1 + "," + friendships.userId2 + ",'" + friendships.timestamp + "')";
    }
}
