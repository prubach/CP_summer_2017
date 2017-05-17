package bank;

import bank.exceptions.BankException;
import bank.exceptions.IllegalAmountException;
import bank.exceptions.NotEnoughMoneyException;

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

        cust1.setFirstName("Jack");
        System.out.println(cust1);
        Account acc1 = bank
                .createAccount(cust1, false, "USD");
        //acc1.getCustomer().setFirstName("Ronald");
        Account acc2 = bank
                .createAccount(cust1, true, "PLN");
        acc2.getCustomer().setFirstName("Ronald");
        Account acc3 = bank
                .createAccount(cust2, false, "USD");
        Account acc4 = bank
                .createAccount(cust2, true, "PLN");
        System.out.println(bank);
        try {
            /*Account acc = null;
            acc.deposit(20d);*/
            acc1.deposit(100d);
            acc2.deposit(200d);
            //acc2.charge(250d);
            System.out.println(bank);

            // bank.transfer(1L,3L,120d);
            bank.transfer(1L, 3L, 100d);


            // } catch (IllegalAmountException | NotEnoughMoneyException ne) {
            //} catch (IllegalAmountException ne) {
        } catch (BankException ne) {
            System.out.println("Something went wrong: "
                    + ne.getMessage());
        /*} catch (NotEnoughMoneyException ne) {
            System.out.println("Something went wrong: "
                    + ne.getMessage());*/
        }
        System.out.println(bank);


    }
}
