package com.epam.javaCore2.homework.ojectModelPublicTransport.models.autopark;

import com.epam.javaCore2.homework.ojectModelPublicTransport.models.transport.PublicTransport;

import java.util.List;

public interface Park {
     boolean add(PublicTransport transport);

    List<PublicTransport> get();

}
