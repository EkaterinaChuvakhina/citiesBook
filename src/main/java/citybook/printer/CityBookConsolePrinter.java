package citybook.printer;

import citybook.citybook.City;

import java.util.List;

public final class CityBookConsolePrinter {
    private CityBookConsolePrinter() {
    }

    public static void print(List<City> citiBook){
        citiBook.forEach(System.out::println);
    }
}
