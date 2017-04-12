package shapes;

/**
 * Created by prubac on 4/5/2017.
 */
public abstract class Shape implements Comparable<Shape> {

    // private + visible to children
    protected double parA;
    protected double parB;

    public Shape(double parA, double parB) {
        setParams(parA, parB);
    }

    public void setParams(double parA, double parB) {
        this.parA = parA;
        this.parB = parB;
    }

    public abstract double calculateSurface();

    @Override
    public int compareTo(Shape shape) {
        Double mySurface = Double.valueOf(this.calculateSurface());
        Double otherSurface = Double.valueOf(shape.calculateSurface());
        return mySurface.compareTo(otherSurface);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "parA=" + parA +
                ", parB=" + parB +
                '}';
    }
}
