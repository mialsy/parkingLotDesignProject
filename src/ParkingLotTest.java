import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private static ParkingLot pl;
    private static int randomIdGenerated;
    private static Car car;
    private static Truck truck;
    private static Bus bus;
    private static Spot[] spots;

    @BeforeEach
    void setUp() {
        System.out.println("Initiate test");
        spots = new Spot[6];

        for (int i = 0; i < 2; i++) {
            Random rd = new Random();
            randomIdGenerated = rd.nextInt(50);
            spots[i] = new Spot(randomIdGenerated,VehicleSize.COMPACT);
        }
        for (int i = 0; i < 2; i++) {
            Random rd = new Random();
            spots[i + 2] = new Spot(rd.nextInt(50),VehicleSize.MIDSIZE);
        }
        for (int i = 0; i < 2; i++) {
            Random rd = new Random();
            spots[i + 4] = new Spot(rd.nextInt(50),VehicleSize.LARGE);
        }

        car = new Car("SKITTLE");
        truck = new Truck("AFU");
        bus = new Bus("GUMBALL");
        System.out.println("Spots list are following:");
        System.out.println(Arrays.toString(spots));
        pl = new ParkingLot(spots);
    }

    @Test
    void isFull() {
        System.out.println("Test isFull");
        assertFalse(pl.isFull());

        for (int i = 0; i < 6; i++) {
            pl.park(car);
        }

        assertTrue(pl.isFull());
    }

    @Test
    void findSpotById() {
        System.out.println("Test findSpotById");
        assertFalse(pl.findSpotById(randomIdGenerated) == null);
        assertTrue(pl.findSpotById(100) == null);
    }

    @Test
    void park() {
        System.out.println("Test park vehicle at specified spot");
        // can park because size fit, and spot is empty
        assertFalse(pl.park(car, spots[0]) == null);

        // cannot park because spot is not empty
        assertTrue(pl.park(car,spots[0]) == null);

        // cannot park because does not fit
        assertTrue(pl.park(bus, spots[1]) == null);

        System.out.println("Test park vehicle at any spot");
        // can park because there is still place available
        assertFalse(pl.park(car) == null);
        assertFalse(pl.park(bus) == null);
    }

    @Test
    void exit() {

        System.out.println("Test exit");
        // not parked yet
        assertTrue(pl.exit(car) == null);

        // after park, can exit
        pl.park(car);
        assertFalse(pl.exit(car) == null);

        // cannot exit because vehicle does not match
        pl.park(car, spots[1]);
        pl.park(truck, spots[2]);
        assertTrue(pl.exit(truck, randomIdGenerated) == null);
    }
}