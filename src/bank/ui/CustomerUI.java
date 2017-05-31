package bank.ui;

import bank.Account;
import bank.Bank;
import bank.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Created by prubac on 5/24/2017.
 */
public class CustomerUI {
    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton prevButton;
    private JButton nextButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton newButton;
    private JTable accountTable;
    private JPanel mainPanel;
    private JPanel accountPanel;

    private Bank bank = new Bank();
    private AccountsTableDataModel accountsTableDataModel;
    private Customer curCustomer;

    private JPopupMenu contextMenu = new JPopupMenu("Operations on Account");


    public CustomerUI() {

        $$$setupUI$$$();
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Customer newCust = bank.createCustomer(firstNameTextField.getText(), lastNameTextField.getText());
                curCustomer = newCust;
                Account newAcc = bank.createAccount(newCust, false, "USD");
                accountsTableDataModel.removeAllRows();
                accountsTableDataModel.addRow(newAcc);
                idTextField.setText(newCust.getCustomerId().toString());
                System.out.println(bank);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer currentCustIndex = bank.getCustomerList().indexOf(curCustomer);

                if (currentCustIndex < bank.getCustomerList().size() - 1) {
                    Customer nextCustomer = bank.getCustomerList().get(currentCustIndex + 1);
                    setCustData(nextCustomer);
                }
            }
        });
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer currentCustIndex = bank.getCustomerList().indexOf(curCustomer);

                if (currentCustIndex > 0) {
                    Customer nextCustomer = bank.getCustomerList().get(currentCustIndex - 1);
                    setCustData(nextCustomer);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (idTextField.getText() != null) {
                    Long custId = Long.valueOf(idTextField.getText());
                    Customer customer = bank.getCustomerById(custId);

                    if (customer != null) {
                        customer.setFirstName(firstNameTextField.getText());
                        customer.setLastName(lastNameTextField.getText());
                    }
                }
            }
        });


    }

    public void setCustData(Customer customer) {
        firstNameTextField.setText(customer.getFirstName());
        lastNameTextField.setText(customer.getLastName());
        idTextField.setText(customer.getCustomerId().toString());
        accountsTableDataModel.removeAllRows();
        accountsTableDataModel.addRows(
                bank.getAccountListForCustomer(customer));
        curCustomer = customer;
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Bank");
        CustomerUI custUI = new CustomerUI();
        jFrame.add(custUI.getMainPanel());
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
//        Customer c = bank.createCustomer("John", "Smith");
        //       bank.createAccount(c, false, "USD");
        accountsTableDataModel = new AccountsTableDataModel(bank.getAccountList());
        accountTable = new JTable(accountsTableDataModel);
        accountTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JMenuItem newDebitAccount = new JMenuItem("New Debit Account");
        newDebitAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (idTextField.getText() != null) {
                    Long custId = Long.valueOf(idTextField.getText());
                    Customer customer = bank.getCustomerById(custId);

                    if (customer != null) {
                        Account newAcc = bank.createAccount(customer, false,
                                "USD");
                        accountsTableDataModel.addRow(newAcc);
                    }
                }
            }
        });
        JMenuItem newSavingsAccount = new JMenuItem("New Savings Account");
        newSavingsAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (idTextField.getText() != null) {
                    Long custId = Long.valueOf(idTextField.getText());
                    Customer customer = bank.getCustomerById(custId);

                    if (customer != null) {
                        Account newAcc = bank.createAccount(customer, true,
                                "USD");
                        accountsTableDataModel.addRow(newAcc);
                    }
                }
            }
        });
        JMenuItem deleteAccount = new JMenuItem("Delete Account");
        deleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Selected: "
                        + accountTable.getSelectedRowCount());
                if (accountTable.getSelectedRowCount() > 0) {
                    int[] selectedRows = accountTable.getSelectedRows();
                    for (int rowNum : selectedRows) {
                        Account accToDelete = (Account) accountsTableDataModel
                                .getDataVector()
                                .get(rowNum);
                        bank.deleteAccount(accToDelete);
                        accountsTableDataModel.removeRow(rowNum);
                    }

                }

            }
        });
        contextMenu.add(newDebitAccount);
        contextMenu.add(newSavingsAccount);
        contextMenu.add(deleteAccount);
        accountTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if (mouseEvent.isPopupTrigger()) {
                    contextMenu.show(mouseEvent.getComponent(),
                            mouseEvent.getX(), mouseEvent.getY());
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });


    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("ID");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idTextField = new JTextField();
        idTextField.setEnabled(false);
        panel1.add(idTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("FirstName");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        firstNameTextField = new JTextField();
        panel1.add(firstNameTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("LastName");
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lastNameTextField = new JTextField();
        panel1.add(lastNameTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        accountPanel = new JPanel();
        accountPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        scrollPane1.setViewportView(accountPanel);
        accountPanel.add(accountTable, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        prevButton = new JButton();
        prevButton.setText("<");
        panel2.add(prevButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nextButton = new JButton();
        nextButton.setText(">");
        panel2.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Save");
        panel2.add(saveButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        panel2.add(deleteButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newButton = new JButton();
        newButton.setText("New");
        panel2.add(newButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
