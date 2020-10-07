public abstract class Vehicle {
    private final String plate;
    private final VechicleSize size;

    public Vehicle(String plate, VechicleSize size) {
        this.plate = plate;
        this.size = size;
    }

    public String plate() {
        return plate;
    }

    public VechicleSize size() {
        return size;
    }
}
