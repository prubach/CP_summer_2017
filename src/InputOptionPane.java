import javax.swing.*;

/**
 * Created by prubac on 4/5/2017.
 */
public class InputOptionPane {

    public static void main(String[] args) {

        int result = -1;
        String input = null;
        do {
            input = JOptionPane.showInputDialog(
                    "Please provide input: ");

            result = JOptionPane.showConfirmDialog(null,
                    "Please confirm it");
            if (result == 2) System.exit(-3);
        } while (result != 0);


        JOptionPane.showMessageDialog(null,
                "Hello, I got: " + result + " " + input);

    }
}
