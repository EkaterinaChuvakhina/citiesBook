package citybook.reader;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class FileReader {
    private FileReader() {

    }

    public static List<String> readAll(String pathToFile) {
        try {
            return Files.readAllLines(Paths.get(pathToFile));
        } catch (IOException e) {
            throw new UncheckedIOException("File with path " + pathToFile + "notfound", e);
        }
    }
}
