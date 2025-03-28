import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // Constructor
    public CoffeeKiosk() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Method to add a menu item
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    // Method to display the menu
    public void displayMenu() {
        System.out.println("\nMenu:");
        for (int i = 0; i < menu.size(); i++) {
            Item item = menu.get(i);
            System.out.println(i + " - " + item.getName() + " ($" + item.getPrice() + ")");
        }
    }

    // Method to create a new order
    public void newOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter customer name for the new order:");
        String customerName = scanner.nextLine();
        Order newOrder = new Order(customerName);

        displayMenu();

        System.out.println("Please enter a menu item index or 'q' to quit:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            try {
                int itemIndex = Integer.parseInt(input);
                if (itemIndex >= 0 && itemIndex < menu.size()) {
                    newOrder.addItem(menu.get(itemIndex));
                } else {
                    System.out.println("Invalid menu item index. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
            }
        }

        newOrder.display();
        orders.add(newOrder);
    }

    // Main method
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        // Adding some menu items
        kiosk.addMenuItem("Coffee", 2.50);
        kiosk.addMenuItem("Latte", 3.50);
        kiosk.addMenuItem("Cappuccino", 4.00);
        kiosk.addMenuItem("Mocha", 4.50);

        // Displaying the menu and starting a new order
        kiosk.displayMenu();
        kiosk.newOrder();
    }
}