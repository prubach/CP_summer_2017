import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by prubac on 3/29/2017.
 */
public class FileWrite {

    public static void main(String[] args) {
        File newFile = new File("h:/newfile.txt");
        try {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("abcdefef");
            bw.newLine();
            bw.write("2nd line");
            bw.newLine();
            bw.append("3rd line");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
