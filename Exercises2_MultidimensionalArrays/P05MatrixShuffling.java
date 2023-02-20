package Exercises2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int [] inputs = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int rows = inputs[0];
        int cols = inputs[1];

        String [][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {

            String [] currentLine = scanner.nextLine().split(" ");

            matrix[row] = currentLine;
        }

        String commandInput = scanner.nextLine();
        while (!commandInput.equals("END")){

            String [] commandInput1 = commandInput.split(" ");

            String command = commandInput1[0];

            if (commandInput1.length == 5){

                if (command.equals("swap")){

                    int rowToModify = Integer.parseInt(commandInput1[1]);
                    int colToModify = Integer.parseInt(commandInput1[2]);
                    int newRow = Integer.parseInt(commandInput1[3]);
                    int newCol = Integer.parseInt(commandInput1[4]);

                    if (isValidIndex(matrix,rowToModify,colToModify,newRow,newCol)){

                        String text1 = matrix[rowToModify][colToModify];
                        String text2 = matrix[newRow][newCol];

                        matrix[rowToModify][colToModify] = text2;
                        matrix[newRow][newCol] = text1;

                        printMatrix(matrix);
                    }

                }
            }else {

                System.out.println("Invalid input!");
            }

            commandInput = scanner.nextLine();
        }


    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(String[][] matrix, int rowToModify, int colToModify, int newRow, int newCol) {

        if (matrix.length - 1 < rowToModify && matrix.length < colToModify
        || matrix.length - 1 < newRow && matrix.length < newCol){

            System.out.println("Invalid input!");
             return false;
        }else {
            return true;
        }

    }
}
