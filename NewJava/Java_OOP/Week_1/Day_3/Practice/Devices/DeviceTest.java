public class DeviceTest {
    public static void main(String[] args) {
        Phone myPhone = new Phone();

        // Make 3 calls
        myPhone.makeCall();
        myPhone.makeCall();
        myPhone.makeCall();

        // Play 2 games
        myPhone.playGame();
        myPhone.playGame();

        // Charge the phone once
        myPhone.charge();
    }
}
