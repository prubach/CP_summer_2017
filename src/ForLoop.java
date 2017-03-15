/**
 * Created by prubac on 3/15/2017.
 */
public class ForLoop {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            if (i == 6) continue;
            System.out.println("i=" + i);
            if (i > 7) break;
        }
        System.out.println();
        for (int j = 5; j > 0; j--) {
            System.out.println("j=" + j);
        }

        int k = 0;
        while (k < 10) {
            System.out.println("k=" + k);
            k++;
        }

        int m = 10;
        do {
            System.out.println("m=" + m);
            m--;
        } while (m < 5);




    }
}
