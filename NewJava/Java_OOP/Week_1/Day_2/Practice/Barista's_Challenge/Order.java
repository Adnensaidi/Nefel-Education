import java.util.ArrayList;

public class Order {
    private String customerName;
    private ArrayList<Item> items;

    // Constructor
    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    // Method to add an item to the order
    public void addItem(Item item) {
        this.items.add(item);
    }

    // Method to display the order details
    public void display() {
        System.out.println("\nOrder for: " + customerName);
        double total = 0;
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.printf("Total: $%.2f\n", total);
    }
}