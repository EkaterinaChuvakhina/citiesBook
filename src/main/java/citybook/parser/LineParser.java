package citybook.parser;

import citybook.citybook.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class LineParser {
    public static final int COUNT_PARAMETERS = 6;
    private LineParser() {
    }

    public static City parse(String line) {
        Scanner scanner = new Scanner(line).useDelimiter(";");

        List<String> parameters = new ArrayList<>();
        while (scanner.hasNext()){
            parameters.add(scanner.next());
        }
        if(parameters.size() == COUNT_PARAMETERS){
            return new City(parameters);
        }
        else {
            throw new IllegalArgumentException();
        }

    }
}
