package Exercises2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {

            int [] currentLine = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            matrix[row] = currentLine;
        }

        int firstDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {

            firstDiagonalSum += matrix[i][i];
        }

        int secondDiagonalSum = 0;
        int currentCol = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {


            secondDiagonalSum += matrix[row][currentCol];

            currentCol++;
        }

        int value = Math.abs(firstDiagonalSum - secondDiagonalSum);

        System.out.println(value);
    }
}
