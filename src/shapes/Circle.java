package shapes;

/**
 * Created by prubac on 4/5/2017.
 */
public class Circle extends Shape
        implements PerimeterCalculation {

    public Circle(double parA) {
        super(parA, 0);
    }

    public double calculateSurface() {
        return Math.pow(parA, 2) * Math.PI;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * parA;
    }
}
