package citybook.parser;

import citybook.citybook.City;

import java.util.Scanner;

public final class LineParser {
    private LineParser() {
    }

    public static City parse(String line) {
            Scanner sc = new Scanner(line).useDelimiter(";");

            int number = sc.nextInt();
            String name = sc.next() ;
            String region = sc.next();
            String district = sc.next();
            int population = sc.nextInt();
            String foundation = sc.next();
            return new City(name,region,district,population,foundation);
    }
}
