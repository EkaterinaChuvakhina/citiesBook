package citybook.comparator;

import citybook.citybook.City;

import java.util.Comparator;

public class DescDistrictComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.getDistrict().compareTo(o2.getDistrict());
    }
}
