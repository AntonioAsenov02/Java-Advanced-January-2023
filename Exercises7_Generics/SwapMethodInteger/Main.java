package Exercises7_Generics.SwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        SwapMethod<Integer> swapMethod = new SwapMethod<>();

        for (int i = 0; i < n; i++) {

            int number = Integer.parseInt(scanner.nextLine());
            swapMethod.add(number);
        }

        int [] indexes = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        swapMethod.swap(firstIndex,secondIndex);

        System.out.println(swapMethod);
    }
}
