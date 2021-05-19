package citybook.citybook;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityTest {

    @Test
    void testToString() {
        List<String> params = List.of("Москва", "Московская облась", "Центральный", "10000000", "1143");
        City city = new City(params);
        String expected = "City{" +
                "name='" + "Москва" + '\'' +
                ", region='" + "Московская область" + '\'' +
                ", district='" + "Центральный" + '\'' +
                ", population=" + 500000 +
                ", foundation=" + "1143" +
                '}';
        String actual = city.toString();
        assertEquals(expected,actual);
    }
}