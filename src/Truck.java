public class Truck extends Vehicle {

    public Truck(String plate) {
        super(plate);
    }

    @Override
    public VehicleSize size() {
        return VehicleSize.MIDSIZE;
    }
}
