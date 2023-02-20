package Exercises5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Consumer<List<Integer>> printLastIndex = list -> {

            int minNumber = Collections.min(numbers);
            System.out.println(numbers.lastIndexOf(minNumber));
        };

        printLastIndex.accept(numbers);
    }
}
