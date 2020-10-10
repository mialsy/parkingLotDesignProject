public class Bus extends Vehicle{

    public Bus(String plate, VehicleSize size) {
        super(plate, size);
    }

    @Override
    public VehicleSize size() {
        return VehicleSize.LARGE;
    }
}
