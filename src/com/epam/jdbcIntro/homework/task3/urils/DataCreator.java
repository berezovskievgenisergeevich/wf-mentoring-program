package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task3.data.Info;
import com.epam.jdbcIntro.homework.task3.model.Friendship;
import com.epam.jdbcIntro.homework.task3.model.Like;
import com.epam.jdbcIntro.homework.task3.model.Post;
import com.epam.jdbcIntro.homework.task3.model.User;

import java.util.List;

public class DataCreator {

    public static List<User> getUsers() {
        return UserCreator.createUsers(Info.MAX_USER_ID);
    }

    public static List<Like> getLikes() {
        return LikeCreator.createLikes(Info.MAX_LIKES_COUNT);
    }

    public static List<Friendship> getFriendships() {
        return FriendshipCreator.createFriendships(Info.MAX_FRIENDSHIPS);
    }

    public static List<Post> getPosts() {
        return PostCreator.createPosts(Info.MAX_POST_COUNT);
    }
}
