package ComputerShop.Components;

public class Psu extends Compotent {

    private String name;
    private int power;
    private int price;

    public Psu(String name, int power, int price) {
        this.name = name;
        this.power = power;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getPower(){
        return power;
    }

    @Override
    public String toString() {
        return "Psu : " + name + ", " + power + " W, " + price + " EUR";
    }
}
