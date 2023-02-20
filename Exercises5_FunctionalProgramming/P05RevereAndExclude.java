package Exercises5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05RevereAndExclude {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisionNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        Predicate<Integer> isItDividable = number -> number % divisionNumber == 0;

        numbers.removeIf(isItDividable);

        numbers.forEach(number -> System.out.print(number + " "));
    }
}
