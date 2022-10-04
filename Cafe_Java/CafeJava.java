public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 4.5;
        double dripCoffeePrice = 4.5;
        double lattePrice = 7.5;
        double cappuccinoPrice = 8.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false; 
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage + displayTotalMessage);
        }
        else {
            System.out.println(customer1 + pendingMessage);
        }

        if (isReadyOrder2) {
            System.out.println(pendingMessage);
        }
        else {
            System.out.println(readyMessage + displayTotalMessage);
            }

            
            System.out.println(displayTotalMessage + (lattePrice + lattePrice));

        if (isReadyOrder3) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(generalGreeting);
        }

        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));    
    }
}
