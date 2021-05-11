import java.util.Scanner;

public class POS {
    /* Constants for available tools */
    private static final String LADDER_LADW = "LADW";
    private static final String CHAINSAW_CHNS = "CHNS";
    private static final String JACKHAMMER_JAKR = "JAKR";
    private static final String JACKHAMMER_JAKD = "JAKD";

    /**
     * Checkout functionality for POS. Generates a Rental Agreement for outputting to the user.
     * @param toolCode string representation of the tool
     * @param rentalDays int number of days
     * @param discount int representing discount percentage
     * @param checkoutDate string for the current check-out date in mm/DD/yyyy
     */
    public static RentalAgreement checkout(String toolCode, int rentalDays, int discount, String checkoutDate)  {
        if(rentalDays < 1) {
            throw new UnsupportedOperationException("Rental days must be 1 or more for a valid rental.");
        }
        if(discount > 100 || discount < 0) {
            throw new UnsupportedOperationException("Discount must be within the range of 0-100 for a valid rental.");
        }
        switch(toolCode) {
            case LADDER_LADW:
                Tool ladder = new Ladder();
                return new RentalAgreement(ladder, rentalDays, discount, checkoutDate);
            case CHAINSAW_CHNS:
                Tool chainsaw = new Chainsaw();
                System.out.println();
                return new RentalAgreement(chainsaw, rentalDays, discount, checkoutDate);
            case JACKHAMMER_JAKD:
                Tool jackhammerD = new Jackhammer(JACKHAMMER_JAKD);
                return new RentalAgreement(jackhammerD, rentalDays, discount, checkoutDate);
            case JACKHAMMER_JAKR:
                Tool jackhammerR = new Jackhammer(JACKHAMMER_JAKR);
                return new RentalAgreement(jackhammerR, rentalDays, discount, checkoutDate);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        int in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your option:\n" +
                "1: Checkout Tool\n" +
                "2: Exit POS");
        in = scanner.nextInt();
        if(in == 2) {
            System.out.println("Thank you for using our POS.\n" +
                    "Goodbye!");
            System.exit(0);
        }
        if(in == 1) {
            System.out.println("Enter tool code: ");
            String toolCode = scanner.next();
            System.out.println("Enter number of day(s) for rental: ");
            int rentalDays = scanner.nextInt();
            System.out.println("Enter discount percentage as an integer (ex: 15 for 15%): ");
            int discount = scanner.nextInt();
            System.out.println("Enter check-out date in MM/dd/yyyy format (ex: 12/25/2020): ");
            String checkoutDate = scanner.next();
            System.out.println("Generating rental agreement...");
            RentalAgreement ra = checkout(toolCode, rentalDays, discount, checkoutDate);
            System.out.println(ra.generateRentalReport());
            System.out.println("\nThank you!");
        }

    }
}
