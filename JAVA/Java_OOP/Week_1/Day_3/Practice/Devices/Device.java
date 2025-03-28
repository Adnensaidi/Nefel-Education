public class Device {
    protected int battery;

    public Device() {
        this.battery = 100;
    }

    public void displayBattery() {
        System.out.println("Battery remaining: " + battery);
    }

    public static void main(String[] args) {
        Device device = new Device();
        device.displayBattery();
    }
}