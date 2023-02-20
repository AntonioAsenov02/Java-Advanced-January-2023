package Exercises7_Generics.CountMethodDoubble;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        CountMethod<Double> countMethod = new CountMethod<>();

        for (int i = 0; i < n; i++) {

            double number = Double.parseDouble(scanner.nextLine());
            countMethod.add(number);
        }

        double compareWithNumber = Double.parseDouble(scanner.nextLine());

        System.out.println(countMethod.greaterElementsCount(compareWithNumber));
    }
}
