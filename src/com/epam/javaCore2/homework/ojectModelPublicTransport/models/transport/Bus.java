package com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport;

public class Bus extends PetrolTransport {
    public Bus(String name, String cost, String fuelConsumption) {
        super(name, cost, fuelConsumption);
    }

    @Override
    public void move() {
        System.out.println("Bus run");
    }
}
