package com.epam.javaCore2.homework.ojectModelPublicTransport.runner;

import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.AupotarkIsNotCreatedException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.NotSupportedTransportException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.PublicTransportException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.SearchOption;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.autopark.Autopark;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.Bus;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.PublicTransport;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.Tram;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.Trolleybus;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils.ParkManager;

public class Run {
    public static void main(String[] args) {

        System.out.println(PublicTransport.getPublicTransportInfo());
        try {
            ParkManager.searchBy(SearchOption.NAME, "tram");
        } catch (PublicTransportException e) {
            e.printStackTrace();
        }
        Autopark autopark = ParkManager.createAutopark();
        autopark.add(new Bus("bus", "1", "1"));
        autopark.add(new Tram("tram", "2", "2"));
        autopark.add(new Tram("tram", "3", "3"));
        autopark.add(new Trolleybus("trolleybus", "3", "3"));

        try {
            System.out.println(ParkManager.searchBy(SearchOption.NAME, "tram"));
            System.out.println(ParkManager.searchBy(SearchOption.NOT_SUPPORTED_TRANSPORT, "tram"));
        } catch (AupotarkIsNotCreatedException | NotSupportedTransportException e) {
            e.printStackTrace();
        }




    }
}
