import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by prubac on 3/22/2017.
 */
public class TextFileRead {

    public static void main(String[] args) {
        //  throws FileNotFoundException {
        /*
        System.out.print("Please provide input: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println(input);
*/
        try {
            //File myFile = new File("..\\..\\..\\file.txt");
            File myFile = new File("H:\\file.txt");
            Scanner scanner = new Scanner(myFile);
            int i = 0;
            while (scanner.hasNext()) {
                String currLine = scanner.nextLine();

                // Divide the String into an array using
                // the delimiter ";"
                // String[] elem = currLine.split(";");


                System.out.println(i + ": " + currLine);
                i++;
            }
        } catch (FileNotFoundException fe) {
            System.out.println("Problem occurred: "
                    + fe.getMessage());
        }


    }
}
