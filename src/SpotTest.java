import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpotTest {
    Spot mySpot;
    Car car;
    Truck truck;
    Bus bus;

    @BeforeEach
    void init() {
        System.out.println("Initiate spotTest");
        mySpot = new Spot(230, VehicleSize.MIDSIZE);
        car = new Car("SKITTLE");
        truck = new Truck("AFU");
        bus = new Bus("GUMBALL");
    }

    @Test
    void getId() {
        System.out.println("Test getId");
        assertEquals(230, mySpot.getId());
    }

    @Test
    void getMaxCapacity() {
        System.out.println("Test getId");
        assertEquals(VehicleSize.MIDSIZE, mySpot.getMaxCapacity());
    }

    @Test
    void getCurrentVehicle() {
        System.out.println("Test getCurrentVehicle");
        assertEquals(null,mySpot.getCurrentVehicle());

    }

    @Test
    void isEmpty() {
        System.out.println("Test isEmpty");
        assertTrue(mySpot.isEmpty());
        mySpot.park(car);
        assertFalse(mySpot.isEmpty());
    }

    @Test
    void fit() {
        System.out.println("Test fit");
        assertFalse(mySpot.fit(bus));
        assertTrue(mySpot.fit(car));
        mySpot.park(car);
        assertFalse(mySpot.fit(truck));
    }

    @Test
    void park() {
        System.out.println("Test park");
        assertEquals(230, mySpot.park(car));
        assertEquals(null, mySpot.park(truck));
    }

    @Test
    void leave() {
        System.out.println("Test leave");
        mySpot.park(car);
        assertFalse(mySpot.isEmpty());
        assertEquals(car, mySpot.leave());
        assertTrue(mySpot.isEmpty());
    }
}