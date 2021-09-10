package ee.taltech.iti0202.kt1.port;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private String name;
    private List<Ship> ships = new ArrayList<>();
    private List<Cargo> cargos = new ArrayList<>();

    public Port(String name, List<Ship> ships) {
        this.name = name;
        this.ships = ships;
    }

    public Port(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;

    }

    public List<Ship> getShips() {
        return this.ships;

    }

    public List<Cargo> getCargoStorage() {
        return this.cargos;
    }

    public void addShip(Ship ship) {
        if (!this.ships.contains(ship) && ship != null) {
            this.ships.add(ship);
        }

    }

    public void addCargo(List<Cargo> cargoList) {
        for (Cargo c : cargoList) {
            if (!cargos.contains(c)) {
                cargos.add(c);
            }
        }
    }

    public int emptyCargoStorage() {
        return 0;

    }

}
