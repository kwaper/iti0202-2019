package ComputerShop;

import ComputerShop.Components.*;
import ComputerShop.Components.Cpu;
import ComputerShop.Shop.Shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addComponent(new Cpu("core i3 - 7700k", 280, 3, 80,7));
        shop.addComponent(new Cpu("core i5 - 8600k", 330, 3.3, 100,8));
        shop.addComponent(new Cpu("core i7 - 9800k", 450, 4.8, 120,9));

        shop.addComponent(new Gpu("GTX 1050Ti", 250, 3,200));
        shop.addComponent(new Gpu("GTX 1060", 350, 6,210));
        shop.addComponent(new Gpu("GTX 1070Ti", 450, 8,220));
        shop.addComponent(new Gpu("GTX 1080Ti", 600, 11,400));

        shop.addComponent(new Ram("Kingston", 8, 2400, 4, 40,70));
        shop.addComponent(new Ram("Kingston", 16, 3000, 4, 80,120));
        shop.addComponent(new Ram("Corsair", 8, 3000, 3, 40,60));

        shop.addComponent(new Motherboard("MSI", 8, 4, 60,150));
        shop.addComponent(new Motherboard("ASUS", 7, 3,  50,150));
        shop.addComponent(new Motherboard("MSI", 9, 4,  70,170));

        shop.addComponent(new Psu("PONY", 500, 50));
        shop.addComponent(new Psu("DRAGON", 700, 75));
        shop.addComponent(new Psu("DRAGOPONY", 1000, 100));

        shop.addComponent(new Disk("BlueFishHDD", 1000, 40,40));
        shop.addComponent(new Disk("RedSharkSSD", 240, 50, 50));
        shop.addComponent(new Disk("PinkSharkSSD", 500, 90,50));


        shop.createPC();
        System.out.println(shop.getGamingComputers().size());
        System.out.println(shop.getOfficeComputers().size());
//
//        System.out.println(shop.buyGamingComputer(2000));
        System.out.println(shop.buyOfficeComputer(600));

//        Shop shop1 = new Shop();
//
//        shop1.addComponent(new Cpu("core i3 - 7700k", 280, 3, 80,7));
//        shop1.addComponent(new Gpu("GTX 1050Ti", 250, 3,200));
//        shop1.addComponent(new Ram("Kingston", 8, 2400, 3, 40,70));
//        shop1.addComponent(new Motherboard("ASUS", 7, 3,  50,150));
//        shop1.addComponent(new Psu("DRAGON", 700, 75));
//        shop1.addComponent(new Disk("RedSharkSSD", 240, 50, 50));
//
//
//        shop1.createPC();
//        System.out.println(shop1.getGamingComputers().size());
//        System.out.println(shop1.getOfficeComputers().size());
    }
}
