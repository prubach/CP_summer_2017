package bank;

import bank.exceptions.BankException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prubac on 5/17/2017.
 */
public class TransferFrame {

    public static Bank createBank() {
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
        try {
            acc1.deposit(200d);
            acc2.deposit(150d);
        } catch (BankException be) {
            JOptionPane.showMessageDialog(null, be.getMessage());
        }


        System.out.println(bank);
        return bank;
    }


    public static void main(String[] args) {

        Bank bank = createBank();

        JFrame trFrame = new JFrame();
        trFrame.setSize(300, 300);
        TransferWindow tw = new TransferWindow();
        trFrame.add(tw.getMainPanel());
        trFrame.setVisible(true);

        tw.getTransferButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Long fromAccId = Long.valueOf(tw.getFromAccTField().getText());
                    Long toAccId = Long.valueOf(tw.getToAccTField().getText());
                    Double amount = Double.valueOf(tw.getAmountTField().getText());
                    bank.transfer(fromAccId, toAccId, amount);
                    JOptionPane.showMessageDialog(trFrame, bank);
                } catch (BankException be) {
                    JOptionPane.showMessageDialog(trFrame, be.getMessage());
                }
            }
        });


    }
}
