package Lab_3SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;

public class P09Largest3Numbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(
                        (left,right) -> right.compareTo(left))
                .limit(3)
                .forEach(number -> System.out.printf("%d ",number));
    }
}
