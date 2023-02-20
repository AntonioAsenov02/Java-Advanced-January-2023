package ExamPreparation3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = dimensions[0];
        int m = dimensions[1];

        String[][] matrix = new String[n][m];

        fillMatrix(matrix, n, scanner);

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                if (matrix[row][col].equals("Y")) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }
        List<String> pathToTreasure = new ArrayList<>();

        int previousRow = -1;
        int previousCol = -1;

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {

            switch (command) {

                case "up":
                    previousRow = currentRow;
                    previousCol = currentCol;
                    currentRow--;

                    break;
                case "down":

                    previousRow = currentRow;
                    previousCol = currentCol;
                    currentRow++;

                    break;
                case "right":

                    previousRow = currentRow;
                    previousCol = currentCol;
                    currentCol++;

                    break;
                case "left":

                    previousRow = currentRow;
                    previousCol = currentCol;
                    currentCol--;

                    break;
            }
            pathToTreasure.add(command);

            if (isOutOfBounds(matrix, currentRow, currentCol)) {
                currentRow = previousRow;
                currentCol = previousCol;
                pathToTreasure.remove(pathToTreasure.size() - 1);
            }

            if (matrix[currentRow][currentCol].equals("T")) {

                currentRow = previousRow;
                currentCol = previousCol;
                pathToTreasure.remove(pathToTreasure.size() - 1);
            }

            command = scanner.nextLine();
        }

        if (matrix[currentRow][currentCol].equals("X")) {

            StringBuilder builder = new StringBuilder();
            System.out.println("I've found the treasure!");
            for (int i = 0; i < pathToTreasure.size(); i++) {

                if (i < pathToTreasure.size() - 1) {
                    builder.append(pathToTreasure.get(i)).append(", ");
                } else {
                    builder.append(pathToTreasure.get(i));
                }
            }
            System.out.printf("The right path is %s%n", builder);

        } else {
            System.out.println("The map is fake!");
        }
    }
    private static boolean isOutOfBounds(String[][] matrix, int r, int c) {

        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
    private static void fillMatrix(String[][] matrix, int rows, Scanner scanner) {

        for (int row = 0; row < rows; row++) {

            String[] currentLine = scanner.nextLine().split(" ");

            matrix[row] = currentLine;
        }
    }
}