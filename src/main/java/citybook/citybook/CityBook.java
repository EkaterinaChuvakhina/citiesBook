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
        int max = cities.stream().map(City::getPopulation).max(Integer::compareTo).get();
        int[] arr = cities.stream().mapToInt(City::getPopulation).toArray();
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                maxIndex = i;
            }
        }
        Map<Integer, Integer> resultMap = new HashMap<>();

        resultMap.put(maxIndex, max);
        return resultMap;
    }

    public Map<String, Long> countByRegion() {
        Map<String, Long> collect = cities.stream().collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
        return collect;
    }

    public List<City> getCities() {
        return cities;
    }
}
