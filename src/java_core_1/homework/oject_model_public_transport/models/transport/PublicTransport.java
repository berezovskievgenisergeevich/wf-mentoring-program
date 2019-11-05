package java_core_1.homework.oject_model_public_transport.models.transport;

public abstract class PublicTransport implements Transport{
    private String name;
    private String cost;
    private String fuelConsumption;

    public PublicTransport(String name, String cost, String fuelConsumption) {
        this.name = name;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "PublicTransport{" +
                "name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                '}';
    }
}
