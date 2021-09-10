package ComputerShop.Shop;

import ComputerShop.Components.*;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {

    private List<Compotent> CPUs = new ArrayList<>();
    private List<Compotent> GPUs = new ArrayList<>();
    private List<Compotent> RAMs = new ArrayList<>();
    private List<Compotent> Disks = new ArrayList<>();
    private List<Compotent> MOMs = new ArrayList<>();
    private List<Compotent> PSUs = new ArrayList<>();
    private Map<Computer, Integer> gamingComputers = new HashMap<>();
    private Map<Computer, Integer> officeComputers = new HashMap<>();

    public List<Computer> buyGamingComputer(int budget) {
        return gamingComputers.keySet().stream()
                .filter(Computer -> Computer.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getPrice))
                .collect(Collectors.toList());
    }

    public List<Computer> buyOfficeComputer(int budget) {
        return officeComputers.keySet().stream()
                .filter(Computer -> Computer.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getPrice))
                .collect(Collectors.toList());
    }

    public void createPC() {
        int price = 0;
        int psuPowerForGaming = 0;
        int psuPowerForOffice = 0;
        for (Compotent mb : MOMs) {
            int cpugen = mb.getCpuGen();
            int ramgen = mb.getRamGen();
            for (Compotent cpu : CPUs) {
                if (cpu.getGeneration() == cpugen) {
                    for (Compotent ram : RAMs) {
                        if (ram.getGeneration() == ramgen) {
                            for (Compotent gpu : GPUs) {
                                for (Compotent disk : Disks) {
                                    for (Compotent psu : PSUs) {
                                        psuPowerForGaming += mb.getPowerUsage() + cpu.getPowerUsage() + ram.getPowerUsage()
                                                + gpu.getPowerUsage() + disk.getPowerUsage();
                                        psuPowerForOffice += mb.getPowerUsage() + cpu.getPowerUsage() + ram.getPowerUsage()
                                                + disk.getPowerUsage();
                                        if (psu.getPower() >= psuPowerForGaming) {
                                            price += mb.getPrice() + cpu.getPrice() + ram.getPrice() + gpu.getPrice()
                                                    + disk.getPrice() + psu.getPrice();
                                            gamingComputers.putIfAbsent(new Computer(mb, cpu, ram, gpu, disk, psu, price), price);
                                            price = 0;
                                        }
                                        if (psu.getPower() >= psuPowerForOffice) {
//                                            System.out.println("ComputerShop.Components.Psu : " + psu.getPower() + " NEED: " + psuPowerForOffice);
                                            price += mb.getPrice() + cpu.getPrice() + ram.getPrice()
                                                    + disk.getPrice() + psu.getPrice();
                                            officeComputers.putIfAbsent(new Computer(mb, cpu, ram, disk, psu, price), price);
                                            price = 0;
                                        }
                                        psuPowerForGaming = 0;
                                        psuPowerForOffice = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public Map<Computer, Integer> getGamingComputers() {
        return gamingComputers;
    }

    public Map<Computer, Integer> getOfficeComputers() {
        return officeComputers;
    }

    public void addComponent(Compotent compotent) {
        if (compotent instanceof Cpu) {
            CPUs.add(compotent);
        }
        if (compotent instanceof Gpu) {
            GPUs.add(compotent);
        }
        if (compotent instanceof Ram) {
            RAMs.add(compotent);
        }
        if (compotent instanceof Disk) {
            Disks.add(compotent);
        }
        if (compotent instanceof Motherboard) {
            MOMs.add(compotent);
        }
        if (compotent instanceof Psu) {
            PSUs.add(compotent);
        }

    }
}
