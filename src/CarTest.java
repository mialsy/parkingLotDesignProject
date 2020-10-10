import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car myCar;

    @BeforeEach
    void init() {
        System.out.println("Intialize Car");
        myCar = new Car("SKITTLE");
    }

    @Test
    void size() {
        System.out.println("Test size()");
        assertEquals(VehicleSize.COMPACT, myCar.size());
    }

    @Test
    void plate() {
        System.out.println("Test plate()");
        assertEquals("SKITTLE", myCar.plate());
    }
}