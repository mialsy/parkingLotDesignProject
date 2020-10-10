import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    Bus b;

    @BeforeEach
    void init() {
        System.out.println("Intialize Car");
        b = new Bus("GUMBALL");
    }

    @Test
    void size() {
        System.out.println("Test size()");
        assertEquals(VehicleSize.LARGE, b.size());
    }

    @Test
    void plate() {
        System.out.println("Test plate()");
        assertEquals("GUMBALL", b.plate());
    }


}