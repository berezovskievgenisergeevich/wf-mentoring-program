package com.epam.jdbcIntro.homework.task3.urils;

import com.epam.jdbcIntro.homework.task3.model.User;

import static com.epam.jdbcIntro.homework.task3.urils.RandomGenerator.*;

public class UserCreator {

    public static User createUser() {
        return new User(generateName(), generateLastName(), generateBirthday());
    }
}
