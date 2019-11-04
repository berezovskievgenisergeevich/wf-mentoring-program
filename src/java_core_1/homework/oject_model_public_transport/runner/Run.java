package java_core_1.homework.oject_model_public_transport.runner;

import java_core_1.homework.oject_model_public_transport.models.autopark.Autopark;
import java_core_1.homework.oject_model_public_transport.models.transport.Bus;
import java_core_1.homework.oject_model_public_transport.models.transport.Tram;
import java_core_1.homework.oject_model_public_transport.models.transport.Transport;
import java_core_1.homework.oject_model_public_transport.models.transport.Trolleybus;
import java_core_1.homework.oject_model_public_transport.models.utillity.ParkManager;

public class Run {
    public static void main(String[] args) {
        Autopark autopark = ParkManager.createAutopark();

        autopark.add(new Bus("", "", ""));
        autopark.add(new Tram("", "", ""));
        autopark.add(new Trolleybus("", "", ""));



    }
}
