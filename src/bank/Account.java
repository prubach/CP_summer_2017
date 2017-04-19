package bank;

import java.math.BigDecimal;

/**
 * Created by prubac on 4/19/2017.
 */
public abstract class Account {

    private Long accountId;
    private Customer customer;
    private BigDecimal balance;

    public Account(Long accountId, Customer customer) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = new BigDecimal(0);
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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", customer=" + customer +
                ", balance=" + balance +
                '}';
    }
}
