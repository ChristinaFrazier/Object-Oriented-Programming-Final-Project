import java.util.ArrayList;
/**
 * This class manages people's information.
 * @author Lauren White
 * Date:
 * Assignment: Final Project, CSCI 2210
 */
class PersonManager {

    private ArrayList<DeliveryDriver> drivers;
    private ArrayList<Customer> customers;
    private ArrayList<SupportStaff> staff;
    
    /**
     * This method is the constructor for this class.
     */
    public PersonManager() {
        drivers = new ArrayList<>();
        customers = new ArrayList<>();
        staff = new ArrayList<>();
    }
    
    /**
     * This method adds new drivers.
     * @param driver A delivery driver from the Delivery Driver class.
     */
    public void addDriver(DeliveryDriver driver) {
        drivers.add(driver);
        System.out.println("Driver added.");
    }

    /**
     * This method adds new customers.
     * @param customer A customer from the Customer class.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added.");

    }
    
    /**
     * This method adds new staff.
     * @param staff A staff member from the Support Staff class.
     */
    public void addStaff(SupportStaff staff) {
        this.staff.add(staff);
        System.out.println("Staff added.");

    }

    /**
     * This method removes drivers.
     * @param driver A delivery driver from the Delivery Driver class.
     */
    public void removeDriver(DeliveryDriver driver) {
        drivers.remove(driver.getId());
        System.out.println("Driver removed.");
    }

    /**
     * This method will remove a customer and a customer's information.
     * @param customer A customer from the class Customer.
     */
    public void removeCustomer(Customer customer) {
        // Remove the customer's information.
        customer.setName(null);
        customer.setAddress(null);
        customer.setEmail(null);
        customer.setAge(0);
        // Remove the customer from the list.
        customers.remove(customers.indexOf(customer));
        System.out.println("Account deleted.");
    }

    /**
     * This method will show all the staff fromt the class SupportStaff.
     */
    public void showAllStaff() {
        if (staff.isEmpty()) {
            System.out.println("There are no staff members.");
        } else {
            for(int i = 0; i < staff.size(); i++) {
                System.out.println(staff.get(i));
            }
        }
    }

    /**
     * This method displays all delivery drivers.
     */
    public void showAllDrivers() {
        if (drivers.isEmpty()) {
            System.out.println("There are no drivers.");
        } else {
            for(int i = 0; i < drivers.size(); i++) {
                System.out.println(drivers.get(i));
            }
        }
    }

    /**
     * This method displays the amount of customers using the service.
     */
    public void showNumberOfCustomers() {
        System.out.println("Amount of customers: " + customers.size());

    }
    
}
