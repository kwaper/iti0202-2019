package ComputerShop.Shop;

import ComputerShop.Components.Compotent;

public class Computer {

    private Compotent motherboard;
    private Compotent cpu;
    private Compotent gpu;
    private Compotent ram;
    private Compotent psu;
    private Compotent disk;
    private int price;

    public Computer(Compotent motherboard, Compotent cpu, Compotent ram, Compotent disk, Compotent psu,
                    int price) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
        this.psu = psu;
        this.price = price;
    }

    public Computer(Compotent motherboard, Compotent cpu, Compotent ram, Compotent gpu, Compotent disk, Compotent psu,
                    int price) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.disk = disk;
        this.psu = psu;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

//    @Override
//    public String toString() {
//        if (this.gpu != null){
//            return "\n----PC info----\n" + motherboard + ",\n" + cpu + ",\n" + gpu + ",\n" + ram
//                    + ",\n" + psu + ",\n" + disk + ",\nPRICE : " + price + " EUR";
//        } else return "\n----PC info----\n" + motherboard + ",\n" + cpu + ",\n" + ram
//                + ",\n" + psu + ",\n" + disk + ",\nPRICE : " + price + " EUR";
//


    @Override
    public String toString() {
        if (gpu != null) {
            return "Computer{" +
                    "motherboard=" + motherboard +
                    ", cpu=" + cpu +
                    ", gpu=" + gpu +
                    ", ram=" + ram +
                    ", psu=" + psu +
                    ", disk=" + disk +
                    ", price=" + price +
                    '}';
        } else return "Computer{" +
                "motherboard=" + motherboard +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", psu=" + psu +
                ", disk=" + disk +
                ", price=" + price +
                '}';
    }


}
