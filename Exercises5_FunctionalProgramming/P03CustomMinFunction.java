package Exercises5_FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Function<String,Integer> mapper = Integer::parseInt;
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(mapper)
                .collect(Collectors.toList());

        Consumer<List<Integer>> print = list -> System.out.println(Collections.min(list));

        print.accept(numbers);
    }
}
