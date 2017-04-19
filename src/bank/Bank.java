package bank;

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
