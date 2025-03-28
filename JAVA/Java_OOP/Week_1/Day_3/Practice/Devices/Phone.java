public class Phone extends Device {

    public void makeCall() {
        battery -= 5;
        System.out.println("You make a call.");
        displayBattery();
    }

    public void playGame() {
        battery -= 20;
        System.out.println("You play a game.");
        displayBattery();
    }

    public void charge() {
        battery += 50;
        if (battery > 100) battery = 100;
        System.out.println("Charging the phone.");
        displayBattery();
    }
}