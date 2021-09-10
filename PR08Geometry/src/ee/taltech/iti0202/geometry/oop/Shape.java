package ee.taltech.iti0202.geometry.oop;


public abstract class Shape {

    enum Type {CIRCLE, SQUARE, TRIANGLE}

    enum Color {BLACK, YELLOW, BLUE, RED, GREEN}

    static Shape createShape(Type type, Color color, int size) {
        switch (type) {
            case CIRCLE:
                return new Circle(color, size);
            case SQUARE:
                return new Square(color, size);
            case TRIANGLE:
                return new Triangle(color, size);
            default:
                return null;
        }
    }

    protected abstract void newSize(int x);

}
