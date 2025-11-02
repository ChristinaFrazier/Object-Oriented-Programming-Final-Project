import java.util.ArrayList;
/**
 * This class holds all information about the delivery driver.
 * @author Lauren White
 * Date: 10/16/25
 * Assignment: Final Project
 */
class DeliveryDriver extends Person {

    private int employeeId;
    private ArrayList<Integer> ratings;

    /**
     * This method is the constructor for this class.
     * @param name The driver's name as a string.
     * @param age The driver's age as an int.
     * @param id The driver's employee ID.
     */
    public DeliveryDriver(String name, int age, int id) {
        super(name, age);
        this.employeeId = id;
        this.ratings = new ArrayList<>();
    }

    /**
     * This method will get an employee's ID.
     */
    public int getId() {
        return employeeId;
    }

    /**
     * This method adds a rating to the driver's status.
     * @param stars The driver's rating as the class Rating.
     */
    public void addRating(int stars) {
        ratings.add(stars);
    }

    /**
     * This method will display the driver's ratings.
     */
    public void viewRatings() {
        System.out.println("Ratings for " + getName() + ":");
        for(int i = 0; i < ratings.size(); i++) {
            System.out.println(ratings.get(i));
        }
    }

}