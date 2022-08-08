import java.util.ArrayList;

public class Controller {
    ArrayList<City> citiesWithoutCoutry = new ArrayList<>();
    ArrayList<Country> countries = new ArrayList<>();

    public void createCity(String nameOfCity) {
        citiesWithoutCoutry.add(new City(nameOfCity));
    }

    public void createCounry(String nameOfCountry) {
        countries.add(new Country(nameOfCountry));
    }

    public void addCityToCountryFromCitiesWithoutCoutry(int idCountry, int idCity) {
        countries.get(idCountry).addCities(citiesWithoutCoutry.remove(idCity));
    }

    public ArrayList<City> getCitiesFromCountry(int idCountry) {
        return countries.get(idCountry).allCities;
    }

    public ArrayList<City> findCitiesOnInfo(int idCountry) {
        ArrayList<City> bestCities = new ArrayList<>();
        bestCities.add(getCitiesFromCountry(idCountry).get(0));
        bestCities.add(getCitiesFromCountry(idCountry).get(0));
        bestCities.add(getCitiesFromCountry(idCountry).get(0));

        for (City city : getCitiesFromCountry(idCountry)) {
            if (city.getMaxTemp() > bestCities.get(0).getMaxTemp()) {
                bestCities.set(0, city);
            }
            if (city.getMinTemp() < bestCities.get(0).getMinTemp()) {
                bestCities.set(1, city);
            }
            if (city.getPressure() > bestCities.get(0).getPressure()) {
                bestCities.set(0, city);
            }
            if (city.getPressure() < bestCities.get(0).getPressure()) {
                bestCities.set(1, city);
            }
            if (city.getHumidity() > bestCities.get(0).getHumidity()) {
                bestCities.set(0, city);
            }
            if (city.getHumidity() < bestCities.get(0).getHumidity()) {
                bestCities.set(1, city);
            }
            if (city.getPrecipitation() > bestCities.get(0).getPrecipitation()) {
                bestCities.set(0, city);
            }
            if (city.getPrecipitation() < bestCities.get(0).getPrecipitation()) {
                bestCities.set(1, city);
            }
        }
        return bestCities;
    }

    public ArrayList<City> findTheBestCitiForLife(int idCountry) {
        ArrayList<City> bestCities = new ArrayList<>();
        bestCities.add(getCitiesFromCountry(idCountry).get(0));
        bestCities.add(getCitiesFromCountry(idCountry).get(0));
        bestCities.add(getCitiesFromCountry(idCountry).get(0));

        for (City city : getCitiesFromCountry(idCountry)) {
            if (city.getMaxTemp() <= 27 && city.getMinTemp() >= 18 && city.getPressure() >= 700 && city.getPressure() <= 800 && city.getHumidity() >= 70 && city.getHumidity() <= 80 && city.getPrecipitation() == 2) {
                bestCities.set(0, city);
            }
        }
        return bestCities;
    }
}




