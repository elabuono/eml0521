import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class POSTest {
    POS pos;

    @BeforeEach
    public void createPOS() {
        pos = new POS();
    }

    @Test
    @DisplayName("Checkout should not throw exception, not generate Rental Agreement")
    public void test1() {
        try {
            pos.checkout("JAKR", 5, 101, "9/3/15");
            fail("UnsupportedOperationException should be thrown.");
        } catch (Exception e) {
            // expected behavior
            assertEquals("Discount must be within the range of 0-100 for a valid rental.", e.getMessage());
        }
    }
}
