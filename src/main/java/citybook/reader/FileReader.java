package citybook.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class FileReader {
    private FileReader(){

    }
    public static List<String> readAll(String pathToFile) throws IOException {
        return Files.readAllLines(Paths.get(pathToFile));
    }
}
