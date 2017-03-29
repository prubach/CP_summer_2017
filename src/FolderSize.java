/**
 * Created by prubac on 3/29/2017.
 */

import java.io.File;

public class FolderSize {
    static long size(File f) {
        long s = 0;
        if (f.isFile()) {
            s += f.length(); //base case

            System.out.println(f.getName() + " : " + f.length());
        } else {// we trust that Size will work for smaller problem
            File[] fileList = f.listFiles();
            for (File file : fileList) { // foreach file of type FIle in filelist
                System.out.print("/" + f.getName());
                s += size(file);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        //f.length

        //String user = System.getProperty("user.dir");
        //String home = user + "/src";
        String home = System.getProperty("user.home");
        File f = new File(home);
        System.out.println(size(f) + " bytes");


    }
}