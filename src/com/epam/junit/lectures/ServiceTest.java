package com.epam.junit.lectures;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ServiceTest {
    private Service service;

    @Before
    public void setUp() throws Exception {
        service = new Service();
        System.out.println("Before");
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.out.println("BeforeClass");
    }

    @Test
    public void testGetData_whenPossitiveIdPassed_thenExpectNotNullData() throws Exception {
        long id = 121;
        Date date = service.getData(id);

        assertNotNull(date);
    }

    @Test
    public void testGetData_whenZeroValuePassed_thenExpectNotNullData() throws Exception {
        long id = 0;
        Service service = new Service();

        Date date = service.getData(id);

        assertNotNull(date);
    }

    @Test(expected = Exception.class)
    public void testGetData_whenNegativeValuePassed_thenThrowException() throws Exception {
        long id = -61;

        Date date = service.getData(id);

    }

}