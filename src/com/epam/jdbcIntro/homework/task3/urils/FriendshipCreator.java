package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task3.model.Friendship;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdbcIntro.homework.task3.urils.RandomGenerator.getRandomTimestamp;
import static com.epam.jdbcIntro.homework.task3.urils.RandomGenerator.getRandomUserId;

public class FriendshipCreator {

    public static Friendship createFriendship() {
        int id = getRandomUserId();
        return new Friendship(id, getRandomUserId(id), getRandomTimestamp());
    }

    public static List<Friendship> createFriendships(int count) {
        List<Friendship> friendships = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            friendships.add(createFriendship());
        }
        return friendships;
    }
}
