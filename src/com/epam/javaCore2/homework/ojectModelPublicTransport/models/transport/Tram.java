package com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport;

public class Tram extends ElectricTransport {
    public Tram(String name, String cost, String fuelConsumption) {
        super(name, cost, fuelConsumption);
    }

    @Override
    public void move() {
        System.out.println("Tram run");
    }
}
