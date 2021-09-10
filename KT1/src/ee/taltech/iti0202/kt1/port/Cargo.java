package ee.taltech.iti0202.kt1.port;

public class Cargo {
    private String name;
    private int weight;
    private int size;

    public Cargo(String name, int weight, int size) {
        this.name = name;
        this.weight = weight;
        this.size = size;

    }

    public int getWeight() {
        return this.weight;

    }

    public int getSize() {
        return this.size;

    }

    public String getName() {
        return this.name;

    }

    public int getTotalWeight() {
        if (this.weight < 10 || this.size < 10) {
            return 10;
        } else return weight * size * size;

    }

    public String toString() {
        return "Name: " + this.name + ", Total: " + getTotalWeight();

    }
}
