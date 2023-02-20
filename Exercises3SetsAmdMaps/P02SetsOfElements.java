package Exercises3SetsAmdMaps;

import java.util.*;

public class P02SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secodSet = new LinkedHashSet<>();

        int [] tokens = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int firstInputLines = tokens[0];
        int secondInputLines = tokens[1];

        for (int i = 1; i <= firstInputLines ; i++) {

            int number = Integer.parseInt(scanner.nextLine());

            firstSet.add(number);
        }

        for (int i = 1; i <= secondInputLines ; i++) {

            int number = Integer.parseInt(scanner.nextLine());

            secodSet.add(number);
        }

        for (Integer number : firstSet) {

            if (secodSet.contains(number)){

                System.out.print(number + " ");
            }
        }
    }
}
