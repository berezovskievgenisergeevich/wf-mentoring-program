package com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ProdCode;
import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.UseStackOnly;

public abstract class PublicTransport implements Movable {
    private static final String PUBLIC_TRANSPORT_INFO = "This is information about public transport in Belarus.\n" +
            "Public transport is: buses, trolleybuses and trams.";
    @UseStackOnly
    private String name;
    @UseStackOnly
    private String cost;
    @UseStackOnly
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

    @Deprecated
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
