package java_core_1.homework.oject_model_public_transport.models.autopark;

import java_core_1.homework.oject_model_public_transport.models.transport.PublicTransport;
import java_core_1.homework.oject_model_public_transport.models.transport.Transport;

import java.util.List;

public interface Park {
     boolean add(Transport transport);

    List<PublicTransport> get();

}
