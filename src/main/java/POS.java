import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class POS {
    // Constants for available tools
    private static final String LADDER_LADW = "LADW";
    private static final String CHAINSAW_CHNS = "CHNS";
    private static final String JACKHAMMER_JAKR = "JAKR";
    private static final String JACKHAMMER_JAKD = "JAKD";


    /**
     * Checkout functionality for POS. Generates a Rental Agreement.
     * @param toolCode
     * @param rentalDays
     * @param discount
     * @param checkoutDate
     */
    public RentalAgreement checkout(String toolCode, int rentalDays, int discount, String checkoutDate) throws Exception {
        if(rentalDays < 1) {
            throw new UnsupportedOperationException("Rental days must be 1 or more for a valid rental.");
        }
        if(discount > 100 || discount < 0) {
            throw new UnsupportedOperationException("Discount must be within the range of 0-100 for a valid rental.");
        }

        System.out.println(toolCode);


        return null;
    }

    public static void main(String[] args) throws Exception {
        int in = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your option:\n1: Checkout Tool\n2: Exit POS");
        in = scanner.nextInt();
        if(in == 2) {
            System.out.println("Thank you for using our POS.\nGoodbye!");
            System.exit(0);
        }
        if(in == 1) {
            System.out.println("Enter tool code: ");
            String toolcode = scanner.next();
            System.out.println("Enter number of day(s) for rental: ");
            int rentalDays = scanner.nextInt();
            System.out.println("Enter discount percentage as an integer (ex: 15 for 15%): ");
            int discount = scanner.nextInt();
            System.out.println("Enter check-out date in dd/MM/yyyy format (ex: 12/25/2020): ");
            String checkoutDate = scanner.next();
            System.out.println("Generating rental agreement...");
        }

    }
}
