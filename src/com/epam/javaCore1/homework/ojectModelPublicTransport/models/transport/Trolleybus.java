package com.epam.javaCore1.homework.ojectModelPublicTransport.models.transport;

public class Trolleybus extends ElectricTransport {
    public Trolleybus(String name, String cost, String fuelConsumption) {
        super(name, cost, fuelConsumption);
    }

    @Override
    public void move() {
        System.out.println("Trolleybus run");
    }
}
