import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prubac on 4/19/2017.
 */
public class Maps {
    public static void main(String[] args) {
        Map<String, Shape> shapeMap = new HashMap<>();
        shapeMap.put("Circle 1", new Circle(4));
        shapeMap.put("Rectangle", new Rectangle(2, 5));
        shapeMap.put("Square", new Square(6));

        System.out.println("Circle: " + shapeMap.get("Circle 1"));

        System.out.println();

        for (String s : shapeMap.keySet()) {
            System.out.println(s + " = " + shapeMap.get(s));
        }


    }
}
