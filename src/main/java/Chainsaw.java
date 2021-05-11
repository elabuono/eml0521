public class Chainsaw extends Tool {
    /* Constants for the Chainsaw tool class */
    private static final String TOOL_CODE = "CHNS";
    private static final String BRAND = "Stihl";
    private static final boolean WEEKEND_CHARGE = false;
    private static final boolean HOLIDAY_CHARGE = true;
    public static final double CHARGE = 1.49;

    Chainsaw() {
        this.toolCode = TOOL_CODE;
        this.brand = BRAND;
        this.dailyCharge = CHARGE;
        this.isWeekendCharged = WEEKEND_CHARGE;
        this.isHolidayCharged = HOLIDAY_CHARGE;
    }
}
