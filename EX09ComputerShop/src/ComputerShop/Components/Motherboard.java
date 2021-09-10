package ComputerShop.Components;

public class Motherboard extends Compotent {

    private String name;
    private int cpuGen;
    private int ramGen;
    private int price;
    private int powerUsage;

    public Motherboard(String name, int cpuGen, int ramGen, int powerUsage, int price) {
        this.name = name;
        this.cpuGen = cpuGen;
        this.ramGen = ramGen;
        this.powerUsage = powerUsage;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getCpuGen() {
        return cpuGen;
    }

    @Override
    public int getPowerUsage() {
        return powerUsage;
    }

    @Override
    public int getRamGen() {
        return ramGen;
    }

    @Override
    public String toString() {
        return "MOTHERBOARD : " + name + ", CpuGen : " + cpuGen + ", RamGen : " + ramGen
                + ", " + price + " EUR";
    }
}
