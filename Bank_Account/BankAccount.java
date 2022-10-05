public class BankAccount {

    //class should have (double) checking balance and (double) savings balance
    //Member Variables
    private double checkingBalance;
    private double savingsBalance;
    public static int accountsCreated = 0;
    public static double totalBalance = 0.0;



    //Constructor is also a function
    public BankAccount(double checkingBalance, double savingsBalance ) {  //this will allows us to create a bankAccount user... refer to lines 4 and 5 on Account.Test file
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accountsCreated++;
        totalBalance += checkingBalance;
        totalBalance += savingsBalance;
        
        
    }

    //METHODS // FUNCTIONS
    public void addMoneyChecking(double bread) {
        this.checkingBalance += bread;
        totalBalance += bread;
    }

    public void addMoneySavings(double bread) {
        this.savingsBalance += bread;
        totalBalance += bread;
    }

    public void withdrawMoneyChecking(double bread) {
        if (checkingBalance < bread){
            System.out.println("Insufficient funds in checking");
        }else {
            System.out.println("Withdrawing money from checkings");
        this.checkingBalance -= bread;
            totalBalance -= bread;
        }
    }

    public void withdrawMoneySavings(double bread) {
        if (savingsBalance < bread){
            System.out.println("Insufficient funds savings");
        }else {
            System.out.println("Withdrawing money from savings");
        this.savingsBalance -= bread;
            totalBalance -= bread;
            
        }
    }
    


    // GETTERS AND SETTERS
    
    // GETTERS
    public double getAccountBalance() {
        return this.checkingBalance + this.savingsBalance;
    }
    
    
    public double getcheckingBalance (){
        return this.checkingBalance;
    }

    public double getsavingsBalance () {
        return this.savingsBalance;
    }

    //SETTERS
    // public void setCheckingBalance(double someMoney) {
    //     this.CheckingBalance = someMoney;
    // }
}