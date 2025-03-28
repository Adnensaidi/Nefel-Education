public class Item {
    private String name;
    private double price;
    private int index; // NEW!
public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
// Getters & Setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getIndex() { return index; }
public void setIndex(int index) {
        this.index = index;
    }
public String toString() {
        return index + " " + name + " -- $" + String.format("%.2f", price);
    }
}
