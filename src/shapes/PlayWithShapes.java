package shapes;

/**
 * Created by prubac on 4/5/2017.
 */
public class PlayWithShapes {

    public static void main(String[] args) {
        //Shape sh1 = new Shape(23,34);
        //System.out.println(sh1.toString());

        Rectangle r1 = new Rectangle(21, 13);
        System.out.println(r1.calculateSurface());

        Circle c1 = new Circle(2);
        System.out.println(c1.toString() + " surface: " +
                c1.calculateSurface());
    }
}
