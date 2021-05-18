package citybook.citybook;

import citybook.comparator.AscNameComparator;
import citybook.comparator.DescDistrictComparator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CityBookTest {

    @Test
    void print() {
        List<City> cities = new ArrayList<>();
    }


    @Test
    void sortASC() {

        Comparator<City> comparator = new AscNameComparator();
        List<City> expected = new ArrayList<>();


        City city1 = new City("Москва", "Московская облась", "Центральный", 10000000, "1143");
        City city2 = new City("Новосибирск", "Алтайский край", "Сибирский", 600000, "1983");
        City city3 = new City("Казань", "Алтайский край", "Сибирский", 20000000, "1973");
        City city4 = new City("Алейск", "Алтайский край", "Сибирский", 20000, "1953");

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
    void sortDESC() {

        List<City> expected = new ArrayList<>();


        City city1 = new City("Москва", "Московская облась", "Центральный", 10000000, "1143");
        City city2 = new City("Новосибирск", "Алтайский край", "Сибирский", 600000, "1983");
        City city3 = new City("Казань", "Алтайский край", "Сибирский", 20000000, "1973");
        City city4 = new City("Алейск", "Алтайский край", "Сибирский", 20000, "1953");

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
    void searchMaxPopulation() {
        List<City> cities = new ArrayList<>();

        City city1 = new City("Москва", "Московская облась", "Центральный", 500000, "1143");
        City city2 = new City("Новосибирск", "Алтайский край", "Сибирский", 200000, "1983");
        City city3 = new City("Казань", "Алтайский край", "Сибирский", 300000, "1973");
        City city4 = new City("Алейск", "Алтайский край", "Сибирский", 400000, "1953");

        cities.add(city1);
        cities.add(city4);
        cities.add(city3);
        cities.add(city2);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 500000);

        Map<Integer, Integer> actual = new CityBook(cities).searchMaxPopulation();
        assertEquals(expected, actual);
    }

    @Test
    void countByRegion() {
        List<City> cities = new ArrayList<>();

        City city1 = new City("Москва", "Московская область", "Центральный", 500000, "1143");
        City city2 = new City("Новосибирск", "Алтайский край", "Сибирский", 200000, "1983");
        City city3 = new City("Казань", "Алтайский край", "Сибирский", 300000, "1973");
        City city4 = new City("Алейск", "Алтайский край", "Сибирский", 400000, "1953");

        cities.add(city1);
        cities.add(city4);
        cities.add(city3);
        cities.add(city2);

        HashMap<String, Long> expected = new HashMap<>();
        expected.put("Московская область",1L);
        expected.put("Алтайский край",3L);


        Map<String, Long> actual = new CityBook(cities).countByRegion();
        assertEquals(expected, actual);
    }
}