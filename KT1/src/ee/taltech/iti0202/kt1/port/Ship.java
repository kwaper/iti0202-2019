package ee.taltech.iti0202.kt1.port;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String name;
    private List<String> restrictions = new ArrayList<>();
    private int capacity;
    private List<Cargo> cargos = new ArrayList<>();

    public Ship(String name, List<String> restrictions, int capacity) {
        this.name = name;
        this.restrictions = restrictions;
        this.capacity = capacity;

    }

    public String getName() {
        return this.name;

    }

    public boolean addCargo(Cargo cargo) {
        if (cargo == null) {
            return false;
        }
        if (restrictions.contains(cargo.getName())) {
            return false;
        }
        if (!cargos.contains(cargo) && cargo.getTotalWeight() <= this.capacity) {
            cargos.add(cargo);
            this.capacity -= cargo.getWeight();
            return true;
        }
        return false;
    }

    public int getCurrentCapacityPercentage() {
        return Math.round((capacity - cargos.size()) / capacity);

    }

    public void addRestriction(String restriction) {
        if (restrictions.contains(restriction)) {
            restrictions.remove(restriction);
        } else restrictions.add(restriction);

    }

    public List<Cargo> getCargoList() {
        return cargos;

    }
}
