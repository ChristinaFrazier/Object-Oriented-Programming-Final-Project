import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the Food Delivery Management System.
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CSCI2210
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PersonManager personManager = new PersonManager();
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Payment> payments = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<DeliveryDriver> drivers = new ArrayList<>();
    private static ArrayList<SupportStaff> supportStaff = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   FOOD DELIVERY MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        // Create initial dummy data
        initializeDummyData();

        // Display main menu
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    manageCustomers();
                    break;
                case 2:
                    manageDrivers();
                    break;
                case 3:
                    manageRestaurants();
                    break;
                case 4:
                    manageOrders();
                    break;
                case 5:
                    manageSupportStaff();
                    break;
                case 6:
                    managePayments();
                    break;
                case 7:
                    viewReports();
                    break;
                case 8:
                    System.out.println("\n========================================");
                    System.out.println("Thank you for using the Food Delivery Management System!");
                    System.out.println("========================================\n");
                    running = false;
                    break;
                default:
                    System.out.println("\n[X] Invalid choice. Please try again.\n");
            }
        }
        scanner.close();
    }

    /**
     * This method initializes dummy data for testing.
     */
    private static void initializeDummyData() {
        System.out.println(" Initializing system with dummy data...\n");

        // Create customers
        Customer customer1 = new Customer("John Smith", 28);
        customer1.setEmail("john@email.com");
        customer1.setAddress("123 Main St, Portales, NM");
        customers.add(customer1);
        personManager.addCustomer(customer1);

        Customer customer2 = new Customer("Sarah Johnson", 35);
        customer2.setEmail("sarah@email.com");
        customer2.setAddress("456 Oak Ave, Portales, NM");
        customers.add(customer2);
        personManager.addCustomer(customer2);

        Customer customer3 = new Customer("Michael Chen", 42);
        customer3.setEmail("michael@email.com");
        customer3.setAddress("789 Pine Rd, Portales, NM");
        customers.add(customer3);
        personManager.addCustomer(customer3);

        // Create delivery drivers
        DeliveryDriver driver1 = new DeliveryDriver("Mike Williams", 32, 1001);
        driver1.setEmail("mike@delivery.com");
        driver1.addRating(5);
        driver1.addRating(4);
        driver1.addRating(5);
        drivers.add(driver1);
        personManager.addDriver(driver1);

        DeliveryDriver driver2 = new DeliveryDriver("Lisa Brown", 27, 1002);
        driver2.setEmail("lisa@delivery.com");
        driver2.addRating(5);
        driver2.addRating(5);
        driver2.addRating(4);
        drivers.add(driver2);
        personManager.addDriver(driver2);

        // Create delivery vehicles
        DeliveryVehicle vehicle1 = new DeliveryVehicle("ABC123", "NM", "Toyota Camry", "Blue", driver1);
        DeliveryVehicle vehicle2 = new DeliveryVehicle("XYZ789", "NM", "Honda Civic", "Red", driver2);

        // Create support staff
        SupportStaff staff1 = new SupportStaff("Emma Davis", 29, 2001, 101, "General Support");
        staff1.setEmail("emma@support.com");
        supportStaff.add(staff1);
        personManager.addStaff(staff1);

        // Create restaurants with menus
        Restaurant restaurant1 = new Restaurant(1, "Pizza Palace", "575-555-0100", "11:00 AM");

        MenuItem pizza = new MenuItem(1, "Pepperoni Pizza", "Classic pepperoni with mozzarella", 12.99f);
        pizza.setAllergenInfo("Dairy, Gluten");
        pizza.setCategory("Main Course");
        restaurant1.getMenu().addMenuItem(pizza);

        MenuItem salad = new MenuItem(2, "Caesar Salad", "Fresh romaine with caesar dressing", 8.99f);
        salad.setAllergenInfo("Dairy");
        salad.setCategory("Appetizer");
        restaurant1.getMenu().addMenuItem(salad);

        MenuItem breadsticks = new MenuItem(5, "Garlic Breadsticks", "Warm breadsticks with garlic butter", 5.99f);
        breadsticks.setAllergenInfo("Gluten, Dairy");
        breadsticks.setCategory("Appetizer");
        restaurant1.getMenu().addMenuItem(breadsticks);

        MenuItem soda = new MenuItem(6, "Fountain Soda", "Choice of Coke, Sprite, or Dr. Pepper", 2.99f);
        soda.setCategory("Beverage");
        restaurant1.getMenu().addMenuItem(soda);

        restaurants.add(restaurant1);

        Restaurant restaurant2 = new Restaurant(2, "Burger Haven", "575-555-0200", "10:00 AM");

        MenuItem burger = new MenuItem(3, "Classic Burger", "Beef patty with lettuce and tomato", 10.99f);
        burger.setAllergenInfo("Gluten");
        burger.setCategory("Main Course");
        restaurant2.getMenu().addMenuItem(burger);

        MenuItem fries = new MenuItem(4, "French Fries", "Crispy golden fries", 4.99f);
        fries.setCategory("Appetizer");
        restaurant2.getMenu().addMenuItem(fries);

        MenuItem shake = new MenuItem(7, "Chocolate Milkshake", "Creamy chocolate shake", 4.99f);
        shake.setAllergenInfo("Dairy");
        shake.setCategory("Beverage");
        restaurant2.getMenu().addMenuItem(shake);

        MenuItem cheesecake = new MenuItem(8, "Cheesecake", "New York style cheesecake", 6.99f);
        cheesecake.setAllergenInfo("Dairy, Gluten");
        cheesecake.setCategory("Dessert");
        restaurant2.getMenu().addMenuItem(cheesecake);

        restaurants.add(restaurant2);

        // Create sample orders
        Order order1 = new Order(customer1);
        order1.setTimeAndDate("12:30 PM", "11/03/2025");
        order1.setSpecialInstructions("Ring doorbell twice");
        orders.add(order1);

        Order order2 = new Order(customer2);
        order2.setTimeAndDate("1:15 PM", "11/03/2025");
        order2.updateOrderStatus("In Progress");
        orders.add(order2);

        System.out.println("[OK] Dummy data initialized successfully!\n");
    }

    /**
     * This method displays the main menu.
     */
    private static void displayMainMenu() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("       MAIN MENU");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1.  Manage Customers");
        System.out.println("2.  Manage Delivery Drivers");
        System.out.println("3.  Manage Restaurants");
        System.out.println("4.  Manage Orders");
        System.out.println("5.  Manage Support Staff");
        System.out.println("6.  Manage Payments");
        System.out.println("7.  View Reports");
        System.out.println("8.  Exit");
        System.out.println("═══════════════════════════════════════");
        System.out.print("Enter your choice: ");
    }

    /**
     * This method manages customer operations.
     */
    private static void manageCustomers() {
        boolean back = false;
        while (!back) {
            System.out.println("\n───────────────────────────────────────");
            System.out.println("        CUSTOMER MANAGEMENT");
            System.out.println("───────────────────────────────────────");
            System.out.println("1. Add New Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer Address");
            System.out.println("4. Manage Customer Allergies");
            System.out.println("5. Delete Customer Account");
            System.out.println("6. Back to Main Menu");
            System.out.println("───────────────────────────────────────");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    viewAllCustomers();
                    break;
                case 3:
                    updateCustomerAddress();
                    break;
                case 4:
                    manageCustomerAllergies();
                    break;
                case 5:
                    deleteCustomerAccount();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("\n[X] Invalid choice. Please try again.\n");
            }
        }
    }

    private static void addNewCustomer() {
        System.out.println("\n--- Add New Customer ---");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer age: ");
        int age = getIntInput();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        Customer newCustomer = new Customer(name, age);
        newCustomer.setEmail(email);
        newCustomer.enterAddress();

        customers.add(newCustomer);
        personManager.addCustomer(newCustomer);
        System.out.println("\n[OK] Customer added successfully!");
    }

    private static void viewAllCustomers() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         ALL CUSTOMERS");
        System.out.println("═══════════════════════════════════════");

        if (customers.isEmpty()) {
            System.out.println("No customers in the system.");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println("\n Customer #" + (i + 1));
                System.out.println("   Name: " + customer.getName());
                System.out.println("   Age: " + customer.getAge());
                System.out.println("   Email: " + customer.getEmail());
                System.out.println("   Address: " + customer.getAddress());
                if (!customer.getAllergies().isEmpty()) {
                    System.out.println("   Allergies: " + customer.getAllergies());
                }
                System.out.println("───────────────────────────────────────");
            }
        }
    }

    private static void updateCustomerAddress() {
        if (customers.isEmpty()) {
            System.out.println("\n[X] No customers available.");
            return;
        }

        System.out.println("\n--- Update Customer Address ---");
        viewAllCustomers();
        System.out.print("\nEnter customer number to update: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < customers.size()) {
            System.out.print("Enter new address: ");
            String newAddress = scanner.nextLine();
            customers.get(index).setAddress(newAddress);
            System.out.println("\n[OK] Address updated successfully!");
        } else {
            System.out.println("\n[X] Invalid customer number.");
        }
    }

    private static void manageCustomerAllergies() {
        if (customers.isEmpty()) {
            System.out.println("\n[X] No customers available.");
            return;
        }

        System.out.println("\n--- Manage Customer Allergies ---");
        viewAllCustomers();
        System.out.print("\nEnter customer number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < customers.size()) {
            Customer customer = customers.get(index);
            System.out.println("\n1. Add Allergies");
            System.out.println("2. Remove Allergies");
            System.out.println("3. View Allergies");
            System.out.print("Enter choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    customer.addAllergy();
                    break;
                case 2:
                    customer.removeAllergy();
                    break;
                case 3:
                    System.out.println("\nAllergies: " + customer.getAllergies());
                    break;
                default:
                    System.out.println("\n[X] Invalid choice.");
            }
        } else {
            System.out.println("\n[X] Invalid customer number.");
        }
    }

    private static void deleteCustomerAccount() {
        if (customers.isEmpty()) {
            System.out.println("\nNo customers available.");
            return;
        }

        System.out.println("\n--- Delete Customer Account ---");
        viewAllCustomers();
        System.out.print("\nEnter customer number to delete: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < customers.size()) {
            Customer customer = customers.get(index);
            System.out.print("Are you sure you want to delete " + customer.getName() + "'s account? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                personManager.removeCustomer(customer);
                customers.remove(index);
                System.out.println("\nCustomer account deleted successfully!");
            } else {
                System.out.println("\nAccount deletion cancelled.");
            }
        } else {
            System.out.println("\nInvalid customer number.");
        }
    }

    /**
     * This method manages delivery driver operations.
     */
    private static void manageDrivers() {
        boolean back = false;
        while (!back) {
            System.out.println("\n───────────────────────────────────────");
            System.out.println("        DRIVER MANAGEMENT");
            System.out.println("───────────────────────────────────────");
            System.out.println("1. Add New Driver");
            System.out.println("2. View All Drivers");
            System.out.println("3. View Driver Ratings");
            System.out.println("4. Add Driver Rating");
            System.out.println("5. Back to Main Menu");
            System.out.println("───────────────────────────────────────");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addNewDriver();
                    break;
                case 2:
                    viewAllDrivers();
                    break;
                case 3:
                    viewDriverRatings();
                    break;
                case 4:
                    addDriverRating();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("\n[X] Invalid choice. Please try again.\n");
            }
        }
    }

    private static void addNewDriver() {
        System.out.println("\n--- Add New Driver ---");
        System.out.print("Enter driver name: ");
        String name = scanner.nextLine();
        System.out.print("Enter driver age: ");
        int age = getIntInput();
        System.out.print("Enter employee ID: ");
        int id = getIntInput();
        System.out.print("Enter driver email: ");
        String email = scanner.nextLine();

        DeliveryDriver newDriver = new DeliveryDriver(name, age, id);
        newDriver.setEmail(email);
        drivers.add(newDriver);
        personManager.addDriver(newDriver);
        System.out.println("\n[OK] Driver added successfully!");
    }

    private static void viewAllDrivers() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         ALL DRIVERS");
        System.out.println("═══════════════════════════════════════");

        if (drivers.isEmpty()) {
            System.out.println("No drivers in the system.");
        } else {
            for (int i = 0; i < drivers.size(); i++) {
                DeliveryDriver d = drivers.get(i);
                System.out.println("\n Driver #" + (i + 1));
                System.out.println("   Name: " + d.getName());
                System.out.println("   Age: " + d.getAge());
                System.out.println("   Employee ID: " + d.getId());
                System.out.println("   Email: " + d.getEmail());
                System.out.println("───────────────────────────────────────");
            }
        }
    }

    private static void viewDriverRatings() {
        if (drivers.isEmpty()) {
            System.out.println("\n[X] No drivers available.");
            return;
        }

        System.out.println("\n--- View Driver Ratings ---");
        viewAllDrivers();
        System.out.print("\nEnter driver number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < drivers.size()) {
            drivers.get(index).viewRatings();
        } else {
            System.out.println("\n[X] Invalid driver number.");
        }
    }

    private static void addDriverRating() {
        if (drivers.isEmpty()) {
            System.out.println("\n[X] No drivers available.");
            return;
        }

        System.out.println("\n--- Add Driver Rating ---");
        viewAllDrivers();
        System.out.print("\nEnter driver number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < drivers.size()) {
            System.out.print("Enter rating (1-5): ");
            int rating = getIntInput();
            if (rating >= 1 && rating <= 5) {
                drivers.get(index).addRating(rating);
                System.out.println("\n[OK] Rating added successfully!");
            } else {
                System.out.println("\n[X] Rating must be between 1 and 5.");
            }
        } else {
            System.out.println("\n[X] Invalid driver number.");
        }
    }

    /**
     * This method manages restaurant operations.
     */
    private static void manageRestaurants() {
        boolean back = false;
        while (!back) {
            System.out.println("\n───────────────────────────────────────");
            System.out.println("         RESTAURANT MANAGEMENT");
            System.out.println("───────────────────────────────────────");
            System.out.println("1. View All Restaurants");
            System.out.println("2. View Restaurant Menu");
            System.out.println("3. Filter Menu by Category");
            System.out.println("4. View Restaurant Details");
            System.out.println("5. Back to Main Menu");
            System.out.println("───────────────────────────────────────");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    viewAllRestaurants();
                    break;
                case 2:
                    viewRestaurantMenu();
                    break;
                case 3:
                    filterMenuByCategory();
                    break;
                case 4:
                    viewRestaurantDetails();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("\n[X] Invalid choice. Please try again.\n");
            }
        }
    }

    private static void viewAllRestaurants() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         ALL RESTAURANTS");
        System.out.println("═══════════════════════════════════════");

        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant r = restaurants.get(i);
            System.out.println("\n  Restaurant #" + (i + 1));
            System.out.println(r.provideRestaurantInfo());
        }
    }

    private static void viewRestaurantMenu() {
        if (restaurants.isEmpty()) {
            System.out.println("\n[X] No restaurants available.");
            return;
        }

        System.out.println("\n--- View Restaurant Menu ---");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }
        System.out.print("\nSelect restaurant: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < restaurants.size()) {
            Restaurant restaurant = restaurants.get(index);
            System.out.println("\n" + restaurant.getName() + " Menu:");
            restaurant.getMenu().displayAllMenuItems();
        } else {
            System.out.println("\n[X] Invalid restaurant number.");
        }
    }

    private static void filterMenuByCategory() {
        if (restaurants.isEmpty()) {
            System.out.println("\n[X] No restaurants available.");
            return;
        }

        System.out.println("\n--- Filter Menu by Category ---");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }
        System.out.print("\nSelect restaurant: ");
        int restaurantIndex = getIntInput() - 1;

        if (restaurantIndex < 0 || restaurantIndex >= restaurants.size()) {
            System.out.println("\n[X] Invalid restaurant number.");
            return;
        }

        Restaurant selectedRestaurant = restaurants.get(restaurantIndex);

        System.out.println("\nSelect category:");
        System.out.println("1. Appetizer");
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.println("4. Beverage");
        System.out.print("Enter choice: ");
        int categoryChoice = getIntInput();

        String category = "";
        switch (categoryChoice) {
            case 1: category = "Appetizer"; break;
            case 2: category = "Main Course"; break;
            case 3: category = "Dessert"; break;
            case 4: category = "Beverage"; break;
            default:
                System.out.println("\n[X] Invalid category choice.");
                return;
        }

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("    " + category + " Items");
        System.out.println("═══════════════════════════════════════");
        ArrayList<MenuItem> filteredItems = selectedRestaurant.getMenu().filterByCategory(category);

        if (!filteredItems.isEmpty()) {
            for (MenuItem item : filteredItems) {
                item.displayItemInfo();
                System.out.println("───────────────────────────────────────");
            }
        }
    }

    private static void viewRestaurantDetails() {
        if (restaurants.isEmpty()) {
            System.out.println("\n[X] No restaurants available.");
            return;
        }

        System.out.println("\n--- View Restaurant Details ---");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }
        System.out.print("\nSelect restaurant: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < restaurants.size()) {
            Restaurant restaurant = restaurants.get(index);
            System.out.println(restaurant.provideRestaurantInfo());
            System.out.println("Operating Hours: " + restaurant.displayOperatingHours());
            System.out.println("Delivery Fee: $" + restaurant.calculateDeliveryFee());
        } else {
            System.out.println("\n[X] Invalid restaurant number.");
        }
    }

    /**
     * This method manages order operations.
     */
    private static void manageOrders() {
        boolean back = false;
        while (!back) {
            System.out.println("\n───────────────────────────────────────");
            System.out.println("        ORDER MANAGEMENT");
            System.out.println("───────────────────────────────────────");
            System.out.println("1. Create New Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Update Order Status");
            System.out.println("4. View Order Details");
            System.out.println("5. Back to Main Menu");
            System.out.println("───────────────────────────────────────");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    createNewOrder();
                    break;
                case 2:
                    viewAllOrders();
                    break;
                case 3:
                    updateOrderStatus();
                    break;
                case 4:
                    viewOrderDetails();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("\n[X] Invalid choice. Please try again.\n");
            }
        }
    }

    private static void createNewOrder() {
        if (customers.isEmpty()) {
            System.out.println("\n[X] No customers available. Please add a customer first.");
            return;
        }

        System.out.println("\n--- Create New Order ---");
        viewAllCustomers();
        System.out.print("\nSelect customer number: ");
        int customerIndex = getIntInput() - 1;

        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("\n[X] Invalid customer number.");
            return;
        }

        Customer customer = customers.get(customerIndex);
        Order newOrder = new Order(customer);

        System.out.print("Enter order time (e.g., 12:30 PM): ");
        String time = scanner.nextLine();
        System.out.print("Enter order date (e.g., 11/03/2025): ");
        String date = scanner.nextLine();
        newOrder.setTimeAndDate(time, date);

        System.out.print("Enter special instructions (or press Enter to skip): ");
        String instructions = scanner.nextLine();
        if (!instructions.trim().isEmpty()) {
            newOrder.setSpecialInstructions(instructions);
        }

        orders.add(newOrder);
        System.out.println("\n[OK] Order created successfully!");
        System.out.println("Order ID: " + (orders.size()));
    }

    private static void viewAllOrders() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         ALL ORDERS");
        System.out.println("═══════════════════════════════════════");

        if (orders.isEmpty()) {
            System.out.println("No orders in the system.");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("\n Order #" + (i + 1));
                System.out.println("   Status: " + orders.get(i).getOrderStatus());
                System.out.println("   Time: " + orders.get(i).getTimeAndDate());
                System.out.println("───────────────────────────────────────");
            }
        }
    }

    private static void updateOrderStatus() {
        if (orders.isEmpty()) {
            System.out.println("\n[X] No orders available.");
            return;
        }

        System.out.println("\n--- Update Order Status ---");
        viewAllOrders();
        System.out.print("\nEnter order number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < orders.size()) {
            System.out.println("\nSelect new status:");
            System.out.println("1. Pending");
            System.out.println("2. Preparing");
            System.out.println("3. Out for Delivery");
            System.out.println("4. Delivered");
            System.out.println("5. Cancelled");
            System.out.print("Enter choice: ");
            int statusChoice = getIntInput();

            String status = "";
            switch (statusChoice) {
                case 1: status = "Pending"; break;
                case 2: status = "Preparing"; break;
                case 3: status = "Out for Delivery"; break;
                case 4: status = "Delivered"; break;
                case 5: status = "Cancelled"; break;
                default:
                    System.out.println("\n[X] Invalid choice.");
                    return;
            }

            orders.get(index).updateOrderStatus(status);
            System.out.println("\n[OK] Order status updated to: " + status);
        } else {
            System.out.println("\n[X] Invalid order number.");
        }
    }

    private static void viewOrderDetails() {
        if (orders.isEmpty()) {
            System.out.println("\n[X] No orders available.");
            return;
        }

        System.out.println("\n--- View Order Details ---");
        viewAllOrders();
        System.out.print("\nEnter order number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < orders.size()) {
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("       ORDER DETAILS");
            System.out.println("═══════════════════════════════════════");
            orders.get(index).printOrderInfo();
        } else {
            System.out.println("\n[X] Invalid order number.");
        }
    }

    /**
     * This method manages support staff operations.
     */
    private static void manageSupportStaff() {
        boolean back = false;
        while (!back) {
            System.out.println("\n───────────────────────────────────────");
            System.out.println("         SUPPORT STAFF MANAGEMENT");
            System.out.println("───────────────────────────────────────");
            System.out.println("1. View All Support Staff");
            System.out.println("2. Add New Support Staff");
            System.out.println("3. Assign Issue to Staff");
            System.out.println("4. Update Issue Status");
            System.out.println("5. Resolve Issue");
            System.out.println("6. View Staff Customer Info");
            System.out.println("7. Back to main menu");
            System.out.println("───────────────────────────────────────");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    viewAllSupportStaff();
                    break;
                case 2:
                    addNewSupportStaff();
                    break;
                case 3:
                    assignIssueToStaff();
                    break;
                case 4:
                    updateStaffIssueStatus();
                    break;
                case 5:
                    resolveStaffIssue();
                    break;
                case 6:
                    viewStaffCustomerInfo();
                    break;
                case 7:
                    back = true;
                    break;
                default:
                    System.out.println("\n[X] Invalid choice. Please try again.\n");
            }
        }
    }

    /**
     * This method is to show all the support staff member
     */
    private static void viewAllSupportStaff() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         ALL SUPPORT STAFF");
        System.out.println("═══════════════════════════════════════");

        if (supportStaff.isEmpty()) {
            System.out.println("No support staff in the system.");
        } else {
            for (int i = 0; i < supportStaff.size(); i++) {
                SupportStaff staff = supportStaff.get(i);
                System.out.println("\n Support Staff #" + (i + 1));
                System.out.println("   Name: " + staff.getName());
                System.out.println("   Age: " + staff.getAge());
                System.out.println("   Staff ID: " + staff.getSupportStaffID());
                System.out.println("   Email: " + staff.getEmail());
                System.out.println("   Available: " + (staff.isAvailable() ? "Yes" : "No"));
                System.out.println("───────────────────────────────────────");
            }
        }
    }

    /**
     * This method would allow user to add new support staff member
     */
    private static void addNewSupportStaff() {
        System.out.println("\n--- Add New Support Staff ---");
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff age: ");
        int age = getIntInput();
        System.out.print("Enter staff ID: ");
        int staffID = getIntInput();
        System.out.print("Enter staff email: ");
        String email = scanner.nextLine();
        System.out.print("Enter initial issue type (or 'None'): ");
        String issueType = scanner.nextLine();

        SupportStaff newStaff = new SupportStaff(name, age, staffID, 0, issueType);
        newStaff.setEmail(email);
        supportStaff.add(newStaff);
        personManager.addStaff(newStaff);
        System.out.println("\n[OK] Support staff added successfully!");
    }

    /**
     * This method allows user to assign issue to support staff member
     */
    private static void assignIssueToStaff() {
        if (supportStaff.isEmpty()) {
            System.out.println("\n[X] No support staff available.");
            return;
        }

        System.out.println("\n--- Assign Issue to Staff ---");
        viewAllSupportStaff();
        System.out.print("\nSelect staff member number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < supportStaff.size()) {
            SupportStaff staff = supportStaff.get(index);
            if (staff.isAvailable()) {
                staff.assignIssue();
                System.out.println("\n[OK] Issue assigned successfully!");
            } else {
                System.out.println("\n[X] Staff member is currently unavailable.");
            }
        } else {
            System.out.println("\n[X] Invalid staff number.");
        }
    }

    /**
     * This method allows user to update the issue status given to support staff member
     */
    private static void updateStaffIssueStatus() {
        if (supportStaff.isEmpty()) {
            System.out.println("\n[X] No support staff available.");
            return;
        }

        System.out.println("\n--- Update Issue Status ---");
        viewAllSupportStaff();
        System.out.print("\nSelect staff member number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < supportStaff.size()) {
            supportStaff.get(index).updateIssueStatus();
        } else {
            System.out.println("\n[X] Invalid staff number.");
        }
    }

    /**
     * This method resolves the issue that is assigned to the staff support member
     */
    private static void resolveStaffIssue() {
        if (supportStaff.isEmpty()) {
            System.out.println("\n[X] No support staff available.");
            return;
        }

        System.out.println("\n--- Resolve Issue ---");
        viewAllSupportStaff();
        System.out.print("\nSelect staff member number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < supportStaff.size()) {
            supportStaff.get(index).resolveIssue();
            System.out.println("\n[OK] Issue resolved and staff is now available!");
        } else {
            System.out.println("\n[X] Invalid staff number.");
        }
    }

    /**
     * This method allows use to view the information of customer and their order based on the support staff's customer
     */
    private static void viewStaffCustomerInfo() {
        if (supportStaff.isEmpty()) {
            System.out.println("\n[X] No support staff available.");
            return;
        }

        System.out.println("\n--- View Staff Customer Info ---");
        viewAllSupportStaff();
        System.out.print("\nSelect staff member number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < supportStaff.size()) {
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("       CUSTOMER/ORDER INFORMATION");
            System.out.println("═══════════════════════════════════════");
            supportStaff.get(index).storeCustomerOrderInfo();
        } else {
            System.out.println("\n[X] Invalid staff number.");
        }
    }

    /**
     * This method manages payment operations.
     */
    private static void managePayments() {
        boolean back = false;
        while (!back) {
            System.out.println("\n───────────────────────────────────────");
            System.out.println("        PAYMENT MANAGEMENT");
            System.out.println("───────────────────────────────────────");
            System.out.println("1. Create New Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. Process Payment");
            System.out.println("4. Generate Receipt");
            System.out.println("5. Back to Main Menu");
            System.out.println("───────────────────────────────────────");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    createNewPayment();
                    break;
                case 2:
                    viewAllPayments();
                    break;
                case 3:
                    processPayment();
                    break;
                case 4:
                    generateReceipt();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("\n[X] Invalid choice. Please try again.\n");
            }
        }
    }

    private static void createNewPayment() {
        if (orders.isEmpty()) {
            System.out.println("\n[X] No orders available. Please create an order first.");
            return;
        }

        System.out.println("\n--- Create New Payment ---");
        viewAllOrders();
        System.out.print("\nSelect order number: ");
        int orderIndex = getIntInput() - 1;

        if (orderIndex < 0 || orderIndex >= orders.size()) {
            System.out.println("\n[X] Invalid order number.");
            return;
        }

        int paymentID = payments.size() + 1;
        int orderID = orderIndex + 1;
        Payment newPayment = new Payment(paymentID, orderID);

        System.out.print("Enter subtotal amount: $");
        float subtotal = getFloatInput();
        System.out.print("Enter tax amount: $");
        float tax = getFloatInput();
        System.out.print("Enter delivery fee: $");
        float deliveryFee = getFloatInput();

        newPayment.setSubtotal(subtotal);
        newPayment.setTaxAmount(tax);
        newPayment.setDeliveryFee(deliveryFee);

        // Create payment method
        PaymentMethod method = new PaymentMethod(paymentID, 1);
        method.selectPaymentMethod();
        newPayment.setPaymentMethod(method);

        payments.add(newPayment);
        System.out.println("\n[OK] Payment created successfully!");
        System.out.println("Payment ID: " + paymentID);
        newPayment.calculateTotal();
        System.out.println("Total Amount: $" + newPayment.getTotal());
    }

    private static void viewAllPayments() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         ALL PAYMENTS");
        System.out.println("═══════════════════════════════════════");

        if (payments.isEmpty()) {
            System.out.println("No payments in the system.");
        } else {
            for (int i = 0; i < payments.size(); i++) {
                System.out.println("\n Payment #" + (i + 1));
                System.out.println("   Total: $" + payments.get(i).getTotal());
                System.out.println("───────────────────────────────────────");
            }
        }
    }

    private static void processPayment() {
        if (payments.isEmpty()) {
            System.out.println("\n[X] No payments available.");
            return;
        }

        System.out.println("\n--- Process Payment ---");
        viewAllPayments();
        System.out.print("\nEnter payment number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < payments.size()) {
            Payment payment = payments.get(index);
            payment.processPayment();
            payment.confirmPayment();
        } else {
            System.out.println("\n[X] Invalid payment number.");
        }
    }

    private static void generateReceipt() {
        if (payments.isEmpty()) {
            System.out.println("\n[X] No payments available.");
            return;
        }

        System.out.println("\n--- Generate Receipt ---");
        viewAllPayments();
        System.out.print("\nEnter payment number: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < payments.size()) {
            System.out.println(payments.get(index).generateReceipt());
        } else {
            System.out.println("\n[X] Invalid payment number.");
        }
    }

    /**
     * This method displays system reports.
     */
    private static void viewReports() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("        SYSTEM REPORTS");
        System.out.println("═══════════════════════════════════════");

        // Customer Report
        System.out.println("\n CUSTOMER STATISTICS");
        System.out.println("───────────────────────────────────────");
        System.out.println("Total Customers: " + customers.size());
        personManager.showNumberOfCustomers();

        // Driver Report
        System.out.println("\n DRIVER STATISTICS");
        System.out.println("───────────────────────────────────────");
        System.out.println("Total Drivers: " + drivers.size());
        if (!drivers.isEmpty()) {
            for (int i = 0; i < drivers.size(); i++) {
                DeliveryDriver driver = drivers.get(i);
                System.out.println("  • " + driver.getName() + " (ID: " + driver.getId() + ") - Email: " + driver.getEmail());
            }
        }

        // Restaurant Report
        System.out.println("\n RESTAURANT INFORMATION");
        System.out.println("───────────────────────────────────────");
        System.out.println("Total Restaurants: " + restaurants.size());
        for (Restaurant r : restaurants) {
            System.out.println("  • " + r.getName() + " - " + r.getMenu().getMenuItems().size() + " items");
        }

        // Order Report
        System.out.println("\n ORDER STATISTICS");
        System.out.println("───────────────────────────────────────");
        System.out.println("Total Orders: " + orders.size());

        int pending = 0, inProgress = 0, delivered = 0;
        for (Order order : orders) {
            String status = order.getOrderStatus();
            if (status.equals("Pending")) pending++;
            else if (status.contains("Progress") || status.contains("Preparing")) inProgress++;
            else if (status.equals("Delivered")) delivered++;
        }
        System.out.println("  • Pending: " + pending);
        System.out.println("  • In Progress: " + inProgress);
        System.out.println("  • Delivered: " + delivered);

        // Payment Report
        System.out.println("\n PAYMENT STATISTICS");
        System.out.println("───────────────────────────────────────");
        System.out.println("Total Payments: " + payments.size());
        float totalRevenue = 0;
        for (Payment payment : payments) {
            totalRevenue += payment.getTotal();
        }
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));

        // Staff Report
        System.out.println("\n SUPPORT STAFF");
        System.out.println("───────────────────────────────────────");
        personManager.showAllStaff();

        System.out.println("\n═══════════════════════════════════════\n");
    }

    /**
     * Helper method to get integer input with error handling.
     */
    private static int getIntInput() {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return value;
            } catch (Exception e) {
                System.out.print("[X] Invalid input. Please enter a number: ");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    /**
     * Helper method to get float input with error handling.
     */
    private static float getFloatInput() {
        while (true) {
            try {
                float value = scanner.nextFloat();
                scanner.nextLine(); // consume newline
                return value;
            } catch (Exception e) {
                System.out.print("[X] Invalid input. Please enter a number: ");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
}


