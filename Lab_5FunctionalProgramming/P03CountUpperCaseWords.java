package Lab_5FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUpperCaseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> isItUpperCase = word -> Character.isUpperCase(word.charAt(0));

        Consumer<String> printer = word -> System.out.println(word);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(isItUpperCase)
                .collect(Collectors.toList());


        System.out.println(wordsList.size());
        wordsList.forEach(printer);

    }
}
