package com.epam.jdbcIntro.homework.task3.model;

public class Post {
    public int id;
    public int userId;
    public String text;
    public String timestamp;

    public Post(int id, int userId, String text, String timestamp) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Post(int userId, String text, String timestamp) {
        this(-1, userId, text, timestamp);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
