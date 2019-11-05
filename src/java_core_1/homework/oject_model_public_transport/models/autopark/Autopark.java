package java_core_1.homework.oject_model_public_transport.models.autopark;

import java_core_1.homework.oject_model_public_transport.models.transport.PublicTransport;
import java_core_1.homework.oject_model_public_transport.models.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class Autopark implements Park {
    private List<Transport> transports;

    public Autopark() {
        this.transports = new ArrayList<>();
    }

    public Autopark(List<Transport> transports) {
        this.transports = transports;
    }


    @Override
    public boolean add(Transport transport) {
        return transports.add(transport);
    }

    public List<Transport> get() {
        return transports;
    }
}
