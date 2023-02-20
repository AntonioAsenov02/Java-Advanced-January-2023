package Lab_3SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07CitiesByContinentAndCountry {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String,String>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {

            String [] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!map.containsKey(continent)){

                map.put(continent,new LinkedHashMap<>());
                map.get(continent).put(country,city);
            }else {

                if (map.get(continent).containsKey(country)){

                    String currentCity = map.get(continent).get(country);
                    map.get(continent).put(country,currentCity + ", " + city).trim();
                }else {

                    map.get(continent).put(country,city);
                }

            }
        }

        for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {

            System.out.printf("%s:%n",entry.getKey());
            for (Map.Entry<String, String> newEntry : entry.getValue().entrySet()) {

                System.out.printf("%s -> %s %n",newEntry.getKey(),newEntry.getValue());
            }

        }

    }
}
