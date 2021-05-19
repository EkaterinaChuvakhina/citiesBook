package citybook.citybook;

import citybook.comparator.AscNameComparator;
import citybook.comparator.DescDistrictComparator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityBookTest {

    @Test
    void sortByNamePositive() {

        List<String> params = List.of("1","Москва", "Московская область", "Центральный", "10000000", "1143");
        List<String> params1 = List.of("2","Новосибирск", "Алтайский край", "Сибирский", "600000", "1983");
        List<String> params2 = List.of("3","Казань", "Алтайский край", "Сибирский", "20000000", "1973");
        List<String> params3 = List.of("4","Алейск", "Алтайский край", "Сибирский", "20000", "1953");
        Comparator<City> comparator = new AscNameComparator();
        List<City> expected = new ArrayList<>();

        City city1 = new City(params);
        City city2 = new City(params1);
        City city3 = new City(params2);
        City city4 = new City(params3);

        expected.add(city4);
        expected.add(city3);
        expected.add(city1);
        expected.add(city2);

        List<City> actual = new ArrayList<>();
        actual.add(city1);
        actual.add(city2);
        actual.add(city3);
        actual.add(city4);
        CityBook cityBookActual = new CityBook(actual);

        assertEquals(expected, cityBookActual.sort(comparator));
    }

    @Test
    void sortByDistrictPositive() {

        List<String> params = List.of("1","Москва", "Московская область", "Центральный", "10000000", "1143");
        List<String> params1 = List.of("2","Новосибирск", "Алтайский край", "Сибирский", "600000", "1983");
        List<String> params2 = List.of("3","Казань", "Алтайский край", "Сибирский", "20000000", "1973");
        List<String> params3 = List.of("4","Алейск", "Алтайский край", "Сибирский", "20000", "1953");

        List<City> expected = new ArrayList<>();
        Comparator<City> comparator = new AscNameComparator();

        City city1 = new City(params);
        City city2 = new City(params1);
        City city3 = new City(params2);
        City city4 = new City(params3);

        expected.add(city1);
        expected.add(city4);
        expected.add(city3);
        expected.add(city2);

        List<City> actual = new ArrayList<>();
        actual.add(city1);
        actual.add(city2);
        actual.add(city3);
        actual.add(city4);
        CityBook cityBookActual = new CityBook(actual);

        assertEquals(expected, cityBookActual.sort(new DescDistrictComparator().thenComparing(new AscNameComparator())));
    }

    @Test
    void searchMaxPopulationPositive() {
        List<City> cities = new ArrayList<>();

        List<String> params = List.of("1","Москва", "Московская область", "Центральный", "10000000", "1143");
        List<String> params1 = List.of("2","Новосибирск", "Алтайский край", "Сибирский", "600000", "1983");
        List<String> params2 = List.of("3","Казань", "Алтайский край", "Сибирский", "20000000", "1973");
        List<String> params3 = List.of("4","Алейск", "Алтайский край", "Сибирский", "20000", "1953");

        City city1 = new City(params);
        City city2 = new City(params1);
        City city3 = new City(params2);
        City city4 = new City(params3);

        cities.add(city1);
        cities.add(city4);
        cities.add(city3);
        cities.add(city2);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(2, 20000000);

        Map<Integer, Integer> actual = new CityBook(cities).searchMaxPopulation();
        assertEquals(expected, actual);
    }

    @Test
    void countByRegionPositive() {
        List<City> cities = new ArrayList<>();

        List<String> params = List.of("1","Москва", "Московская область", "Центральный", "10000000", "1143");
        List<String> params1 = List.of("2","Новосибирск", "Алтайский край", "Сибирский", "600000", "1983");
        List<String> params2 = List.of("3","Казань", "Алтайский край", "Сибирский", "20000000", "1973");
        List<String> params3 = List.of("4","Алейск", "Алтайский край", "Сибирский", "20000", "1953");

        City city1 = new City(params);
        City city2 = new City(params1);
        City city3 = new City(params2);
        City city4 = new City(params3);

        cities.add(city1);
        cities.add(city4);
        cities.add(city3);
        cities.add(city2);


        HashMap<String, Long> expected = new HashMap<>();
        expected.put("Московская область", 1L);
        expected.put("Алтайский край", 3L);


        Map<String, Long> actual = new CityBook(cities).countByRegion();
        assertEquals(expected, actual);
    }
}