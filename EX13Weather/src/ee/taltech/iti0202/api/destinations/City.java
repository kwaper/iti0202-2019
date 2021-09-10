package ee.taltech.iti0202.api.destinations;

import java.util.ArrayList;
import java.util.List;

public class City {
    City(String name, double lon, double lat, List<Double> temperatures,
         List<Double> humidity, List<Integer> weatherCodes) {
    }

    public String getName() {
        return "";
    }

    public double getLon() {
        return 0.0;
    }

    public double getLat() {
        return 0.0;
    }

    public List<Double> getTemperatures() {
        return new ArrayList<>();
    }

    public List<Double> getHumidity() {
        return new ArrayList<>();
    }

    public List<Integer> getWeatherCodes() {
        return new ArrayList<>();
    }

    public double getAverageTemperature() {
        return 0.00;
    }


    public double getAverageHumidity() {
        return 0.00;
    }

}
