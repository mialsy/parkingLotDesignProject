import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    Truck t;

    @BeforeEach
    void init() {
        System.out.println("Intialize Car");
        t = new Truck("AFU");
    }

    @Test
    void size() {
        System.out.println("Test size()");
        assertEquals(VehicleSize.MIDSIZE, t.size());
    }

    @Test
    void plate() {
        System.out.println("Test plate()");
        assertEquals("AFU", t.plate());
    }
}