package ee.taltech.iti0202.api.agency;

import ee.taltech.iti0202.api.destinations.City;
import ee.taltech.iti0202.api.provider.OnlineDataController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelAgency {

    private List<String> cityNames;
    private OnlineDataController dataController;

    public TravelAgency(List<String> cityNames, OnlineDataController dataController) {
        this.cityNames = cityNames;
        this.dataController = dataController;
    }

    /**
     * If the agency doesn't have a destination city yet, adds it to the list.
     *
     * @param city city name.
     */
    public void addCity(String city) {
        if (!cityNames.contains(city)){
            cityNames.add(city);
        }
    }

    /**
     * Return all the cities that the agency has.
     *
     * @return list of cities
     */
    public List<String> getCityList() {
        return cityNames;
    }


    /**
     * This method tries to find a suitable city for the client to visit.
     * <p>
     * It uses OnlineDataController, to get data for the cities.
     * After getting data about a city, SAVE IT for the duration of the cycle. OpenWeather API updates data every 10 minutes.
     * Create a City object using the CityBuilder here.
     *
     * @param client a client who wants to go somewhere.
     * @return Optional city if the client was happy with it.
     */
    public Optional<City> findSuitableCitiesForClient(Client client) {
        return Optional.empty();
    }

}
