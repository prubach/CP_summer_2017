package bank;

/**
 * Created by prubac on 4/19/2017.
 */
public class DebitAccount extends Account {
    public DebitAccount(Long accountId, Customer customer, String currency) {
        super(accountId, customer, currency);
    }
}
