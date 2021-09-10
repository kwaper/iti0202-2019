package ComputerShop.Components;

public class Ram extends Compotent {

    private String name;
    private int capacity;
    private int power;
    private int powerUsage;
    private int price;
    private int generation;

    public Ram(String name, int capacity, int power, int generation, int powerUsage, int price) {
        this.name = name;
        this.capacity = capacity;
        this.power = power;
        this.generation = generation;
        this.powerUsage = powerUsage;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public int getPowerUsage() {
        return powerUsage;
    }

    @Override
    public String toString() {
        return "Ram : " + name + ", " + capacity + " GB, " + power + " MHz, Gen : "
                + generation + ", " + price + " EUR";
    }
}
