import java.util.HashMap;
import java.util.Map;


/**
 * A basic parking lot that supports park and exit
 * once created, the spots will not be able to be modified
 */
public class ParkingLot {
    private final Spot[] spotList;
    private int vehicleCount;
    private Map<Vehicle, Integer> vehicleToIdMap; // map vehicle to the spot id it parks


    /**
     * Create a parking lot with input spot list
     * This parking lot does not support change spot list, or multiple level, all spots are final
     * @param spotList a list of the spot that will be in this parking lot
     */
    public ParkingLot(Spot[] spotList) {
        this.spotList = spotList;
        vehicleToIdMap = new HashMap<>();
        vehicleCount = 0;
    }

    /**
     * Check if the parking lot is full and print out a message to indicate the status of the parking lot
     * @return {@code true} if the parking lot is full
     */
    public boolean isFull(){
        if (vehicleCount > spotList.length) {
            System.out.println("Parking lot is full!");
            return true;
        } else {
            System.out.println("Parking lot still have spots");
            return false;
        }
    }

    /**
     * Mimic the process of finding spot by id, need to check spot id one by one
     * @param id the id of the spot to find
     * @return the Spot that matches id
     */
    Spot findSpotById(int id) {
        for (Spot spot: spotList) {
            if (id == spot.getId()) {
                return spot;
            }
        }
        return null;
    }

    /**
     * Park the vehicle to any spot available
     * @param v the vehicle to park
     * @return the integer value of the spot id, return null if the vehicle cannot park at the current spot
     */
    public Integer park(Vehicle v) {
        if (isFull()) {
            return null;
        } else {
            for (Spot spot: spotList) {
                Integer spotId = park(v, spot);
                if (spotId != null) {
                    vehicleCount++;
                    return spotId;
                }
            }
            return null;
        }
    }

    /**
     * Park the vehicle to specified spot
     * @param v the vehicle to park
     * @param spot  the specified spot
     * @return  the integer value of the spot id, return null if the vehicle cannot park at the current spot
     */
    public Integer park(Vehicle v, Spot spot) {
        if (spot.isEmpty()) {
            if (spot.fit(v)) {
                vehicleCount++;
                vehicleToIdMap.put(v, spot.getId());
            }
            return spot.park(v);
        } else {
            return null;
        }
    }

    /**
     * Move specified vehicle out of parking lot
     * @param v the vehicle that need to exit the parking lot
     * @return the exited vehicle
     */
    public Vehicle exit(Vehicle v) {
        Integer id = vehicleToIdMap.get(v);
        if (id != null) {
            return exit(v, id);
        } else {
            System.out.println("Vehicle not found in this parking lot");
            return null;
        }
    }

    /**
     * Move vehicle from the spot with the specified id
     * If spot can be found by the id, check whether the vehicle is the same as the given vehicle
     * If vehicle also match, return the vehicle and update
     * @param id the id of the spot
     * @param v the vehicle to exit from the specified spot
     * @return the exited vehicle
     */
    public Vehicle exit(Vehicle v, int id) {
        Spot spot = findSpotById(id);
        if (spot != null && v == spot.getCurrentVehicle()) {
            vehicleToIdMap.remove(v);
            vehicleCount--;
            System.out.println("Vehicle exited");
            return spot.leave();
        } else {
            System.out.println("Vehicle not found at spot id:" + id);
            return null;
        }
    }
}
