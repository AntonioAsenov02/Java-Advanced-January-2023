package Exercises2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        int [][] matrix = new int[rows][cols];

        fillMatrix(rows,matrix,scanner);

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1){

            int r = row;
            int c = col;

            while (c < cols && r >= 0){

                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == - 1){
                col = 0;
                row--;
            }
        }

        }

    private static void fillMatrix(int rows, int[][] matrix,Scanner scanner) {

        for (int row = 0; row < rows; row++) {

            int [] currentLine = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            matrix[row] = currentLine;
        }
    }
}
