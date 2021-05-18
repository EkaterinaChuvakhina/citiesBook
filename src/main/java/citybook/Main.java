package citybook;

import citybook.citybook.City;
import citybook.citybook.CityBook;
import citybook.menu.Menu;
import citybook.parser.LineParser;
import citybook.reader.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PATH_TO_FILE = "city.txt";
    public static void main(String[] args) throws IOException {
//        System.out.println("Enter path to file: ");
//        Scanner scanner = new Scanner(System.in);
//        String pathToFile = scanner.next();

        List<String> lines = FileReader.readAll(PATH_TO_FILE);
        List<City> cities = new ArrayList<>();
        CityBook cityBook = new CityBook(cities);

        for (String line: lines){
            cities.add(LineParser.parse(line));
        }



        Menu.showMenu(cityBook);
    }
}
