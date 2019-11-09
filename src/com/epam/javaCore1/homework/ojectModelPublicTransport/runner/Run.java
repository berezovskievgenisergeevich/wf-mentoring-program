package com.epam.javaCore1.homework.ojectModelPublicTransport.runner;

import com.epam.javaCore1.homework.ojectModelPublicTransport.models.SearchOption;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.autopark.Autopark;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.transport.Bus;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.transport.PublicTransport;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.transport.Tram;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.transport.Trolleybus;
import java_core_1.homework.oject_model_public_transport.models.transport.*;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.utillity.ParkManager;

public class Run {
    public static void main(String[] args) {
        System.out.println(PublicTransport.getPublicTransportInfo());
        Autopark autopark = ParkManager.createAutopark();

        autopark.add(new Bus("bus", "1", "1"));
        autopark.add(new Tram("tram", "2", "2"));
        autopark.add(new Tram("tram", "3", "3"));
        autopark.add(new Trolleybus("trolleybus", "3", "3"));

        System.out.println(ParkManager.searchBy(SearchOption.NAME, "tram"));


    }
}
