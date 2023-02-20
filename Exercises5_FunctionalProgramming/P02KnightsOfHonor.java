package Exercises5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P02KnightsOfHonor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = e -> System.out.printf("Sir %s%n",e);

        List<String> input = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        input.forEach(printer);
    }
}