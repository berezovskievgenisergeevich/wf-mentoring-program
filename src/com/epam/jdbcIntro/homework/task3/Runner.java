package com.epam.jdbcIntro.homework.task3;

import com.epam.jdbcIntro.homework.task3.model.Friendship;
import com.epam.jdbcIntro.homework.task3.model.Like;
import com.epam.jdbcIntro.homework.task3.model.Post;
import com.epam.jdbcIntro.homework.task3.model.User;
import com.epam.jdbcIntro.homework.task3.urils.UserCreator;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User users = new User("Ivan_1", "Pavlov_1", "02-02-2010");
        Friendship friendships = new Friendship(1, 1, "02-02-1997");
        Like like = new Like(1, 1, "01-01-2010");
        Post post = new Post(1, "text to post", "01-01-2011");

        //  UsersController.addUser(users);
        // UsersController.getAllUsers().forEach(System.out::println);
        //  System.out.println(UsersController.getUser(2));
        // FriendshipController.addFriendship(friendships);
        //  LikeController.addLike(like);
        System.out.println(UserCreator.createUser());
       // PostController.addPost(post);
    }
}
