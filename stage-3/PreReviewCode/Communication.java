import java.util.Scanner;
/**
 * This class allows customers and drivers to communicate.
 * @author Lauren White
 * Date: 10/16/25
 * Assignment: Final Project
 */
class Communication {
    private Customer user1;
    private DeliveryDriver user2;

    /**
     * This method is the constructor for this class.
     * @param user1 A customer from the class Customer.
     * @param user2 A delivery driver from the class DeliveryDriver.
     */
    public Communication (Customer user1, DeliveryDriver user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    /**
     * This method allows a customer to communicate with the driver.
     */
    public void communicate() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the messaging section. Enter your messages and enter 'end' to stop");
        while(true) {
            System.out.println("Enter your message here " + user1.getName() + ": ");
            String fromUser1 = in.nextLine();
            if(fromUser1.toLowerCase().equals("end")) break;
            System.out.println("Enter your message here " + user2.getName() + ": ");
            String fromUser2 = in.nextLine();
            if(fromUser2.toLowerCase().equals("end")) break;
        } 
    }
}