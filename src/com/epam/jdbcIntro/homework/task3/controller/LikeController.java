package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.model.Like;

import java.sql.SQLException;

public class LikeController extends ConnectionToDB {

    public static void addLike(Like like) throws SQLException {
        String sql = getInsertSql(like);
        statement.execute(sql);
        System.out.println(sql + " - SUCCESS");
    }

    private static String getInsertSql(Like like) {
        return "INSERT INTO likes(postid,userid,timestamp) " +
                "values(" + like.postId + "," + like.userId + ",'" + like.timestamp + "')";
    }
}
