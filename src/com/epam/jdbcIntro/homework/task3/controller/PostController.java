package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.model.Post;

import java.sql.SQLException;

public class PostController extends ConnectionToDB {
    public static void addPost(Post post) throws SQLException {
        String sql = getInsertSql(post);
        executeSql(sql);
        /*statement.execute(sql);
        System.out.println(sql + " - SUCCESS");*/
    }

    private static String getInsertSql(Post post) {
        return "INSERT INTO posts(userid,text,timestamp) " +
                "values(" + post.userId + ",'" + post.text + "','" + post.timestamp + "')";
    }
}
