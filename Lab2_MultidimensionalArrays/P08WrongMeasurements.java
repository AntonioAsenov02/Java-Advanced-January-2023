package Lab2_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08WrongMeasurements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int length = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[length][];

        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = readsArray(scanner);

        }

        int [] indexes = readsArray(scanner);

        int valueToReplace = matrix[indexes[0]][indexes[1]];

        List<int []> correctValuesList = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {

                if (matrix[r][c] == valueToReplace){

                    int correctValue = getNearbySum(matrix,r,c,valueToReplace);

                    correctValuesList.add(new int [] {r,c,correctValue});

                }
            }
        }

        for (int [] correctValues : correctValuesList) {

            int row = correctValues[0];
            int col = correctValues[1];
            matrix[row][col] = correctValues[2];
            
        }

        for (int [] arr : matrix) {
            for (int n : arr) {

                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    private static int getNearbySum(int[][] matrix, int r, int c, int valueToReplace) {

        int sum = 0;

        if (isInBounds(matrix,r - 1,c) && matrix[r - 1][c] != valueToReplace ){
            sum += matrix[r - 1][c];
        }if (isInBounds(matrix,r + 1,c) && matrix[r + 1][c] != valueToReplace) {
            sum += matrix[r + 1][c];
        }if (isInBounds(matrix,r,c - 1) && matrix[r][c - 1] != valueToReplace) {
            sum += matrix[r][c - 1];
        }if (isInBounds(matrix,r,c + 1) && matrix[r][c + 1] != valueToReplace) {
            sum += matrix[r][c + 1];
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static int[]readsArray (Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
