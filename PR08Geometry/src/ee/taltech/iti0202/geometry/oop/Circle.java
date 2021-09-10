package ee.taltech.iti0202.geometry.oop;

public class Circle extends Shape {

    private int size;
    private Color color;

    Circle(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    public void newSize(int x) {
        this.size += x;
        System.out.println("Radius of Circle changed from " + (this.size - x) + " to " + this.size);
    }

    @Override
    public String toString() {
        return "\nType : " + Type.CIRCLE + ", Color : " + color + ", radius : " + size + ", number of angles : 0\n";
    }
}
