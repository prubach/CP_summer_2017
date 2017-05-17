package bank.ui;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prubac on 5/17/2017.
 */
public class MyFirstWindow {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("My first window");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LayoutManager layoutManager = new FlowLayout();
        frame.setLayout(layoutManager);

        JPanel panel1 = new JPanel();
        JLabel lbl1 = new JLabel("First Name");
        panel1.add(lbl1);
        JTextField firstNameField = new JTextField(20);
        panel1.add(firstNameField);

        JPanel lastNamePanel = new JPanel();
        JLabel lbl2 = new JLabel("Last Name");
        lastNamePanel.add(lbl2);
        JTextField lastNameField = new JTextField(20);
        lastNamePanel.add(lastNameField);

        lastNameField.setText("abc");
        //lastNameField.setEnabled(false);

        JButton myButton = new JButton("Login");

        // Anonymous inner class
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(lastNameField.getText());
                JOptionPane.showMessageDialog(frame,
                        "Hello " + firstNameField.getText() + " "
                                + lastNameField.getText());
            }
        });


        frame.add(panel1);
        frame.add(lastNamePanel);
        frame.add(myButton);
        frame.setVisible(true);

        JFrame frame2 = new JFrame();
        frame2.setTitle("My second window");
        frame2.setSize(500, 400);
        frame2.setLocation(300, 300);
        frame2.setVisible(true);


    }
}
