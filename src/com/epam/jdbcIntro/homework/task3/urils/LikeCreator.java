package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task3.model.Like;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdbcIntro.homework.task3.urils.RandomGenerator.*;

public class LikeCreator {
    public static Like createLike() {
        return new Like(generateRandomPostId(), getRandomUserId(), getRandomTimestamp());
    }

    public static List<Like> createLikes(int count) {
        List<Like> likes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            likes.add(createLike());
        }
        return likes;
    }
}
