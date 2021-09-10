package ee.taltech.iti0202.geometry.oop;

public class Square extends Shape {

    private int size;
    private Color color;

    Square(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    public void newSize(int x) {
        this.size += x;
        System.out.println("Size of Square changed from " + (this.size - x) + " to " + this.size);
    }

    @Override
    public String toString() {
        return "\nType : " + Type.SQUARE + ", Color : " + color + ", size : " + size + ", number of angles : 4\n";
    }
}
