package com.epam.jdbcIntro.homework.task3.model;

public class Like {
    public int id;
    public int postId;
    public int userId;
    public String timestamp;


    public Like(int id, int postId, int userId, String timestamp) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public Like(int postId, int userId, String timestamp) {
        this(-1, postId, userId, timestamp);
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", postId=" + postId +
                ", userId=" + userId +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
