import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class holds a customer's information
 * @author Lauren White
 * Assignment: Final Project, CSCI 2210
 * Date: 10/15/25
 */
class Customer extends Person {

    private ArrayList<String> allergies;
    private String address;

    
    /**
     * This method is the constructor for this class.
     * @param name A customer's name as a string.
     * @param age A customer's age as an integer
     */
    public Customer (String name, int age) {
        super(name, age);
        allergies = new ArrayList<>();

    }

    /**
     * This method allows the user to enter their allergies.
     */
    public void addAllergy() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an allergy. Enter 'end' when done.");
        while (true) {
            String allergy = in.nextLine();
            // Determines if the user has ended the list.
            if (!allergy.equals("end")) {
                allergies.add(allergy);
            } else {
                System.out.println("Allergies added successfully.");
                break;
            }
        }
    }

    /**
     * This method gets a customer's full list of allergies.
     * @return Returns a list of allergies as a string.
     */
    public ArrayList<String> getAllergies() {
        return this.allergies;
    }

    /**
     * This method allows a user to remove an allergy.
     */
    public void removeAllergy() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an allergy to delete. Enter 'end' when done.");
        while (true) {
            String allergy = in.nextLine();
            // Determines if the user has ended the list.
            if (!allergy.equals("end")) {
                allergies.remove(allergy);
            } else {
                System.out.println("Allergies removed successfully.");
                break;
            }
        }
    }
    
    /**
     * This method gets the customer's home address.
     * @return A customer's home address as a string.
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method allows users to enter an address.
     */
    public void enterAddress () {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter customer address: ");
        String userAddress = in.nextLine();
        this.address = userAddress;
    }

    /**
     * This method changes the user's address.
     * @param address An address as a string
     */
    public void setAddress(String address) {
        this.address = address;
    }
 

}
