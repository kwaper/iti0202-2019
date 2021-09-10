package ee.taltech.iti0202.geometry.oop;

public class Triangle extends Shape {

    private int size;
    private Color color;

    Triangle(Color color, int size) {
        this.color = color;
        this.size = size;
    }


    public void newSize(int x) {
        this.size += x;
        System.out.println("Size of Triangle changed from " + (this.size - x) + " to " + this.size);
    }

    @Override
    public String toString() {
        return "\nType : Triangle, Color : " + color + ", size : " + size + ", number of angles : 3\n";
    }
}
