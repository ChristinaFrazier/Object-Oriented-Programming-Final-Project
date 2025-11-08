import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class manages restaurant menus and menu items.
 * @author Evan Darmanto
 * Date: 11/02/25
 * Assignment: Final Project, CSCI 2210
 */
public class Menu {
    private int menuID;
    private int restaurantID;
    private ArrayList<MenuItem> menuItems;
    private LocalDateTime lastUpdated;

    /**
     * This method is the constructor for this class.
     * @param menuID The menu ID as an int
     * @param restaurantID The restaurant ID as an int
     */
    public Menu(int menuID, int restaurantID) {
        this.menuID = menuID;
        this.restaurantID = restaurantID;
        this.menuItems = new ArrayList<>();
        this.lastUpdated = LocalDateTime.now();
    }

    /**
     * This method displays all menu items
     */
    public void displayAllMenuItems() {
        if (menuItems.isEmpty()) {
            System.out.println("No items in menu.");
        } else {
            System.out.println("\n====== Menu Items ======");
            for (MenuItem item : menuItems) {
                item.displayItemInfo();
                System.out.println("---------------------");
            }
        }
    }

    /**
     * This method categorizes menu items
     */
    public void categorizeMenuItems() {
        System.out.println("Categorizing menu items...");
        for (MenuItem item : menuItems) {
            System.out.println(item.getName() + " - Category: " + item.getCategory());
        }
    }

    /**
     * This method adds a menu item
     */
    public void addMenuItem() {
        MenuItem newItem = new MenuItem(menuItems.size() + 1, "", "", 0.0f);
        newItem.addItem();
        menuItems.add(newItem);
        this.lastUpdated = LocalDateTime.now();
        System.out.println("Menu item added successfully.");
    }

    /**
     * This method adds a pre-created menu items
     * @param item The MenuItem to add
     */
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        this.lastUpdated = LocalDateTime.now();
    }

    /**
     * This method updates a menu item
     */
    public void updateMenuItem() {
        if (menuItems.isEmpty()) {
            System.out.println("No items to update.");
            return;
        }
        displayAllMenuItems();
        System.out.println("Enter item number to update: ");
        this.lastUpdated = LocalDateTime.now();
    }

    /**
     * This method removes a menu item
     */
    public void removeMenuItem() {
        if (menuItems.isEmpty()) {
            System.out.println("No items to remove.");
            return;
        }
        displayAllMenuItems();
        System.out.println("Enter item number to remove: ");
        this.lastUpdated = LocalDateTime.now();
    }

    /**
     * This method provides the complete menu
     * @return Returns the complete menu as a string
     */
    public String provideCompleteMenu() {
        String menu = "\n====== Complete Menu ======\n";
        for (MenuItem item : menuItems) {
            menu += item.provideItemDetails() + "\n";
        }
        return menu;
    }

    /**
     * This method filters items by category
     * @param category The category to filter by ("Appetizer", "Main Course", "Dessert", "Beverage")
     * @return Returns a list of filtered menu items that match the category
     */
    public ArrayList<MenuItem> filterByCategory(String category) {
        ArrayList<MenuItem> filteredItems = new ArrayList<>();

        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                filteredItems.add(item);
            }
        }

        if (filteredItems.isEmpty()) {
            System.out.println("No items found in category: " + category);
        }

        return filteredItems;
    }

    /**
     * This method gets all menu items
     * @return Returns the list of menu items
     */
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
