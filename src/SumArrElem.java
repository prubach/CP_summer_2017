import java.text.DecimalFormat;

/**
 * Created by prubac on 3/22/2017.
 */
public class SumArrElem {


    static Double sumArray(Double[] arr) {
        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i]; // result= result+ arr[i]
        }
        return result;
    }

    public static void main(String[] args) {

        Double[] arDb = new Double[]{
                45.54, 53.23, 24.3425235
        };

        Double sum = sumArray(arDb);
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(df.format(sum));
    }
}
