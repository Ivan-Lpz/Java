public class AccountTest {

    public static void main(String[] args) {   //entry point where the testing occurs
        BankAccount user1 = new BankAccount(100,200);  //BankAccount user is being created by the constructor "line 13" in the BankAccount public class
        BankAccount user2 = new BankAccount(50,50);    //BankAccount user 2 same thing as comment above^^^^^^ 
        // System.out.println(user1.getsavingsBalance());
        // System.out.println(user1.getcheckingBalance());
        // user1.addMoneySavings(50);
        // user1.addMoneyChecking(50);
        user1.withdrawMoneyChecking(150);
        // user1.withdrawMoneySavings(150);
        System.out.println(user1.getcheckingBalance());
        // System.out.println(user1.getsavingsBalance());
        // System.out.println(BankAccount.totalBalance);
        // System.out.println(BankAccount.accountsCreated);
        // System.out.println(user2.getAccountBalance());

    }
}