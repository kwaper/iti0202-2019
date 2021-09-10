package ee.taltech.iti0202.api.agency;

import ee.taltech.iti0202.api.destinations.City;
import ee.taltech.iti0202.api.strategies.CityFinderStrategy;

import java.util.List;
import java.util.Optional;

public class Client {

    public Client(String name, String startingCity, CityFinderStrategy choosingStrategy) {
    }

    public Client(String name, String startingCity, CityFinderStrategy choosingStrategy, List<String> wantsToVisitCities) {
    }


    public String getName() {
        return "";
    }

    public String getStartingCity() {
        return "";
    }

    public CityFinderStrategy getChoosingStrategy() {
        return null;
    }

    public List<String> getCitiesThatWantsToVisit() {
        return null;
    }

    public Optional<City> chooseBestCity(List<City> possibleCities) {
        return Optional.empty();
    }
}
