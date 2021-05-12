import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class POSTest {
    POS pos;

    @BeforeEach
    public void createPOS() {
        pos = new POS();
    }

    @Test
    @DisplayName("Checkout should throw exception, not generate Rental Agreement with >100% discount")
    public void test1() {
        try {
            pos.checkout("JAKR", 5, 101, "9/3/15");
            fail("UnsupportedOperationException should be thrown.");
        } catch (Exception e) {
            // expected behavior
            assertEquals("Discount must be within the range of 0-100 for a valid rental.", e.getMessage());
        }
    }

    @Test
    @DisplayName("LADW with 1 free holiday and 10% discount should deduct 1 charge day and 10% discount")
    public void test2() {
        RentalAgreement ra = pos.checkout("LADW", 3, 10, "7/2/20");
        assertEquals("LADW", ra.tool.getToolCode());
        assertEquals("Werner", ra.tool.getBrand());
        assertEquals(3, ra.rentalDays);
        assertEquals(LocalDate.parse("2020-07-02"), ra.checkoutDate);
        assertEquals(LocalDate.parse("2020-07-05"), ra.dueDate);
        assertEquals(1.99, ra.tool.getDailyCharge());
        assertEquals(2, ra.chargeDays);
        assertEquals(3.98, ra.preDiscountAmount);
        assertEquals(10, ra.discount);
        assertEquals(0.40, ra.discountAmount);
        assertEquals(3.58, ra.finalCharge);
    }

    @Test
    @DisplayName("CHNS with 2 free weekend days and 25% discount should deduct 2 charge days and 25% discount")
    public void test3() {
        RentalAgreement ra= pos.checkout("CHNS", 5, 25, "7/2/15");
        assertEquals("CHNS", ra.tool.getToolCode());
        assertEquals("Stihl", ra.tool.getBrand());
        assertEquals(5, ra.rentalDays);
        assertEquals(LocalDate.parse("2015-07-02"), ra.checkoutDate);
        assertEquals(LocalDate.parse("2015-07-07"), ra.dueDate);
        assertEquals(1.49, ra.tool.getDailyCharge());
        assertEquals(3, ra.chargeDays);
        assertEquals(4.47, ra.preDiscountAmount);
        assertEquals(25, ra.discount);
        assertEquals(1.12, ra.discountAmount);
        assertEquals(3.35, ra.finalCharge);
    }

    @Test
    @DisplayName("JAKD with 2 free weekend days and 1 holiday should deduct 3 charge days total")
    public void test4() {
        RentalAgreement ra = pos.checkout("JAKD", 6, 0, "9/3/15");
        assertEquals("JAKD", ra.tool.getToolCode());
        assertEquals("DeWalt", ra.tool.getBrand());
        assertEquals(6, ra.rentalDays);
        assertEquals(LocalDate.parse("2015-09-03"), ra.checkoutDate);
        assertEquals(LocalDate.parse("2015-09-09"), ra.dueDate);
        assertEquals(2.99, ra.tool.getDailyCharge());
        assertEquals(3, ra.chargeDays);
        assertEquals(8.97, ra.preDiscountAmount);
        assertEquals(0, ra.discount);
        assertEquals(0, ra.discountAmount);
        assertEquals(8.97, ra.finalCharge);
    }

    @Test
    @DisplayName("JAKR with 3 free weekend days and 1 holiday should deduct 4 days total")
    public void test5() {
        RentalAgreement ra = pos.checkout("JAKR", 9, 0, "7/2/15");
        assertEquals("JAKR", ra.tool.getToolCode());
        assertEquals("Ridgid", ra.tool.getBrand());
        assertEquals(9, ra.rentalDays);
        assertEquals(LocalDate.parse("2015-07-02"), ra.checkoutDate);
        assertEquals(LocalDate.parse("2015-07-11"), ra.dueDate);
        assertEquals(2.99, ra.tool.getDailyCharge());
        assertEquals(5, ra.chargeDays);
        assertEquals(14.95, ra.preDiscountAmount);
        assertEquals(0, ra.discount);
        assertEquals(0, ra.discountAmount);
        assertEquals(14.95, ra.finalCharge);
    }

    @Test
    @DisplayName("JAKR with 2 free weekend days and 1 holiday should deduct 3 days, only charge 1 day with 50% discount")
    public void test6() {
        RentalAgreement ra = pos.checkout("JAKR", 4, 50, "7/2/20");
        assertEquals("JAKR", ra.tool.getToolCode());
        assertEquals("Ridgid", ra.tool.getBrand());
        assertEquals(4, ra.rentalDays);
        assertEquals(LocalDate.parse("2020-07-02"), ra.checkoutDate);
        assertEquals(LocalDate.parse("2020-07-06"), ra.dueDate);
        assertEquals(2.99, ra.tool.getDailyCharge());
        assertEquals(1, ra.chargeDays);
        assertEquals(2.99, ra.preDiscountAmount);
        assertEquals(50, ra.discount);
        assertEquals(1.50, ra.discountAmount);
        assertEquals(1.49, ra.finalCharge);
    }

}
