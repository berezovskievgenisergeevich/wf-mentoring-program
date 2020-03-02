package com.epam.junit.homework.task4.example1.app;

import java.util.Date;


public class DataSearchRequest {
    String id;
    int length;
    Date updatedBefore;


    public DataSearchRequest(String id, Date updatedBefore, int length) {
        this.id = id;
        this.updatedBefore = updatedBefore;
        this.length = length;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getUpdatedBefore() {
        return updatedBefore;
    }

    public void setUpdatedBefore(Date updatedBefore) {
        this.updatedBefore = updatedBefore;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


}