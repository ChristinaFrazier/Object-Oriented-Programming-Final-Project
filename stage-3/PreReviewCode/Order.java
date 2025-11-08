/**
 * This class holds all information about placed orders.
 * @author Lauren White
 * Date: 10/16/25
 * Assignment: Final Project
 */
class Order {
    private String specialInstructions;
    private float orderTotal;
    private String orderStatus;
    private String deliveryAddress;
    private Customer customer;
    private String time;
    private String date;
    
    /**
     * This method is the constructor for this class.
     * @param customer A customer from the class customer.
     */
    public Order (Customer customer) {
        this.deliveryAddress = customer.getAddress(); 
        this.customer = customer;
        this.orderStatus = "Pending";
        this.specialInstructions = null;
    }

    /**
     * This method will set the special delivery instructions for this order.
     * @param specialInstructions A set of delivery instructions for the order as a string.
     */
    public void setSpecialInstructions (String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * This method gets the special instructions for this delivery.
     * @return Returns special instructions as a string.
     */
    public String getSpecialInstructions () {
        if (specialInstructions == null) {
            return "There are no special delivery instructions";
        }
        return specialInstructions;
    }

    /**
     * This method gets the delivery address of a customer
     * @return Returns the delivery address of a customer as a string.
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * This method will change the delivery address for this order
     * @param newAddress The new address as a string.
     */
    public void changeDeliveryAddress(String newAddress) {
        this.deliveryAddress = newAddress;
    }

    /**
     * This method will display the total for this order.
     * @param total The payment total from the payment class.
     */
    public float getTotal(Payment total) {
        orderTotal = total.getTotal();
        return 0;
    }

    /**
     * This method will update the order's status.
     * @param status An order's status as a String.
     */
    public void updateOrderStatus (String status) {
        this.orderStatus = status;
    }

    /**
     * This get's the order's status
     * @return Returns the order's status as a string.
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method sets the time and date of the order.
     * @param time The order's time as a string.
     * @param date The order's date as a string.
     */
    public void setTimeAndDate(String time, String date) {
        this.time = time;
        this.date = date;
    }

    /**
     * This method gets the time and date of the order.
     * @return Returns the order's date and time as a string.
     */
    public String getTimeAndDate() {
        return time + ", " + date;
    }

    /**
     * This method displays all the order's information.
     */
    public void printOrderInfo() {
        System.out.println("Time and date placed: " + getTimeAndDate());
        System.out.println("Order total: " + orderTotal);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Special instructions: " + getSpecialInstructions());
        System.out.println("Current order status: " + orderStatus);
    }

    /**
     * This method prints the confirmation if the user accepts.
     */
    public void printConfirmation() {
        updateOrderStatus("Placed");
        printOrderInfo();
        System.out.println("Order Received!");
    }


}
