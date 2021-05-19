package citybook.reader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void readAll() throws IOException {
        List<String> expected = List.of(
                "1;Новосибирск;Новосибирская область;Сибирский;1489921;1893",
                "3;Алейск;Алтайский край;Сибирский;28528;1913",
                "5;Бийск;Алтайский край;Сибирский;203826;1709");
        List<String> actual = FileReader.readAll("src/test/resources/city_test.txt");
        assertEquals(expected, actual);
    }
}