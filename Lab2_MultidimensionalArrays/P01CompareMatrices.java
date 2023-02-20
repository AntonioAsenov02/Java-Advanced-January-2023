package Lab2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int [] rowsAndCols = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int [][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {

            int [] numbersArr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < cols; col++) {

                matrix[row][col] = numbersArr[col];
            }
        }


        int [] rowsAndCols2 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows2 = rowsAndCols2[0];
        int cols2 = rowsAndCols2[1];

        int [][] matrix2 = new int[rows2][cols2];


        for (int row = 0; row < rows2; row++) {

            int [] numbersArr2 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < cols2; col++) {

                matrix2[row][col] = numbersArr2[col];
            }
        }

        if (areTheMatrixEqual(matrix, matrix2)){

            System.out.println("equal");
        }else {

            System.out.println("not equal");
        }

    }
    public static boolean areTheMatrixEqual(int [][] firstMatrix,int [][]secondMatrix){

        if (firstMatrix.length != secondMatrix.length){

            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {

            if (firstMatrix[row].length != secondMatrix[row].length){

                return false;
            }

            for (int col = 0; col < firstMatrix[row].length; col++) {

                if (firstMatrix[row][col] != secondMatrix[row][col]){

                    return false;
                }
            }
        }
        return true;
    }
}
