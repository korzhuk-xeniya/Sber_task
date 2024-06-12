package pro.sky;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("src/main/resources/ВСJavaSber.csv"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            City city = parseCSVLine(scanner.next());
            System.out.println(city.toString());
        }
        scanner.close();

    }

    private static City parseCSVLine(String line) throws FileNotFoundException {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.next();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        } else {
            foundation = null;
        }
        Main main = new Main();
        return main.new City(name, region, district, population, foundation);
    }

    private class City {
        private final String name;
        private final String region;
        private final String district;
        private final int population;
        private final String foundation;

        public City(String name, String region, String district, int population, String foundation) {
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
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
}