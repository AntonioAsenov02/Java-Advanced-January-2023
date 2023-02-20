package Exercises5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetic {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>,List<Integer>> operations;
        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));

        String input = scanner.nextLine();
        while (!input.equals("end")){

            switch (input) {
                case "add":

                    operations = list -> list.stream().map(number -> number + 1).collect(Collectors.toList());
                    numbers = operations.apply(numbers);
                    break;
                case "multiply":

                    operations = list -> list.stream().map(number -> number * 2).collect(Collectors.toList());
                    numbers = operations.apply(numbers);
                    break;
                case "subtract":

                    operations = list -> list.stream().map(number -> number - 1).collect(Collectors.toList());
                    numbers = operations.apply(numbers);
                    break;
                case "print":

                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
