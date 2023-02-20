package Lab_5FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04AddVAT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] prices = scanner.nextLine().split(", ");

        Function<String,Double> parseDouble = e -> Double.parseDouble(e);
        Function<Double,Double> addVat = e -> 1.2 * e;
        Consumer<Double> printer = e -> System.out.printf("%.2f%n",e);

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(parseDouble)
                .map(addVat)
                .forEach(printer);
    }
}
