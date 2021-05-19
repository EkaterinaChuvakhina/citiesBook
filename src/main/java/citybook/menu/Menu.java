package citybook.menu;

import citybook.citybook.CityBook;
import citybook.comparator.AscNameComparator;
import citybook.comparator.DescDistrictComparator;
import citybook.printer.CityBookConsolePrinter;

import java.util.Scanner;

public final class Menu {

    private Menu() {
    }

    public static void showMenu(CityBook cityBook) {

        System.out.println("Select one option and enter the desired number");
        System.out.println("1: Print a list of cities");
        System.out.println("2: Sort the list of cities by name in alphabetical order");
        System.out.println("3: Sort the list of cities by district in descending order and by name");
        System.out.println("4: Find max population");
        System.out.println("5: Count by region");
        System.out.println("0: Exit");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                   CityBookConsolePrinter.print(cityBook.getCities());
                    break;
                case 2:
                    CityBookConsolePrinter.print(cityBook.sort(new AscNameComparator()));
                    break;
                case 3:
                    CityBookConsolePrinter.print(cityBook.sort(new DescDistrictComparator().thenComparing(new AscNameComparator())));
                    break;
                case 4:
                    System.out.println(cityBook.searchMaxPopulation());
                    break;
                case 5:
                    System.out.println(cityBook.countByRegion());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter unknown option, please, re-enter");
            }
        }
    }
}
