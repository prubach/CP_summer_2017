package obj;

/**
 * Created by prubac on 4/5/2017.
 */
public class Rectangle {

    double sideA;
    double sideB;

    public void setParams(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double calculateSurface() {
        // this - not necessary but doesn't hurt
        return sideA * this.sideB;
    }
}
