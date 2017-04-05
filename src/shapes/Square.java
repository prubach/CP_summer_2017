package shapes;

/**
 * Created by prubac on 4/5/2017.
 */
public class Square extends Shape {

    public Square(double parA) {
        super(parA, 0);
    }

    @Override
    public double calculateSurface() {
        return Math.pow(parA, 2);
    }
}
