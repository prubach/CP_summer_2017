package shapes;

/**
 * Created by prubac on 4/5/2017.
 */
public class PlayWithShapesAdv {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(4, 5);
        shapes[1] = new Circle(3);
        shapes[2] = new Square(2);

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].toString());
            System.out.println("Surface: " +
                    shapes[i].calculateSurface());
        }


    }
}
