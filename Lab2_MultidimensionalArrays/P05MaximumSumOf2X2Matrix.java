package Lab2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2X2Matrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] input = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRow;
        }

        int biggestSum = Integer.MIN_VALUE;

        int[][] newMatrix = new int[2][2];


        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {

                int currentNumbersSum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];


                if (currentNumbersSum > biggestSum) {

                    biggestSum = currentNumbersSum;
                    newMatrix = new int[][]{
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}

                        };
                }

            }
        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {

                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.print(biggestSum);

    }
}