package com.epam.junit.homework.task4.example1.test;

import com.epam.junit.homework.task4.example1.app.DataService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DataServiceTest {

    // private DataService dataService;

    @Mock
    DataService dataService;

    MockitoSession session;

    @BeforeMethod
    public void beforeMethod() {
        session = Mockito.mockitoSession()
                .initMocks(this)
                .startMocking();
    }

    @AfterMethod
    public void afterMethod() {
        session.finishMocking();
    }

    @Before
    public void setUp() {
        dataService = Mockito.spy(DataService.class);
    }

    @Test
    public void test1() {
        List<String> data = new ArrayList<>();
        data.add("dataItem");
        Mockito.when(dataService.getData()).thenReturn(data);
      /*  or
      Mockito.doReturn(data).when(dataService).getData();
      */

    }

    @Test
    public void test2() {
        Mockito.when(dataService.getDataById("idValue"))
                .thenReturn("dataItem");
// or
        Mockito.when(dataService.getDataById(Mockito.eq("idValue")))
                .thenReturn("dataItem");
    }

    @Test
    public void test3() {
        Mockito.when(dataService.getDataById(
                Mockito.argThat(arg -> arg == null || arg.length() > 5)))
                .thenReturn("dataItem");
    }

    @Test
    public void test4() {
        Mockito.when(dataService.getDataById("invalidId"))
                .thenThrow(new IllegalArgumentException());
        //or
        Mockito.when(dataService.getDataById("invalidId"))
                .thenThrow(IllegalArgumentException.class);
    }

    @Test
    public void test5() {
        Mockito.when(dataService.getDataById(Mockito.any()))
                .thenAnswer(invocation -> invocation
                        .<List<String>>getArgument(0).stream()
                        .map(id -> {
                            switch (id) {
                                case "a":
                                    return "dataItemA";
                                case "b":
                                    return "dataItemB";
                                default:
                                    return null;
                            }
                        })
                        .collect(Collectors.toList()));
    }

    @Test
    public void test6() {
        Mockito.verify(dataService).getDataById(Mockito.any());
        //or
        Mockito.verify(dataService, Mockito.times(1))
                .getDataById(Mockito.any());
    }


}