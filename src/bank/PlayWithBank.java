package bank;

/**
 * Created by prubac on 4/19/2017.
 */
public class PlayWithBank {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Customer cust1 = bank
                .createCustomer("John", "Smith");
        Customer cust2 = bank
                .createCustomer("Anne", "Brown");
        Account acc1 = bank
                .createAccount(cust1, false, "USD");
        Account acc2 = bank
                .createAccount(cust1, true, "PLN");
        Account acc3 = bank
                .createAccount(cust2, false, "USD");
        Account acc4 = bank
                .createAccount(cust2, true, "PLN");

        System.out.println(bank);


    }
}
