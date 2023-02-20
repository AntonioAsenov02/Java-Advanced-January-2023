package Exercises5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P09ListOfPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());


        BiFunction<Integer, List<Integer>,Boolean> isDivisible = ((number,list) -> {

            for (int divisionNumber : list) {
                if (number % divisionNumber != 0){
                    return false;
                }
            }
            return true;
        });

        for (int i = 1; i <= n ; i++) {

           if (isDivisible.apply(i,numbersList)){
               System.out.print(i + " ");
           }
        }

    }
}
