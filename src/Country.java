import java.util.ArrayList;

public class Country {
    ArrayList<City> allCities;
    String nameOfCountry;


    public Country(String nameOfCity) {
        this.allCities = new ArrayList<>();
        this.nameOfCountry = nameOfCity;
    }
    public Country(ArrayList<City> allCities) {
        this.allCities = new ArrayList<>();
    }
    public void addCities(City city){
        allCities.add(city);
    }

    @Override
    public String toString() {
        return "Список стран: " + nameOfCountry;
    }
}
