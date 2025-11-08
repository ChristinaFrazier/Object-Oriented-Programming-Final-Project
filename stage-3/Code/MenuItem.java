import java.util.Scanner;
/**
 * This class represents individual menu items.
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CSCI 2210
 */
public class MenuItem {
    private int itemID;
    private String name;
    private String description;
    private float price;
    private String category;
    private String ingredients;
    private String allergenInfo;
    private int preparationTime;

    /**
     * This method is the constructor for this class
     * @param itemID The item ID as an int
     * @param name The item name as a String
     * @param description The item description as a string
     * @param price The item price as a float
     */
    public MenuItem(int itemID, String name, String description, float price) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = "Uncategorized";
        this.preparationTime = 15;
    }

    /**
     * This method stores item details
     */
    public void storeItemDetails() {
        System.out.println("Item details stored for: " + name);
    }

    /**
     * This method assigns a category to the item
     */
    public void assignCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select category:");
        System.out.println("1. Appetizer");
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.println("4. Beverage");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                this.category = "Appetizer";
                break;
            case 2:
                this.category = "Main Course";
                break;
            case 3:
                this.category = "Dessert";
                break;
            case 4:
                this.category = "Beverage";
                break;
            default:
                this.category = "Uncategorized";
        }
        System.out.println("Category set to: " + category);
    }

    /**
     * This method updates the item category
     */
    public void updateCategory() {
        assignCategory();
    }

    /**
     * This method maintains ingredients information.
     */
    public void maintainIngredientsInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ingredients (comma-separated): ");
        this.ingredients = scanner.nextLine();

        System.out.println("Ingredients updated.");
    }

    /**
     * This method tracks the preparation time
     */
    public void trackPreparationTime() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter preparation time (minutes): ");
        this.preparationTime = scanner.nextInt();

        System.out.println("Preparation time set to: " + preparationTime + " minutes");
    }

    /**
     * This method provides item details.
     * @return Returns item details as a string.
     */
    public String provideItemDetails() {
        String details = name + " - $" + price + "\n";
        details += description + "\n";
        details += "Category: " + category + "\n";

        if (ingredients != null) {
            details += "Ingredients: " + ingredients + "\n";
        }

        if (allergenInfo != null) {
            details += "Allergens: " + allergenInfo + "\n";
        }

        details += "Prep Time: " + preparationTime + " min\n";
        return details;
    }

    /**
     * This method adds a new item
     */
    public void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an item: ");
        this.name = scanner.nextLine();

        System.out.println("Enter description: ");
        this.description =  scanner.nextLine();

        System.out.println("Enter price: ");
        this.price = scanner.nextFloat();

        assignCategory();
    }

    /**
     * This method updates item information
     */
    public void updateItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new price: ");
        this.price = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Enter new description: ");
        this.description = scanner.nextLine();

        System.out.println("Item updated successfully.");
    }

    /**
     * This method removes an item
     */
    public void removeItem() {
        this.name = null;
        this.description = null;
        this.price = 0.0f;
        System.out.println("Item removed.");
    }

    /**
     * This method displays item information
     */
    public void displayItemInfo() {
        System.out.println(provideItemDetails());
    }

    /**
     * This method gets the item name
     * @return Returns the item name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the item price
     * @return Returns the item price as a float
     */
    public float getPrice() {
        return price;
    }

    /**
     * This method gets the item category
     * @return Returns the category as a string
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method sets the item category
     * @param category The category as a string
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * This method sets allergen information
     * @param allergenInfo The allergen info as a string
     */
    public void setAllergenInfo(String allergenInfo) {
        this.allergenInfo = allergenInfo;
    }
}
