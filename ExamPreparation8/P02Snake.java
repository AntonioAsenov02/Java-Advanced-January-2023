package ExamPreparation8;

import java.util.Scanner;

public class P02Snake {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String [][] matrix = new String[n][n];

        fillMatrix(scanner,n,matrix);

        int currentRow = -1;
        int currentCol = -1;
        int burrowRow1 = -1;
        int burrowCol1 = -1;
        int burrowRow2 = -1;
        int burrowCol2 = -1;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (matrix[row][col].equals("S")) {

                    currentRow = row;
                    currentCol = col;
                    break;
                } else if (matrix[row][col].equals("B") && count > 0) {

                    burrowRow2 = row;
                    burrowCol2 = col;
                } else if (matrix[row][col].equals("B")) {

                    burrowRow1 = row;
                    burrowCol1 = col;
                    count++;
                }
            }
        }

        String command = scanner.nextLine();
        int foodCount = 0;
        while (foodCount < 10) {
            switch (command) {

                case "up":

                    matrix[currentRow][currentCol] = ".";
                    currentRow--;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n",foodCount);
                        printMatrix(n,matrix);
                        return;
                    }
                    break;
                case "down":

                    matrix[currentRow][currentCol] = ".";
                    currentRow++;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n",foodCount);
                        printMatrix(n,matrix);
                        return;
                    }
                    break;
                case "left":

                    matrix[currentRow][currentCol] = ".";
                    currentCol--;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n",foodCount);
                        printMatrix(n,matrix);
                        return;
                    }
                    break;
                case "right":

                    matrix[currentRow][currentCol] = ".";
                    currentCol++;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n",foodCount);
                        printMatrix(n,matrix);
                        return;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("*")) {

                foodCount++;
            } else if (matrix[currentRow][currentCol].equals("B")) {

                matrix[currentRow][currentCol] = ".";
                if (currentRow == burrowRow1 && currentCol == burrowCol1){
                    currentRow = burrowRow2;
                    currentCol = burrowCol2;
                }else {
                    currentRow = burrowRow1;
                    currentCol = burrowCol1;
                }
            }
            if (foodCount < 10){
                command = scanner.nextLine();
            }
        }

        matrix[currentRow][currentCol] = "S";
        System.out.println("You won! You fed the snake.");
        System.out.printf("Food eaten: %d%n",foodCount);
        printMatrix(n,matrix);
    }
    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int i = 0; i < n; i++) {

            String[] matrixRows = scanner.nextLine().split("");

            matrix[i] = matrixRows;
        }
    }
    private static boolean isInBounds(String[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
    private static void printMatrix(int size, String[][] matrix) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
