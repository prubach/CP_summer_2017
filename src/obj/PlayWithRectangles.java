package obj;

/**
 * Created by prubac on 4/5/2017.
 */
public class PlayWithRectangles {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.setParams(45, 24);
        double surface = r1.calculateSurface();
        System.out.println(surface);
    }
}
