package shapes;

/**
 * Created by prubac on 4/5/2017.
 */
public class Rectangle extends Shape {

    public Rectangle(double parA, double parB) {
        super(parA, parB);
    }

    public double calculateSurface() {
        return parA * parB;
    }

}
