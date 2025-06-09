package zookeeper;

public class Gorilla extends Mammal {

    public Gorilla() {
        super(); // starts with 100
    }

    public void throwSomething() {
        System.out.println("The gorilla throws something! 🪵");
        this.energyLevel -= 5;
    }

    public void eatBananas() {
        System.out.println("The gorilla eats a banana. 🐵🍌 So satisfied!");
        this.energyLevel += 10;
    }

    public void climb() {
        System.out.println("The gorilla climbs a tree. 🌳");
        this.energyLevel -= 10;
    }
}
