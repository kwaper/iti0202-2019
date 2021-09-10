package ComputerShop.Components;

public class Gpu extends Compotent {
    private String name;
    private int price;
    private int capacity;
    private int powerUsage;

    public Gpu(String name, int price, int memory, int powerUsage) {
        this.name = name;
        this.price = price;
        this.capacity = memory;
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
        return "Gpu : " + name + ", " + capacity + " GB, " + price + " EUR";
    }
}
