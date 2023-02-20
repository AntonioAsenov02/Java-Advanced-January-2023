package Exercises3SetsAmdMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Set<String> chemicalsSet = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {


            String [] currentLine = scanner.nextLine().split("\\s+");

            for (int j = 0; j <= currentLine.length - 1 ; j++) {

                String currentElement = currentLine[j];
                chemicalsSet.add(currentElement);
            }
        }

        for (String element : chemicalsSet) {

            System.out.print(element + " ");
        }
    }
}
