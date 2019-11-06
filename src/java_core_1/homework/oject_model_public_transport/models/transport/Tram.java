package java_core_1.homework.oject_model_public_transport.models.transport;

public class Tram extends ElectricTransport {
    public Tram(String name, String cost, String fuelConsumption) {
        super(name, cost, fuelConsumption);
    }

    @Override
    public void run() {
        System.out.println("Tram run");
    }
}
