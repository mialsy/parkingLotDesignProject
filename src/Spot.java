public class Spot {
    private final int id;
    private final VehicleSize maxCapacity;
    private Vehicle currentVehicle;

    public Spot(int id, VehicleSize maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
    }

    public int getId() {
        return id;
    }

    VehicleSize getMaxCapacity() {
        return maxCapacity;
    }

    Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    boolean isEmpty() {
        return currentVehicle == null;
    }

    boolean fit(Vehicle v) {
        return isEmpty() && (v.size().volume() < maxCapacity.volume());
    }

    public Integer park(Vehicle v) {
        if (fit(v)) {
            currentVehicle = v;
            return id;
        } else {
            return null;
        }
    }

    public Vehicle leave() {
        Vehicle outVehicle = currentVehicle;
        currentVehicle = null;
        return outVehicle;
    }

}
