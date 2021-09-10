package ComputerShop.Components;

public class Cpu extends Compotent {

    private String name;
    private int price;
    private double power;
    private int powerUsage;
    private int generation;

    public Cpu(String name, int price, double power, int powerUsage, int generation) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.powerUsage = powerUsage;
        this.generation = generation;
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
        return "Cpu : " + this.name + " , " + this.power + " GHz, Gen : "
                + this.generation + ", " + this.price + " EUR";
    }
}
