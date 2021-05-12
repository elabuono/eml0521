public abstract class Tool {
    protected String toolCode;
    protected String brand;
    protected double dailyCharge;
    protected boolean isWeekendCharged;
    protected boolean isHolidayCharged;

    /**
     * Getter for tool code value.
     * @return String tool code
     */
    public String getToolCode() {
        return toolCode;
    }

    /**
     * Getter for brand name.
     * @return String brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Getter for daily charge value.
     * @return daily charge value in USD
     */
    public double getDailyCharge() {
        return dailyCharge;
    }

    /**
     * Getter for holiday charge
     * @return true if holiday is charged, false otherwise
     */
    public boolean isHolidayCharged() {
        return isHolidayCharged;
    }

    /**
     * Getter for weekend charge
     * @return true if weekend is charged, false otherwise
     */
    public boolean isWeekendCharged() {
        return isWeekendCharged;
    }
}
