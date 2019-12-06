package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task3.controller.FriendshipController;
import com.epam.jdbcIntro.homework.task3.controller.LikeController;
import com.epam.jdbcIntro.homework.task3.controller.PostController;
import com.epam.jdbcIntro.homework.task3.controller.UsersController;
import com.epam.jdbcIntro.homework.task3.model.Friendship;

import java.sql.SQLException;

public class DBUtils extends DBConnection {


    public static void addUsers() {
        DataCreator.getUsers().forEach(user -> {
            try {
                UsersController.addUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public static void addPosts() {
        DataCreator.getPosts().forEach(post -> {
            try {
                PostController.addPost(post);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public static void addLikes() {
        DataCreator.getLikes().forEach(like -> {
            try {
                LikeController.addLike(like);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public static void addFriendships() {
        for (Friendship friendship : DataCreator.getFriendships()) {
            try {
                FriendshipController.addFriendship(friendship);
            } catch (SQLException e) {
                e.printStackTrace();
            };

        }
    }
}
