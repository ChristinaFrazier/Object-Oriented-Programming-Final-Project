import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.System.currentTimeMillis;

/**
 * This class tracks transaction details and audit logs.
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CSCI 2210
 */
public class Transaction {
    private String transactionID;
    private int paymentID;
    private String status;
    private LocalDateTime timestamp;
    private String auditLog;

    /**
     * This method is the constructor for this class
     * @param paymentID The payment ID as an int
     */
    public Transaction(int paymentID) {
        this.paymentID = paymentID;
        this.transactionID = generateTransactionID();
        this.timestamp = LocalDateTime.now();
        this.status = "Initiated";
        this.auditLog = "";
        recordAuditTrail();
    }

    /**
     * This method generates a unique transaction ID
     * @return Return the transaction ID as a string
     */
    public String generateTransactionID() {
        return "TXN-" + currentTimeMillis();
    }

    /**
     * This method records an audit trail for the transaction
     */
    public void recordAuditTrail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String log = "[" + timestamp.format(formatter) + "] Transaction " + transactionID +
                " - Status: " + status + "\n";
        auditLog += log;
    }

    /**
     * This method retrieves transaction history
     * @return Returns transaction history as a string
     */
    public String retrieveTransactionHistory() {
        String history = "Transaction ID: " + transactionID + "\n";
        history += "Payment ID: " + paymentID + "\n";
        history += "Current Status: " + status + "\n";
        history += "Timestamp: " + timestamp.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")) + "\n";
        return history;
    }

    /**
     * This method displays transaction logs
     */
    public void displayTransactionLogs() {
        System.out.println("===== Transaction Logs =====");
        System.out.println(auditLog);
        System.out.println("============================");
    }

    /**
     * This method links the transaction to order and payment
     */
    public void linkToOrderAndPayment() {
        String log = "Transaction linked to Payment ID: " + paymentID + "\n";
        auditLog += log;
        System.out.println("Transaction Linked successfully.");
    }

    /**
     * This method updates the transaction status
     * @param newStatus The new status as a string
     */
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        recordAuditTrail();
    }

    /**
     * This method gets the transaction ID
     * @return Return the transaction ID as a string
     */
    public String getTransactionID() {
        return transactionID;
    }
}
