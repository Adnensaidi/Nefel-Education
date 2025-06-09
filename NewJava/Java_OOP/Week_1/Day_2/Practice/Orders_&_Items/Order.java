import java.util.ArrayList;

public class Order {
    public String name;
    public ArrayList<Item> items = new ArrayList<>();
    public double total = 0.0;
    public boolean ready = false;
}