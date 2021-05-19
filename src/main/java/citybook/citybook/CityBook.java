package citybook.citybook;

import java.util.*;
import java.util.stream.Collectors;

public class CityBook {
    private final List<City> cities;

    public CityBook(List<City> cities) {
        this.cities = cities;
    }

    public List<City> sort(Comparator<City> comparator) {
        List<City> sortedCityList = new ArrayList<>(cities);
        sortedCityList.sort(comparator);
        return sortedCityList;
    }

    public Map<Integer, Integer> searchMaxPopulation() {
        int[] arr = cities.stream().mapToInt(City::getPopulation).toArray();

        int maxElement = arr[0];
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxIndex = i;
                maxElement = arr[i];
            }
        }
        Map<Integer, Integer> resultMap = new HashMap<>();

        resultMap.put(maxIndex, maxElement);
        return resultMap;
    }

    public Map<String, Long> countByRegion() {
        return cities.stream().collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
    }

    public List<City> getCities() {
        return cities;
    }
}
