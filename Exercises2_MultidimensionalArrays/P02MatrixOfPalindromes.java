package Exercises2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;


public class P02MatrixOfPalindromes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int r = input[0];
        int c = input[1];

        String[][] matrix = new String[r][c];

        char startLetter = 'a';
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {

                String palindrome = "" + startLetter + (char)(startLetter + col) + startLetter;

                matrix[row][col] = palindrome;
            }

            startLetter = (char) (startLetter + 1);
        }

        printMatrix(matrix,r,c);
    }

    private static void printMatrix(String[][] matrix, int r, int c) {

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {

                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}
