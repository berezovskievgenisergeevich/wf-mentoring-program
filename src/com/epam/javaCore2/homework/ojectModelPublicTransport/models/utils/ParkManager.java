package com.epam.javaCore2.homework.ojectModelPublicTransport.models.utils;

import com.epam.javaCore2.homework.ojectModelPublicTransport.customAnnotators.ThisCodeSmells;
import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.AupotarkIsNotCreatedException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.exceptions.NotSupportedTransportException;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.SearchOption;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.autopark.Autopark;
import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.PublicTransport;

import java.util.List;

@ThisCodeSmells(reviewer = "ParkManager")
public class ParkManager {
    @ThisCodeSmells(reviewer = "field")
    private static Autopark curAutopark;

    private ParkManager() {
    }

    @ThisCodeSmells
    public static Autopark createAutopark() {
        curAutopark = new Autopark();
        return curAutopark;
    }

    @SuppressWarnings("all")
    public static void methodWithSuppressWarnings() {
        String testString = "";
    }

    @ThisCodeSmells
    public static void setCurAutopark(Autopark autopark) {
        curAutopark = autopark;
    }

    public static List<PublicTransport> searchBy(SearchOption searchOption, String searchData) throws AupotarkIsNotCreatedException, NotSupportedTransportException {
        if (isAutoparkNotCreated())
            throw new AupotarkIsNotCreatedException();

        switch (searchOption) {
            case COST:
                return curAutopark.getByCost(searchData);
            case NAME:
                return curAutopark.getByName(searchData);
            case FUEL_CONSUMPTION:
                return curAutopark.getByFuelConsumption(searchData);
            default:
                throw new NotSupportedTransportException();
        }
    }

    private static boolean isAutoparkNotCreated() {
        return curAutopark == null;
    }
}
