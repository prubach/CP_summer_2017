package shapes;

/**
 * Created by prubac on 4/5/2017.
 */
public class Rectangle extends Shape
        implements PerimeterCalculation {

    public Rectangle(double parA, double parB) {
        super(parA, parB);
    }

    public double calculateSurface() {
        return parA * parB;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * parA + 2 * parB;
    }
}
