package bank;

import bank.exceptions.IllegalAmountException;
import bank.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

/**
 * Created by prubac on 4/19/2017.
 */
public abstract class Account {

    private Long accountId;
    private Customer customer;
    private BigDecimal balance;
    private String currency;

    public Account(Long accountId, Customer customer, String currency) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = new BigDecimal(0);
        this.currency = currency;
    }

    public void charge(BigDecimal amount)
            throws NotEnoughMoneyException,
            IllegalAmountException {
        if (amount.compareTo(new BigDecimal(0)) <= 0)
            throw new IllegalAmountException(
                    "Tried to charge an illegal amount: "
                            + amount);
        if (getBalance().compareTo(amount) < 0)
            throw new NotEnoughMoneyException(
                    "Not enough money to charge: "
                            + amount);
        setBalance(getBalance().subtract(amount));
    }

    public void charge(Double dAmount)
            throws IllegalAmountException, NotEnoughMoneyException {
        charge(new BigDecimal(dAmount));
    }

    public void deposit(BigDecimal amount)
            throws IllegalAmountException {
        if (amount.compareTo(new BigDecimal(0)) <= 0)
            throw new IllegalAmountException(
                    "Tried to deposit an illegal amount: "
                            + amount);
        setBalance(getBalance().add(amount));
    }

    public void deposit(Double dAmount)
            throws IllegalAmountException {
        deposit(new BigDecimal(dAmount));
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "\n" + this.getClass().getSimpleName()
                .replace("Account", "") + "{" +
                "id=" + accountId +
                ", cust=" + customer.getCustomerId() +
                ", " + currency + " " + balance +
                '}';
    }
}
