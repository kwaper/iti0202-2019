package ee.taltech.iti0202.geometry.oop;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.addShape(Shape.createShape(Shape.Type.CIRCLE, Shape.Color.BLUE, 12));
        canvas.addShape(Shape.createShape(Shape.Type.SQUARE, Shape.Color.BLUE, 2));
        canvas.draw();

        Canvas canvas2 = new Canvas();
        canvas2.addShape(Shape.createShape(Shape.Type.CIRCLE, Shape.Color.BLUE, 12));
        canvas2.draw();
    }
}
