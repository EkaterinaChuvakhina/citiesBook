package citybook.citybook;

import java.util.List;

public class City {
    private final String name;
    private final String region;
    private final String district;
    private final int population;
    private final String foundation;

    public City(List<String> parameters) {
        this.name = parameters.get(1);
        this.region = parameters.get(2);
        this.district = parameters.get(3);
        this.population = Integer.parseInt(parameters.get(4));
        this.foundation = parameters.get(5);
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}
