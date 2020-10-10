public class Truck extends Vehicle {
    public Truck(String plate, VehicleSize size) {
        super(plate, size);
    }

    @Override
    public VehicleSize size() {
        return VehicleSize.MIDSIZE;
    }
}
