package citybook.citybook;

import java.util.*;
import java.util.stream.Collectors;

public class CityBook {
    private final List<City> cities;

    public CityBook(List<City> cities) {
        this.cities = cities;
    }

    public void print() {
        cities.forEach(System.out::println);
    }

    public List<City> sort(Comparator<City> comparator) {
        List<City> sortedCityList = new ArrayList<>(cities);
        sortedCityList.sort(comparator);
        return sortedCityList;
    }

    public Map<Integer, Integer> searchMaxPopulation() {
        int max = cities.stream().mapToInt(City::getPopulation).max().getAsInt();
        List<Integer> populationList = cities.stream().map(City::getPopulation).collect(Collectors.toList());

        Map<Integer, Integer> resultMap = new HashMap<>();

        int maxIndex = populationList.indexOf(max);
        int maxPopulation = populationList.get(maxIndex);

        resultMap.put(maxIndex, maxPopulation);
        System.out.println(resultMap);
        return resultMap;
    }

    public void countByRegion() {
        Map<String, Long> collect = cities.stream().collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
        System.out.println(collect.toString());
    }

    public List<City> getCities() {
        return cities;
    }
}
