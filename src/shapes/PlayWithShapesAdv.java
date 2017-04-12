package shapes;

import java.util.Arrays;

/**
 * Created by prubac on 4/5/2017.
 */
public class PlayWithShapesAdv {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(4, 5);
        shapes[1] = new Circle(3);
        shapes[2] = new Square(2);

        Rectangle rect = (Rectangle) shapes[0];
        Circle circle = (Circle) shapes[1];

        int comparison = rect.compareTo(circle);

        System.out.println("compar: " + comparison);

        Arrays.sort(shapes);

        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            System.out.println(shape.toString());
            System.out.println("Surface: " +
                    shape.calculateSurface());
            if (shape instanceof PerimeterCalculation) {
                PerimeterCalculation pc =
                        (PerimeterCalculation) shape;
                System.out.println("Perimeter: " + pc.calculatePerimeter());
            }

        }


    }
}
