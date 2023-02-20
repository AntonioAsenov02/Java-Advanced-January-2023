package Lab_5FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] bounds = scanner.nextLine().split(" ");

        int lowerBound = Integer.parseInt(bounds[0]);
        int upperBound = Integer.parseInt(bounds[1]);

        String oddOrEven = scanner.nextLine();

        Predicate<Integer> predicate;
        if (oddOrEven.equals("odd")){

            predicate = e -> e % 2 != 0;
        }else {

            predicate = e -> e % 2 == 0;
        }

        IntStream.rangeClosed(lowerBound,upperBound)
                .filter(predicate::test)
                .forEach(number -> System.out.print(number + " "));
    }
}
