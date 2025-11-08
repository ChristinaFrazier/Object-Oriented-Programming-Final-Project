import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * This class handles payment processing and tracking
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CSCI 2210
 */
public class Payment {
    private int paymentID;
    private int orderID;
    private float totalAmount;
    private float taxAmount;
    private float deliveryFee;
    private String status;
    private LocalDateTime paymentDate;
    private PaymentMethod paymentMethod;

    /**
     * This method is the constructor for this class
     * @param paymentID The payment ID as an int
     * @param orderID The order ID as an int
     */
    public Payment(int paymentID, int orderID) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.status = "Pending";
        this.totalAmount = 0.0f;
        this.taxAmount = 0.0f;
        this.deliveryFee = 0.0f;
    }

    /**
     * This method process the payment
     */
    public void processPayment() {
        if (paymentMethod != null) {
           this.paymentDate = LocalDateTime.now();
           this.status = "Processing";
           System.out.println("Payment is being processed...");
        } else {
            System.out.println("Please select a payment method first.");
        }
    }

    /**
     * This method calculates the total payment amount
     */
    public void calculateTotal() {
        totalAmount = totalAmount + taxAmount + deliveryFee;
    }

    /**
     * This method gets the total amount for a payment
     * @return Returns the total amount as a float
     */
    public float getTotal() {
        return totalAmount;
    }

    public boolean confirmPayment() {
        if (status.equals("Processing")) {
            this.status = "Completed";
            System.out.println("Payment confirmed!");
            return true;
        }
        System.out.println("Payment could not be confirmed.");
        return false;
    }

    /**
     * This method generates a receipt
     * @return Returns the receipt as a string
     */
    public String generateReceipt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String receipt = "\n===== RECEIPT =====\n";
        receipt += "Payment ID: " + paymentID + "\n";
        receipt += "Order ID: " + orderID + "\n";
        receipt += "Subtotal: $" + (totalAmount - taxAmount - deliveryFee) + "\n";
        receipt += "Tax: $" + taxAmount + "\n";
        receipt += "Delivery Fee: $" + deliveryFee + "\n";
        receipt += "Total: $" + totalAmount + "\n";

        if (paymentDate != null) {
            receipt += "Date: " + paymentDate.format(formatter) + "\n";
        }

        receipt += "Status: " + status + "\n";
        receipt += "==================\n";
        return receipt;
    }

    /**
     * This method updates the payment status
     * @param newStatus The most recent payment status
     */
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Payment status updated to: " + status);
    }

    /**
     * This method sets the payment method
     * @return Returns payment records as a string
     */
    public String retrievePaymentRecords() {
        return generateReceipt();
    }

    /**
     * This method sets the payment method.
     * @param method The payment method from PaymentMethod class.
     */
    public void setPaymentMethod(PaymentMethod method) {
        this.paymentMethod = method;
    }

    /**
     * This method sets the tax amount.
     * @param tax The tax amount as a float.
     */
    public void setTaxAmount(float tax) {
        this.taxAmount = tax;
    }

    /**
     * This method sets the delivery fee.
     * @param fee The delivery fee as a float.
     */
    public void setDeliveryFee(float fee) {
        this.deliveryFee = fee;
    }

    /**
     * This method sets the subtotal amount.
     * @param amount The subtotal as a float.
     */
    public void setSubtotal(float amount) {
        this.totalAmount = amount;
    }
}

