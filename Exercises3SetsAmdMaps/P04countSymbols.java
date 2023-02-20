package Exercises3SetsAmdMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04countSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<Character, Integer> countMap = new TreeMap<>();

        String input = scanner.nextLine();



            for (Character symbol : input.toCharArray()) {

                if (!countMap.containsKey(symbol)) {

                    countMap.put(symbol, 1);
                } else {
                    int currentCount = countMap.get(symbol);
                    countMap.put(symbol, currentCount + 1);
                }
            }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {

            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }

    }
}
