package Lab_5FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] numbersArr = scanner.nextLine().split(", ");

        List<String> numbersList = Arrays.stream(numbersArr)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ",numbersList));

        numbersList = numbersList.stream()
                .map(e -> Integer.parseInt(e))
                .sorted()
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ",numbersList));
    }
}
