package citybook.comparator;

import citybook.citybook.City;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AscNameComparatorTest {

    @Test
    void compare() {
        List<String> params = List.of("1","Москва", "Московская облась", "Центральный", "10000000", "1143");
        List<String> params2 = List.of("2","Казань", "Алтайский край", "Сибирский", "20000000", "1973");

        City city1 = new City(params);
        City city2 = new City(params2);

        int expected = 2;

        int actual = new AscNameComparator().compare(city1, city2);
        assertEquals(expected, actual);
    }
}