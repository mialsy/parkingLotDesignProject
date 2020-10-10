import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


// TODO: implement parking lot
public class ParkingLot {
    private final Spot[] spotList;
    private int vehicleCount;
    private Map<Vehicle, Integer> vehicleToIdMap; // map vehicle to the spot id it parks


    public ParkingLot(Spot[] spotList) {
        this.spotList = spotList;
        vehicleCount = 0;
    }

    public boolean isFull(){
        if (vehicleCount < spotList.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mimic the porcess of finding spot by id, need to check spot id one by one
     * @param id the id of the spot to find
     * @return
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

    public Vehicle exit(Vehicle v) {
        Integer id = vehicleToIdMap.get(v);
        if (id != null) {
            return exit(id);
        } else {
            System.out.println("Vehicle not found in this parking lot");
            return null;
        }
    }

    public Vehicle exit(int id) {
        Spot spot = findSpotById(id);
        if (spot != null && !spot.isEmpty()) {
            vehicleCount--;
            return spot.leave();
        } else {
            System.out.println("Vehicle not found at spot id:" + id);
            return null;
        }
    }

}
