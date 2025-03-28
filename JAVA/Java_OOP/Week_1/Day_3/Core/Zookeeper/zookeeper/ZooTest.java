package zookeeper;

public class ZooTest {
    public static void main(String[] args) {

        System.out.println("=== Gorilla Test ===");
        Gorilla g = new Gorilla();
        g.throwSomething();
        g.throwSomething();
        g.throwSomething();
        g.eatBananas();
        g.eatBananas();
        g.climb();
        g.displayEnergy();

        System.out.println("\n=== Bat Test ===");
        Bat b = new Bat();
        b.attackTown();
        b.attackTown();
        b.attackTown();
        b.eatHumans();
        b.eatHumans();
        b.fly();
        b.fly();
        b.displayEnergy();
    }
}
