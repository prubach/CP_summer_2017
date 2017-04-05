import java.util.Scanner;

/**
 * Created by prubac on 4/5/2017.
 */
public class InputParams {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input: ");
        while (scan.hasNext()) {
            //String input = scan.next();
            Integer input = scan.nextInt();
            System.out.println("Got: " + input);
        }

    }

}
