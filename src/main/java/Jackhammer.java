public class Jackhammer extends Tool {
    // Constants for the Chainsaw tool class
    private static final String RIDGID = "Ridgid";
    private static final String JAKR = "JAKR";
    private static final String DEWALT = "DeWalt";
    private static final String JAKD = "JAKD";
    private static final boolean WEEKEND_CHARGE = false;
    private static final boolean HOLIDAY_CHARGE = false;
    public static final double CHARGE = 2.99;

    // Constructor
    Jackhammer(String code) {
        this.toolCode = code;
        if(code.equals(JAKR)) {
            this.brand = RIDGID;
        } else if(code.equals(JAKD)) {
            this.brand = DEWALT;
        }
        this.dailyCharge = CHARGE;
        this.isWeekendCharged = WEEKEND_CHARGE;
        this.isHolidayCharged = HOLIDAY_CHARGE;
    }
}
