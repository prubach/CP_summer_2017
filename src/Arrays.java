/**
 * Created by prubac on 3/22/2017.
 */
public class Arrays {

    public static void main(String[] args) {
        //int[] arInt = new int[3];
        Integer[] arInt = new Integer[3];
        arInt[0] = 5;
        arInt[1] = 7;


        for (int i = 0; i < arInt.length; i++) {
            System.out.println(arInt[i]);
        }

        System.out.println();

        String[] arStr = new String[]{
                "abc", "def", "ghi"
        };

        for (int j = 0; j < arStr.length; j++) {
            System.out.println(arStr[j]);
        }
        System.out.println();

        // for each
        for (String el : arStr) {
            System.out.println("foreach: " + el);
        }


    }
}
