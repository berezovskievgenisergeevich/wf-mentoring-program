package com.epam.jdbcIntro.homework.task3.model;

public class Friendship {
    public int id;
    public int userId1;
    public int userId2;
    public String timestamp;

    public Friendship(int id, int userId1, int userId2, String timestamp) {
        this.id = id;
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.timestamp = timestamp;
    }

    public Friendship(int userId1, int userId2, String timestamp) {
        id = -1;
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Friendships{" +
                "id=" + id +
                ", userId1=" + userId1 +
                ", userId2=" + userId2 +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
