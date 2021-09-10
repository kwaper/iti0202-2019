package ee.taltech.iti0202.api.destinations;

import java.util.List;

public class CityBuilder {
    private String name;
    private double lon;
    private double lat;
    private List<Double> temperatures;
    private List<Double> humidity;
    private List<Integer> weatherCodes;

    public CityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CityBuilder setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public CityBuilder setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public CityBuilder setTemperatures(List<Double> temperatures) {
        this.temperatures = temperatures;
        return this;
    }

    public CityBuilder setHumidity(List<Double> humidity) {
        this.humidity = humidity;
        return this;
    }

    public CityBuilder setWeatherCodes(List<Integer> weatherCodes) {
        this.weatherCodes = weatherCodes;
        return this;
    }

    public City createCity() {
        return new City(name, lon, lat, temperatures, humidity, weatherCodes);
    }
}
