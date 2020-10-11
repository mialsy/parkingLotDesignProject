public class Spot {
    private final int id;
    private final VehicleSize maxCapacity;
    private Vehicle currentVehicle;

    public Spot(int id, VehicleSize maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
    }

    /**
     * return the information of the spot
     * @return a string with spot id, max capacity, current vehicle
     */
    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", maxCapacity=" + maxCapacity +
                ", currentVehicle=" + currentVehicle +
                '}';
    }

    /**
     * get the Spot id
     * @return an int value of the Spot id
     */
    public int getId() {
        return id;
    }

    /**
     * get the maxCapacity of the current spot
     * @return enum {@code VehicleSize}  of the spot
     */
    VehicleSize getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * get the current vehicle parked at the spot
     * @return a vehicle that is parked at the spot
     */
    Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    /**
     * check if the current spot is empty
     * @return {@code true} if the spot is empty
     */
    boolean isEmpty() {
        return currentVehicle == null;
    }

    /**
     * check if the vehicle fits in the current spot
     * @param v vehicle of input
     * @return {@code true} if the spot is empty and the maxCapacity is larger or euqals to the vehicle size
     */
    boolean fit(Vehicle v) {
        return isEmpty() && (v.size().volume() <= maxCapacity.volume());
    }

    /**
     *  park the vehicle if the vehicle fits in the current spot
     * @param v the vehicle to park at the spot
     * @return an Integer of the current spot id, if cannot park return null
     */
    public Integer park(Vehicle v) {
        if (fit(v)) {
            currentVehicle = v;
            return id;
        } else {
            return null;
        }
    }

    /**
     * leave from the current spot
     * @return the vehicle that is originally at current spot
     */
    public Vehicle leave() {
        Vehicle outVehicle = currentVehicle;
        currentVehicle = null;
        return outVehicle;
    }

}
