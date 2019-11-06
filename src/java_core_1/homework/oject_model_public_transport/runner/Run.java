package java_core_1.homework.oject_model_public_transport.runner;

import java_core_1.homework.oject_model_public_transport.models.SearchOption;
import java_core_1.homework.oject_model_public_transport.models.autopark.Autopark;
import java_core_1.homework.oject_model_public_transport.models.transport.*;
import java_core_1.homework.oject_model_public_transport.models.utillity.ParkManager;

public class Run {
    public static void main(String[] args) {
        System.out.println(PublicTransport.getPublicTransportInfo());
        Autopark autopark = ParkManager.createAutopark();

        autopark.add(new Bus("bus", "1", "1"));
        autopark.add(new Tram("tram", "2", "2"));
        autopark.add(new Tram("tram", "3", "3"));
        autopark.add(new Trolleybus("trolleybus", "3", "3"));

        System.out.println(ParkManager.searchBy(SearchOption.NAME, "tram"));


    }
}
