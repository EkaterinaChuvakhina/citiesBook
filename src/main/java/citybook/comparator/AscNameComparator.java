package citybook.comparator;


import citybook.citybook.City;

import java.util.Comparator;

public class AscNameComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.getName().compareToIgnoreCase(city2.getName());
    }
}
