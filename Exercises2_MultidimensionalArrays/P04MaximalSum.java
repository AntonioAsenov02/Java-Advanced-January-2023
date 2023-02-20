package Exercises2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();


        int rows = input[0];
        int cols = input[1];

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            int [] currentLine = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();


            matrix[row] = currentLine;
        }

        int biggestSum = Integer.MIN_VALUE;

        int [][] newMatrix = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {

                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                                 matrix[row][col + 2] + matrix[row + 1][col] +
                                 matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                                 matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > biggestSum){

                    biggestSum = currentSum;

                     newMatrix = new int[][]{

                        {matrix[row][col],matrix[row][col + 1], matrix[row][col + 2]},
                        {matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]},
                        {matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]}
                    };
                }
            }
        }

        System.out.printf("Sum = %d%n",biggestSum);

        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix.length; col++) {

                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
