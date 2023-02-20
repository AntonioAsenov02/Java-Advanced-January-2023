package ExamPreparation7;

import java.util.Scanner;

public class P02Bee {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(scanner, n, matrix);

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (matrix[row][col].equals("B")) {

                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }

        int pollinatedFlowers = 0;
        String command = scanner.nextLine();
        String currentDirection = null;
        while (!command.equals("End")) {

            matrix[currentRow][currentCol] = ".";
            switch (command) {

                case "up":

                    currentDirection = "up";
                    currentRow--;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("The bee got lost!");
                        printFlowers(pollinatedFlowers);
                        printMatrix(n, matrix);
                        return;
                    }
                    break;
                case "down":

                    currentDirection = "down";
                    currentRow++;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("The bee got lost!");
                        printFlowers(pollinatedFlowers);
                        printMatrix(n, matrix);
                        return;
                    }
                    break;
                case "left":

                    currentDirection = "left";
                    currentCol--;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("The bee got lost!");
                        printFlowers(pollinatedFlowers);
                        printMatrix(n, matrix);
                        return;
                    }
                    break;
                case "right":

                    currentDirection = "right";
                    currentCol++;
                    if (!isInBounds(matrix, currentRow, currentCol)) {

                        System.out.println("The bee got lost!");
                        printFlowers(pollinatedFlowers);
                        printMatrix(n, matrix);
                        return;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("f")) {

                pollinatedFlowers++;
            } else if (matrix[currentRow][currentCol].equals("O")) {

                matrix[currentRow][currentCol] = ".";
                if (currentDirection.equals("up")) {
                    currentRow--;
                    if (matrix[currentRow][currentCol].equals("f")) {
                        pollinatedFlowers++;
                    }
                } else if (currentDirection.equals("down")) {
                    currentRow++;
                    if (matrix[currentRow][currentCol].equals("f")) {
                        pollinatedFlowers++;
                    }
                } else if (currentDirection.equals("left")) {
                    currentCol--;
                    if (matrix[currentRow][currentCol].equals("f")) {
                        pollinatedFlowers++;
                    }
                } else if (currentDirection.equals("right")) {
                    currentCol++;
                    if (matrix[currentRow][currentCol].equals("f")) {
                        pollinatedFlowers++;
                    }
                }
            }

            command = scanner.nextLine();
        }

        matrix[currentRow][currentCol] = "B";
        printFlowers(pollinatedFlowers);
        printMatrix(n, matrix);
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
    private static void printFlowers(int pollinatedFlowers) {

        if (pollinatedFlowers >= 5) {

            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
    }
}