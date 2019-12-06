package com.epam.jdbcIntro.homework.task3.controller;

import com.epam.jdbcIntro.homework.task3.model.Like;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeController extends ConnectionToDB {

    public static void addLike(Like like) throws SQLException {
        String sql = getInsertSql(like);
        executeSql(sql);
    }

    private static String getInsertSql(Like like) {
        return "INSERT INTO likes(postid,userid,timestamp) " +
                "values(" + like.postId + "," + like.userId + ",'" + like.timestamp + "')";
    }

    public static List<Integer> getIdWhereLikesMoreThen(int count) {
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
        return "SELECT  userid,COUNT(userid) \n" +
                "FROM wf_mentoring.likes\n" +
                "group by userid \n" +
                "HAVING COUNT(userid) > " + count;
    }
}
