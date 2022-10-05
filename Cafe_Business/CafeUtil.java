import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {

public int getStreakGoal(){
    int total = 0;
    for(int i = 0; i<=10; i++){
    total += i;
    }
    return total;
}

public double getOrderTotal(double[] prices){
    double total = 0;
    for(int i = 0; i< prices.length; i++){
        total += prices[i];
    }
    return total;
    }

public void displayMenu(ArrayList<String> menuItems) {

    for (int i = 0; i<menuItems.size(); i++){
        System.out.println(i + " "+ menuItems.get(i));
    }
}

public void addCustomer(ArrayList<String> customers) {
    System.out.println("Please enter your name");
    String userName = System.console().readLine();
    customers.add(userName);
    System.out.println("Hello, " + userName + " There are " + (customers.size() - 1) + " ahead of you");
    System.out.println(customers);

}

}