public abstract class Tool {
    protected String toolCode;
    protected String brand;
    protected double dailyCharge;
    protected boolean isWeekendCharged;
    protected boolean isHolidayCharged;

    public String getToolCode() {
        return toolCode;
    }

    public String getBrand() {
        return brand;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public boolean isHolidayCharged() {
        return isHolidayCharged;
    }

    public boolean isWeekendCharged() {
        return isWeekendCharged;
    }
}
