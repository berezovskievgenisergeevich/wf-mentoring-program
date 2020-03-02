package com.epam.junit.lectures;

import java.util.Date;

public class Service {
    Date getData(long id) throws Exception {
        if (id >= 0)
            return new Date();
        else
            throw new Exception();
    }
}
