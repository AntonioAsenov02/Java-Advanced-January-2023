package Exercises7_Generics.CountMethodStrings;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        CountMethod<String> countMethod = new CountMethod<>();

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            countMethod.add(input);
        }

        String compareWith = scanner.nextLine();

        System.out.println(countMethod.countGreaterThan(compareWith));
    }
}
