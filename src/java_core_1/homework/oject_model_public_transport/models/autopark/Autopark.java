package java_core_1.homework.oject_model_public_transport.models.autopark;

import java_core_1.homework.oject_model_public_transport.models.transport.PublicTransport;
import java_core_1.homework.oject_model_public_transport.models.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public  class Autopark implements Park {
    private List<PublicTransport> transports;

    public Autopark() {
        this.transports = new ArrayList<>();
    }

    public Autopark(List<PublicTransport> transports) {
        this.transports = transports;
    }


    public boolean add(PublicTransport transport) {
        return transports.add(transport);
    }


    @Override
    public boolean add(Transport transport) {
        return false;
    }

    public List<PublicTransport> get() {
        return transports;
    }
}
