import java.util.Scanner;

/**
 * This class manages support staff and customer service.
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CS2210
 */
public class SupportStaff extends Person {
    private int supportStaffID;
    private String issueType;
    private String ticketStatus;
    private boolean availability;
    private float responseTime;
    private float satisfactionRating;
    private int customerID;
    private int OrderID;

    /**
     * This method is the constructor for this class
     * @param name The staff's member name as a string
     * @param age The staff's member age as an int
     * @param supportStaffID The support staff ID as an int
     * @param issueType The customer ID as an int
     * @param customerID The type of issue as a string
     */
    public SupportStaff(String name, int age, int supportStaffID, int customerID, String issueType) {
        super(name, age);
        this.supportStaffID = supportStaffID;
        this.customerID = customerID;
        this.issueType = issueType;
        this.availability = true;
        this.ticketStatus = "Open";
        this.responseTime = 0.0f;
        this.satisfactionRating = 0.0f;
    }

    /**
     * This method updates support staff information
     */
    public void updateSupportStaff() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Update availability (true/false): ");
        this.availability = scanner.nextBoolean();

        System.out.println("Support staff information updated.");
    }


    /**
     * This method assist a customer
     */
    public void assistCustomer() {
        if (availability) {
            System.out.println(getName() + " is now assisting customer ID: " + customerID);
            this.availability = false;
        } else {
            System.out.println(getName() + " is currently unavailable");
        }
    }

    /**
     * This method assigns an issue to the staff member
     */
    public void assignIssue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter issue type: ");
        this.issueType = scanner.nextLine();

        System.out.println("Enter Order ID: ");
        this.OrderID = scanner.nextInt();

        this.ticketStatus = "Assigned";
        System.out.println("Issue assigned to: " + getName());
    }

    public void updateIssueStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current status: " + ticketStatus);
        System.out.println("Select new status:");
        System.out.println("1. Open");
        System.out.println("2. In Progress");
        System.out.println("3. Resolved");
        System.out.println("4. Closed");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                this.ticketStatus = "Open";
                break;
            case 2:
                this.ticketStatus = "In Progress";
                break;
            case 3:
                this.ticketStatus = "Resolved";
                break;
            case 4:
                this.ticketStatus = "Closed";
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println("Status updated to: " + ticketStatus);
    }

    /**
     * This method tracks the response time
     */
    public void trackResponseTime() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter response time (in minutes): ");
        this.responseTime = scanner.nextFloat();

        System.out.println("Response time recorded: " + responseTime + " minutes");
    }

    /**
     * This method resolves an issue
     */
    public void resolveIssue() {
        this.ticketStatus = "Resolved";
        this.availability =  true;
        System.out.println("Issue resolved by " + getName());
        System.out.println(getName() + " is now available for new issues.");
    }

    /**
     * This method stores the customer order information
     */
    public void storeCustomerOrderInfo() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Order ID: " + OrderID);
        System.out.println("Issue type: " + issueType);
        System.out.println("Ticket status: " + ticketStatus);
    }

    /**
     * This method gets the staff ID
     * @return Return the staff ID as an int
     */
    public int getSupportStaffID() {
        return supportStaffID;
    }

    /**
     * This method gets the availability status
     * @return Returns true if available, false otherwise
     */
    public boolean isAvailable() {
        return availability;
    }

    /**
     * This method displays the staff information
     * @return Return staff info as a string
     */
    @Override
    public String toString() {
        return "Staff ID: " + supportStaffID + " | Name: " +getName() +
                " | Available: " + availability + " | Status: " + ticketStatus;
    }
}
