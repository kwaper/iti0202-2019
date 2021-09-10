package ee.taltech.iti0202.api.agency;

import ee.taltech.iti0202.api.strategies.CityFinderStrategy;

import java.util.List;

public class ChoosingClient extends Client {
    public ChoosingClient(String name, String startingCity, CityFinderStrategy choosingStrategy) {
        super(name, startingCity, choosingStrategy);
    }

    public ChoosingClient(String name, String startingCity, CityFinderStrategy choosingStrategy, List<String> wantsToVisitCities) {
        super(name, startingCity, choosingStrategy, wantsToVisitCities);
    }
}
