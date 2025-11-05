import java.util.Scanner;

/**
 * This class manages payment methods for customers.
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CS2210
 */
public class PaymentMethod {
    private int methodID;
    private int customerID;
    private String methodType;
    private String cardNumber;
    private String expirationDate;
    private boolean isDefault;

    /**
     * This method is the constructor for this class
     * @param methodID The payment method ID as an int
     * @param customerID The customer ID as an int
     */
    public PaymentMethod(int methodID, int customerID) {
        this.methodID = methodID;
        this.customerID = customerID;
        this.isDefault = false;
    }

    /**
     * This method allows the user to select a payment method
     */
    public void selectPaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Cash");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                this.methodType = "Credit Card";
                break;
            case 2:
                this.methodType = "Debit Card";
                break;
            case 3:
                this.methodType = "Cash";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Payment method set to: " + methodType);
    }

    /**
     * This method adds a new payment method
     */
    public void addPaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card type (Credit/Debit): ");
        this.methodType = scanner.nextLine();

        System.out.println("Enter card number: ");
        this.cardNumber = scanner.nextLine();

        System.out.print("Enter expiration date (MM/YY): ");
        this.expirationDate = scanner.nextLine();

        System.out.println("Payment method added successfully.");
    }

    /**
     * This method updates an existing payment method
     */
    public void updatePaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new card number: ");
        this.cardNumber = scanner.nextLine();
        System.out.print("Enter new expiration date (MM/YY): ");
        this.expirationDate = scanner.nextLine();
        System.out.println("Payment method updated successfully.");
    }

    /**
     * This method removes a payment method
     */
    public void removePaymentMethod() {
        this.cardNumber = null;
        this.expirationDate = null;
        this.methodType = null;
        System.out.println("Payment method removed.");
    }

    /**
     * This method validates a card
     * @return Returns true if card is valid, false otherwise
     */
    public boolean validateCard() {
        if (cardNumber != null && cardNumber.length() >= 13 && expirationDate != null) {
            System.out.println("Card validated successfully.");
            return true;
        }
        System.out.println("Card validation failed.");
        return false;
    }

    /**
     * This method gets the method type.
     * @return Returns the payment method type as a string.
     */
    public String getMethodType() {
        return methodType;
    }

    /**
     * This method sets this payment method as default.
     * @param isDefault True if default, false otherwise.
     */
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
