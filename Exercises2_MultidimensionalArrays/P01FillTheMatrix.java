package Exercises2_MultidimensionalArrays;

import java.util.Scanner;

public class P01FillTheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String [] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int [][] matrix = new int[n][n];


        if (pattern.equals("A")){

            printPatternA(matrix);

        }else if (pattern.equals("B")){

            printPatternB(matrix);
        }

        printMatrix(matrix);

    }
    private static void printPatternA(int[][] matrix) {

        int currentNumber = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {

                matrix[row][col] = currentNumber;

                currentNumber++;
            }
        }
    }
    private static void printPatternB(int[][] matrix) {

        int currentNumber = 1;

        for (int col = 0; col < matrix.length; col++) {

            if (col % 2 == 0){

                for (int row = 0; row < matrix.length; row++) {

                    matrix[row][col] = currentNumber;

                    currentNumber++;
                }
            }else {

                for (int row = matrix.length - 1; row >= 0 ; row--) {

                    matrix[row][col] = currentNumber;

                    currentNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
