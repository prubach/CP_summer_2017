package bank.exceptions;

/**
 * Created by prubac on 5/10/2017.
 */
public class NotEnoughMoneyException
        extends BankException {

    public NotEnoughMoneyException(String s) {
        super(s);
    }
}
