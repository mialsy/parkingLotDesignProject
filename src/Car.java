public class Car extends Vehicle{

    public Car(String plate) {
        super(plate);
    }

    @Override
    public VehicleSize size() {
        return VehicleSize.COMPACT;
    }
}
