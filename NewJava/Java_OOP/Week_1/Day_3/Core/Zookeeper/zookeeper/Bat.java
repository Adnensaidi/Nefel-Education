package zookeeper;

public class Bat extends Mammal {

    public Bat() {
        this.energyLevel = 300;
    }

    public void fly() {
        System.out.println("The bat takes off into the night! 🦇🌙");
        this.energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("The bat feasts on humans! 😱 +25 energy");
        this.energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("🔥 The bat attacks the town! Chaos!");
        this.energyLevel -= 100;
    }
}
