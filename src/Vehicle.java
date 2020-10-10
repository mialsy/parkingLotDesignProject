public abstract class Vehicle {
    private final String plate;
    private final VehicleSize size;

    public Vehicle(String plate, VehicleSize size) {
        this.plate = plate;
        this.size = size;
    }

    public String plate() {
        return plate;
    }

    public abstract VehicleSize size();
}
