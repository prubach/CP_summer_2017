package bank;

import bank.exceptions.IllegalAmountException;

/**
 * Created by prubac on 4/19/2017.
 */
public class PlayWithBank {

    public static void main(String[] args)
            /*throws IllegalAmountException */ {

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
        try {
            acc1.deposit(-100d);
            acc2.deposit(200d);
            acc2.charge(250d);
        } catch (IllegalAmountException ne) {
            System.out.println("Something went wrong: "
                    + ne.getMessage());
        }
        System.out.println(bank);


    }
}
