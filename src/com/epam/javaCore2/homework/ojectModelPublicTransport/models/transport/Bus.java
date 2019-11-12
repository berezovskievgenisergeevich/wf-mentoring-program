package com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ProdCode;

public class Bus extends PetrolTransport {
    public Bus() {
        super("defName","defCost","defFuelCons");
    }

    public Bus(String name, String cost, String fuelConsumption) {
        super(name, cost, fuelConsumption);
    }

    @Override
    @ProdCode
    public void move() {
        System.out.println("Bus run");
    }
}
