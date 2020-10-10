public class Car extends Vehicle{

    public Car(String plate, VehicleSize size) {
        super(plate, size);
    }

    @Override
    public VehicleSize size() {
        return VehicleSize.COMPACT;
    }
}
