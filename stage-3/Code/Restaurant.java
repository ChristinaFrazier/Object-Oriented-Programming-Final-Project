import java.util.Scanner;

/**
 * This class manages restaurant information.
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CSCI 2210
 */
public class Restaurant {
    private int restaurantID;
    private String name;
    private String phoneNumber;
    private String openingTime;
    private String closingTime;
    private float baseDeliveryFee;
    private Menu menu;

    /**
     * This method is the constructor for this class
     * @param restaurantID The restaurant ID as an int
     * @param name The restaurant name as a string
     * @param phoneNumber The phone number as a string
     * @param openingTime The opening time as a string
     */
    public Restaurant(int restaurantID, String name, String phoneNumber, String openingTime) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.openingTime = openingTime;
        this.closingTime = "10:00 PM";
        this.baseDeliveryFee = 5.00f;
        this.menu = new Menu(restaurantID * 100, restaurantID);
    }

    /**
     * This method adds a new restaurant
     */
    public void addRestaurant() {
        System.out.println("Restaurant '" + name + "' has been added to the system.");
    }

    /**
     * This method updates restaurant information.
     */
    public void updateRestaurant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new phone number: ");
        this.phoneNumber = scanner.nextLine();

        System.out.print("Enter new opening time: ");
        this.openingTime = scanner.nextLine();

        System.out.print("Enter new closing time: ");
        this.closingTime = scanner.nextLine();

        System.out.println("Restaurant information updated.");
    }

    /**
     * This method removes a restaurant.
     */
    public void removeRestaurant() {
        this.name = null;
        this.phoneNumber = null;
        System.out.println("Restaurant removed from system.");
    }

    /**
     * This method displays operating hours.
     * @return Returns operating hours as a string.
     */
    public String displayOperatingHours() {
        return "Hours: " + openingTime + " - " + closingTime;
    }

    /**
     * This method calculates delivery fee.
     * @return Returns the delivery fee as a float.
     */
    public float calculateDeliveryFee() {
        return baseDeliveryFee;
    }

    /**
     * This method provides restaurant information.
     * @return Returns restaurant info as a string.
     */
    public String provideRestaurantInfo() {
        String info = "\n===== Restaurant Information =====\n";
        info += "Name: " + name + "\n";
        info += "Phone: " + phoneNumber + "\n";
        info += displayOperatingHours() + "\n";
        info += "Delivery Fee: $" + baseDeliveryFee + "\n";
        info += "==================================\n";
        return info;
    }

    /**
     * This method gets the restaurant ID
     * @return Returns the Restaurant ID as an int
     */
    public int getRestaurantID() {
        return restaurantID;
    }

    /**
     * This method gets the restaurant name
     * @return Returns the restaurant name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the restaurant's menu
     * @return Return the Menu object
     */
    public Menu getMenu() {
        return menu;
    }
}
