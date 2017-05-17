package bank;

import bank.exceptions.BankException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prubac on 4/19/2017.
 */
public class Bank {

    List<Customer> customerList = new ArrayList<>();
    List<Account> accountList = new ArrayList<>();
    Long lastCustomerId = 0L;
    Long lastAccountId = 0L;

    public Customer createCustomer(
            String firstName, String lastName) {
        Long myNewId = lastCustomerId++;
        Customer cu = new Customer(myNewId, firstName,
                lastName);
        customerList.add(cu);
        return cu;
    }

    public Account createAccount(Customer cust,
                                 boolean isSavings, String currency) {
        Long myNewId = lastAccountId++;
        Account acc = isSavings ?
                new SavingsAccount(myNewId, cust, currency)
                :
                new DebitAccount(myNewId, cust, currency);

        /*Account acc = null;
        if (isSavings) {
            acc = new SavingsAccount(myNewId, cust)
        } else {
            acc = new DebitAccount(myNewId, cust)
        }*/
        accountList.add(acc);
        return acc;
    }

    public void transfer(Long accIdFrom,
                         Long accIdTo, Double amount)
            throws BankException {
        Account fromAcc = findAccountById(accIdFrom);
        Account toAcc = findAccountById(accIdTo);
        if (!fromAcc.getCurrency().equals(toAcc.getCurrency()))
            throw new BankException("Currencies don't match, from: "
                    + fromAcc.getCurrency() + " to: "
                    + toAcc.getCurrency());
        fromAcc.charge(amount);
        toAcc.deposit(amount);
    }

    private Account findAccountById(Long accId)
            throws BankException {
        for (Account acc : accountList) {
            if (acc.getAccountId().equals(accId))
                return acc;
        }
        throw new BankException("Account ID: " + accId +
                " not found!");
    }


    @Override
    public String toString() {
        return "Bank{\n" +
                "cust=" + customerList +
                "\nacc=" + accountList +
                "\nlastCustd=" + lastCustomerId +
                ", lastAccId=" + lastAccountId +
                '}';
    }
}
