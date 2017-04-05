package obj;

/**
 * Created by prubac on 4/5/2017.
 */
public class Rectangle {

    private double sideA;
    private double sideB;

    //public Rectangle() {
    //}

    public Rectangle(double sideA, double sideB) {
        setParams(sideA, sideB);
    }

    public void setParams(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double calculateSurface() {
        // this - not necessary but doesn't hurt
        return sideA * this.sideB;
    }
}
