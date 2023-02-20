package ExamPreparation13;

import java.util.Scanner;

public class P02FormulaOne {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        String [][] matrix = new String[n][n];

        fillMatrix(scanner,n,matrix);

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (matrix[row][col].equals("P")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        matrix[currentRow][currentCol] = ".";
        while (numberOfCommands > 0){

            String command = scanner.nextLine();
            switch (command){

                case "up" :
                    currentRow--;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentRow = n - 1;
                    }
                    break;
                case "down" :
                    currentRow++;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentRow =  0;
                    }
                    break;
                case "left" :
                    currentCol--;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentCol = n - 1;
                    }
                    break;
                case "right" :
                    currentCol++;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentCol = 0;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("B")){
                if (command.equals("up")){
                    currentRow--;
                } else if (command.equals("down")) {
                    currentRow++;
                } else if (command.equals("left")) {
                    currentCol--;
                } else if (command.equals("right")) {
                    currentCol++;
                }
            } else if (matrix[currentRow][currentCol].equals("T")) {
                if (command.equals("up")){
                    currentRow++;
                } else if (command.equals("down")) {
                    currentRow--;
                } else if (command.equals("left")) {
                    currentCol++;
                } else if (command.equals("right")) {
                    currentCol--;
                }
            } else if (matrix[currentRow][currentCol].equals("F")) {

                matrix[currentRow][currentCol] = "P";
                System.out.println("Well done, the player won first place!");
                printMatrix(n,matrix);
                return;
            }

            numberOfCommands--;
        }

        matrix[currentRow][currentCol] = "P";
        System.out.println("Oh no, the player got lost on the track!");
        printMatrix(n,matrix);
    }
    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int i = 0; i < n; i++) {

            String[] matrixRows = scanner.nextLine().split("");

            matrix[i] = matrixRows;
        }
    }
    private static boolean isOutOfBounds(String[][] matrix, int r, int c) {

        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
    private static void printMatrix(int size, String[][] matrix) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
