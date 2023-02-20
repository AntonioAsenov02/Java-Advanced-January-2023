package Exercises3SetsAmdMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Set<String> useramesSet = new LinkedHashSet<>();

        for (int i = 1; i <= n ; i++) {

            String name = scanner.nextLine();

            useramesSet.add(name);
        }

        for (String name : useramesSet) {

            System.out.println(name);
        }
    }
}
