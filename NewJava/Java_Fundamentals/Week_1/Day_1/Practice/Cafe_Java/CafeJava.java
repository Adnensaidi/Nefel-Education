public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.0;
        double lattePrice = 4.0;
        double cappuccinoPrice = 4.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;  // Cindhuri's order
        boolean isReadyOrder2 = true;   // Sam's order
        boolean isReadyOrder3 = false;  // Jimmy's order
        boolean isReadyOrder4 = true;   // Noah's order
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        
        // 1. Cindhuri ordered a coffee
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + dripCoffeePrice);
        } else {
            System.out.println(customer1 + pendingMessage);
        }
        
        // 2. Noah ordered a cappuccino
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }
        
        // 3. Sam ordered 2 lattes
        double samTotal = lattePrice * 2;
        System.out.println(displayTotalMessage + samTotal);
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        } else {
            System.out.println(customer2 + pendingMessage);
        }
        
        // 4. Jimmy was charged for a coffee but ordered a latte
        double jimmyOwes = lattePrice - dripCoffeePrice;
        System.out.println(customer3 + ", you were charged for a coffee but ordered a latte. " + displayTotalMessage + jimmyOwes + " more.");
    }
}
