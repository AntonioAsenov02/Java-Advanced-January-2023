package Exercises7_Generics.SwapMethodString;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        SwapMethod<String> swapMethod = new SwapMethod<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            swapMethod.add(name);
        }

        int [] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        swapMethod.swap(firstIndex,secondIndex);

        System.out.println(swapMethod);
    }
}
