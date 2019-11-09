package com.epam.javaCore1.homework.ojectModelPublicTransport.models.utils;

import com.epam.javaCore1.homework.ojectModelPublicTransport.models.SearchOption;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.autopark.Autopark;
import com.epam.javaCore1.homework.ojectModelPublicTransport.models.transport.PublicTransport;

import java.util.List;

public class ParkManager {
    private static Autopark curAutopark;

    private ParkManager() {
    }

    public static Autopark createAutopark() {
        curAutopark = new Autopark();
        return curAutopark;
    }

    public static void setCurAutopark(Autopark autopark) {
        curAutopark = autopark;
    }

    public static List<PublicTransport> searchBy(SearchOption searchOption, String searchData) {
        switch (searchOption) {
            case COST:
                return curAutopark.getByCost(searchData);
            case NAME:
                return curAutopark.getByName(searchData);
            case FUEL_CONSUMPTION:
                return curAutopark.getByFuelConsumption(searchData);
            default:
                return null;
        }
    }
}
