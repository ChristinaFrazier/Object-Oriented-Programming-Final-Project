/**
 * This class holds all information about the delivery vehicle.
 * @author Lauren White
 * Date: 10/16/25
 * Assignment: Final Project
 */
class DeliveryVehicle {

    private String licensePlate;
    private String state;
    private String model;
    private String color;
    private int vehicleId;
    private DeliveryDriver owner;

    /**
     * This method is the constructor for this class.
     */
    public DeliveryVehicle (String licensePlate, String state, String model,
    String color, DeliveryDriver owner) {
        this.owner = new DeliveryDriver(owner.getName(), owner.getAge(), owner.getId());
        this.licensePlate = licensePlate;
        this.state = state;
        this.model = model;
        this.color = color;
        this.vehicleId  = owner.getId();
        
    }

    /**
     * This method will print a vehicle's information
     */
    public void printVehicleInfo () {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("State registered: " + state);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Vehicle Id: " + vehicleId);
        System.out.println("Owner: " + owner.getName());
    }

    /**
     * This method will get the state where the vehicle's registered.
     * @return Returns the state where the vehicle's registered as a string.
     */
    public String getState() {
        return state;
    }

    /**
     * This method will get vehicle's model.
     * @return Returns the vehicle's model as a string.
     */
    public String getModel() {
        return model;
    }

    /**
     * This method will get a vehicle's license plate.
     * @return Returns a vehicle's license plate as a string
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * This method gets the vehicle's color.
     * @return Returns the vehicle's color as a string.
     */
    public String getColor() {
        return color;
    }

    /**
     * This method gets the Vehicle id.
     * @return Returns the vehicles Id as an int.
     */
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * This method updates vehicle information.
     */
    public void updateVehicle(String licensePlate, String state, String model,
    String color, DeliveryDriver owner) {
        this.owner = new DeliveryDriver(owner.getName(), owner.getAge(), owner.getId());
        this.licensePlate = licensePlate;
        this.state = state;
        this.model = model;
        this.color = color;
        this.vehicleId  = owner.getId();
    }

}
