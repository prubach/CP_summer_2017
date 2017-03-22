/**
 * Created by prubac on 3/22/2017.
 */
public class BowlsRecursion {

    //static int v1 = 0;

    public static int countBowls(int row) {
        if (row == 1) return 1;
        else return countBowls(row - 1) + 2;
    }


    public static void main(String[] args) {

        int sum = countBowls(1000);

        System.out.println(sum);
        //System.out.println(v1);
    }

}
