package ee.taltech.iti0202.parking.parkinglot;

import ee.taltech.iti0202.parking.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Accepts all cars if the queue size is less than 5.
 * (So the maximum number of cars in the queue is 5.)
 * Small car (size 1) with the highest priority can park alone.
 * Otherwise small cars (size 1) can share a slot if they have the same priority.
 * If there is a cars with the highest priority in the queue and there is no room to fit the car,
 * then cars with common priority (if parked) are sent to the queue
 * to make room for the highest priority car (life is unfair).
 */
public class PriorityParkingLot extends ParkingLot {
    /**
     * Initialize the parking slot with the given width and height.
     *
     * @param height Length of vertical side.
     * @param width  Length of horizontal side.
     */
    private int slots;
    private List<Car> parkedCars = new ArrayList<>();
    private List<Car> queueCars = new ArrayList<>();

    public PriorityParkingLot(int height, int width) {
        super(height, width);
        this.slots = height * width;
    }

    @Override
    public boolean addToQueue(Car car) {
        if (!this.queueCars.contains(car) && !car.getQueueStatus()
                && car.getParkingLot() == null && this.queueCars.size() < 5) {
            this.queueCars.add(car);
            this.syncQueueCars(queueCars);
            car.setQueueStatus(true);
            processQueue();
            return true;
        } else return false;
    }

    @Override
    public boolean rules(Car car) {
        return (this.getCarQueue().size() < 5 && !car.getQueueStatus() && car.getParkingLot() == null);
    }

    @Override
    public void processQueue() {
        if (this.getCarQueue().size() > 0) {
            Car x = this.getCarQueue().get(0);
            if (x.getPriorityStatus() == Car.PriorityStatus.HIGHEST && this.slots < x.getSize() / 2) {
                if (this.parkedCars.size() > 0) {
                    for (Car car : this.parkedCars) {
                        if ((car.getSize() / 2 + this.slots) >= x.getSize()
                                && car.getPriorityStatus() == Car.PriorityStatus.COMMON) {
                            this.slots += car.getSize() / 2;
                            car.unpark();
                            this.parkCar(x);
                            this.addToQueue(car);
                            this.slots -= x.getSize() / 2;
                            this.parkedCars = this.getParkedCars();
                            this.queueCars = this.getCarQueue();
                        }
                    }
                }
            }
            if (!this.getParkedCars().contains(x) && this.slots >= x.getSize() / 2
                    && (x.getSize() != 1 && x.getPriorityStatus() != Car.PriorityStatus.HIGHEST)
                    && x.getQueueStatus() && x.getParkingLot() == null) {
                this.parkCar(x);
                this.slots -= x.getSize() / 2;
                this.syncSlots(this.slots);
                this.parkedCars = this.getParkedCars();
                this.queueCars = this.getCarQueue();
            }
            if (!this.getParkedCars().contains(x) && this.slots >= x.getSize() / 2
                    && (x.getSize() == 1 && x.getPriorityStatus() == Car.PriorityStatus.HIGHEST)
                    && x.getQueueStatus() && x.getParkingLot() == null) {
                this.parkCar(x);
                this.slots -= x.getSize();
                this.syncSlots(this.slots);
                this.parkedCars = this.getParkedCars();
                this.queueCars = this.getCarQueue();
            }


        }

    }
}
