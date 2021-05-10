public class Ladder extends Tool {
    // Constants for the Ladder tool class
    private static final String TOOL_CODE = "LADW";
    private static final String BRAND = "Werner";
    private static final boolean WEEKEND_CHARGE = true;
    private static final boolean HOLIDAY_CHARGE = false;
    public static final double CHARGE = 1.99;

    // Constructor
    Ladder() {
        this.toolCode = TOOL_CODE;
        this.brand = BRAND;
        this.dailyCharge = CHARGE;
        this.isWeekendCharged = WEEKEND_CHARGE;
        this.isHolidayCharged = HOLIDAY_CHARGE;
    }
}
