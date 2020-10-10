import java.util.List;
import java.util.Map;


// TODO: implement parking lot
public class ParkingLot {
    private final List<Spot> spotList;
    private int vehicleCount;
    private Map<Integer, Vehicle> idToVehicleMap;
    private Map<Vehicle, Integer> vehicleToIdMap;


    public ParkingLot(List<Spot> spotList) {
        this.spotList = spotList;
        vehicleCount = 0;
    }

    // TODO: isFull
    public boolean isFull(){
        if (vehicleCount < spotList.size()) {
            return true;
        } else {
            return false;
        }
    }

    // TODO:
    public boolean park(Vehicle v, int id) {

        return false;
    }

    public boolean exit(Vehicle v, int id) {

    }





}
