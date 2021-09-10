package ee.taltech.iti0202.parking.parkinglot;

import ee.taltech.iti0202.parking.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * This parking lot only accepts small cars (size 1).
 * Each parking slot only accepts one car.
 */
public class SmallCarParkingLot extends ParkingLot {
    /**
     * Initialize the parking slot with the given width and height.
     *
     * @param height
     * @param width
     */

    private List<Car> queueSmallCars = new ArrayList<>();

    private List<Car> parkedSmallCars = new ArrayList<>();

    private int slots;

    @Override
    public boolean rules(Car car) {
        return (car.getSize() == 1 && !car.getQueueStatus() && car.getParkingLot() == null);
    }

    public SmallCarParkingLot(int height, int width) {
        super(height, width);
        this.slots = height * width;
    }

    @Override
    public void unparkCar(Car car) {
        if (this.getParkedCars().contains(car)) {
            this.parkedSmallCars = this.getParkedCars();
            this.parkedSmallCars.remove(car);
            this.slots++;
            this.syncSlots(this.slots);
            this.syncParkedCars(this.parkedSmallCars);
        }
    }

    @Override
    public void processQueue() {
        if (this.getCarQueue().size() > 0) {
            Car x = this.getCarQueue().get(0);
            if (x.getSize() == 1 && !this.getParkedCars().contains(x) && this.slots > 0
                    && x.getQueueStatus() && x.getParkingLot() == null) {
                this.parkCar(x);
                this.slots--;
                this.syncSlots(this.slots);
                this.parkedSmallCars = this.getParkedCars();
                this.queueSmallCars = this.getCarQueue();
            }

        }

    }

    @Override
    public boolean addToQueue(Car car) {
        processQueue();
        this.queueSmallCars = this.getCarQueue();
        if (car.getSize() == 1 && !this.getParkedCars().contains(car)) {
            this.queueSmallCars.add(car);
            this.syncQueueCars(this.queueSmallCars);
            car.setQueueStatus(true);
            processQueue();
            return true;
        } else return false;
    }

}
