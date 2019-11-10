package com.epam.javaCore1.homework.ojectModelPublicTransport.models.transport;

public abstract class PublicTransport implements Movable {
    private static final String PUBLIC_TRANSPORT_INFO = "This is information about public transport in Belarus.\n" +
            "Public transport is: buses, trolleybuses and trams.";
    private String name;
    private String cost;
    private String fuelConsumption;

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public PublicTransport(String name, String cost, String fuelConsumption) {
        this.name = name;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
    }

    public static final String getPublicTransportInfo() {
        return PUBLIC_TRANSPORT_INFO;
    }

    @Override
    public void move() {
        System.out.println("PublicTransport run");
    }

    @Override
    public String toString() {
        return "PublicTransport{" +
                "name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                '}';
    }
}
