package com.epam.javaCore2.homework.ojectModelPublicTransport.models.autopark;

import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.PublicTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Autopark implements Park {
    private List<PublicTransport> transports;

    public Autopark() {
        this.transports = new ArrayList<>();
    }

    public Autopark(List<PublicTransport> transports) {
        this.transports = transports;
    }

    public List<PublicTransport> getByName(String name) {
        return transports.stream().filter(pubTr -> pubTr.getName().equals(name)).collect(Collectors.toList());
    }

    public List<PublicTransport> getByCost(String cost) {
        return transports.stream().filter(pubTr -> pubTr.getCost().equals(cost)).collect(Collectors.toList());
    }

    public List<PublicTransport> getByFuelConsumption(String fuelConsumption) {
        return transports.stream().filter(pubTr -> pubTr.getFuelConsumption().equals(fuelConsumption)).collect(Collectors.toList());
    }


    @Override
    public boolean add(PublicTransport transport) {
        return transports.add(transport);
    }

    public List<PublicTransport> get() {
        return transports;
    }
}
