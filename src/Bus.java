public class Bus extends Vehicle{

    public Bus(String plate) {
        super(plate);
    }

    @Override
    public VehicleSize size() {
        return VehicleSize.LARGE;
    }
}
