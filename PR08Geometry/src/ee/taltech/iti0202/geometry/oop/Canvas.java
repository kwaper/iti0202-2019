package ee.taltech.iti0202.geometry.oop;

import java.util.ArrayList;
import java.util.List;

public class Canvas {

    private static List<Shape> shapes = new ArrayList<>();


    Canvas() {
        shapes = new ArrayList<>();
    }


    public List<Shape> draw() {
        System.out.println(shapes);
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void resize(int x) {
        if (shapes.size() > 0) {
            shapes.get(shapes.size() - 1).newSize(x);
        }
    }
}
