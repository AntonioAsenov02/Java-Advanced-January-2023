package ExamPreparation5;

import java.util.Scanner;

public class P02Armory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        fillMatrix(matrix, n, scanner);

        int currentRow = -1;
        int currentCol = -1;
        int mirrorRow1 = -1;
        int mirrorCol1 = -1;
        int mirrorRow2 = -1;
        int mirrorCol2 = -1;
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (matrix[row][col] == 'A') {
                    currentRow = row;
                    currentCol = col;
                }
                if (matrix[row][col] == 'M' && count == 1) {
                    mirrorRow2 = row;
                    mirrorCol2 = col;
                }

                if (matrix[row][col] == 'M' && count < 1) {
                    count++;
                    mirrorRow1 = row;
                    mirrorCol1 = col;
                }


            }
        }


        int swordsBought = 0;
        String command = scanner.nextLine();
        while (swordsBought <= 65) {

            switch (command) {

                case "up":

                    matrix[currentRow][currentCol] = '-';
                    currentRow--;
                    if (isOutOfArmoryRow(currentRow, n)) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", swordsBought);

                        return;
                    }
                    break;
                case "down":

                    matrix[currentRow][currentCol] = '-';
                    currentRow++;
                    if (isOutOfArmoryRow(currentRow, n)) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", swordsBought);
                        printMatrix(n, matrix);
                        return;
                    }
                    break;
                case "left":

                    matrix[currentRow][currentCol] = '-';
                    currentCol--;
                    if (isOutOfArmoryCol(currentCol, n)) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", swordsBought);
                        printMatrix(n, matrix);
                        return;
                    }
                    break;
                case "right":

                    matrix[currentRow][currentCol] = '-';
                    currentCol++;
                    if (isOutOfArmoryCol(currentCol, n)) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", swordsBought);
                        printMatrix(n, matrix);
                        return;
                    }
                    break;
            }

            if (Character.isDigit((matrix[currentRow][currentCol]))) {

                int digit = Integer.parseInt(String.valueOf(matrix[currentRow][currentCol]));
                swordsBought += digit;
            } else if (matrix[currentRow][currentCol] == 'M') {

                matrix[currentRow][currentCol] = '-';
                if (currentRow == mirrorRow1 && currentCol == mirrorCol1) {
                    currentRow = mirrorRow2;
                    currentCol = mirrorCol2;
                }
            }
            if (swordsBought >= 65){
                matrix[currentRow][currentCol] = 'A';
                break;
            }else {
                command = scanner.nextLine();
            }
        }

        System.out.println("Very nice swords, I will come back for more!");
        System.out.printf("The king paid %d gold coins.%n", swordsBought);
        printMatrix(n, matrix);
    }
    private static boolean isOutOfArmoryRow(int currentRow, int size) {

        return currentRow < 0 || currentRow > size - 1;
    }
    private static boolean isOutOfArmoryCol(int currentCol, int size) {
        return currentCol < 0 || currentCol > size - 1;
    }
    private static void fillMatrix(char[][] matrix, int size, Scanner scanner) {
        for (int row = 0; row < size; row++) {
            String currLine = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                char currChar = currLine.charAt(col);
                matrix[row][col] = currChar;
            }
        }
    }
    private static void printMatrix(int size, char[][] matrix) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}