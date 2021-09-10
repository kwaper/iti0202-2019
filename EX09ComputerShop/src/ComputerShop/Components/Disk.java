package ComputerShop.Components;

public class Disk extends Compotent {

    private String name;
    private int capacity;
    private int price;
    private int powerUsage;

    public Disk(String name, int capacity, int price, int powerUsage) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.powerUsage = powerUsage;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getPowerUsage() {
        return powerUsage;
    }

    @Override
    public String toString() {
        return "Disk : " + name + ", " + capacity + " GB, " + price + " EUR";
    }
}
