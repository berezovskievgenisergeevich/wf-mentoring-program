package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task3.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdbcIntro.homework.task3.urils.RandomGenerator.*;

public class UserCreator {

    public static User createUser() {
        return new User(generateName(), generateLastName(), generateBirthday());
    }

    public static List<User> createUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++)
            users.add(createUser());

        return users;
    }

}
