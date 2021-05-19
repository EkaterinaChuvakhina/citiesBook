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
        List<Integer> populationList = cities.stream().map(City::getPopulation).collect(Collectors.toList());

        Map<Integer, Integer> resultMap = new HashMap<>();

        int maxIndex = populationList.indexOf(max);
        int maxPopulation = populationList.get(maxIndex);

        resultMap.put(maxIndex, maxPopulation);
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
