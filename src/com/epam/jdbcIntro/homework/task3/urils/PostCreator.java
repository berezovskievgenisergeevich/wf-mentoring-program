package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task3.model.Post;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdbcIntro.homework.task3.urils.RandomGenerator.*;
import static com.epam.jdbcIntro.homework.task3.urils.RandomGenerator.getRandomTimestamp;

public class PostCreator {
    public static Post createPost() {
        return new Post(getRandomUserId(), generateText(), getRandomTimestamp());
    }

    public static List<Post> createPosts(int count) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            posts.add(createPost());
        }
        return posts;
    }
}
