package RealExam;

import java.util.Arrays;
import java.util.Scanner;

public class P01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int n = dimensions[0];
        int m = dimensions[1];

        String [][] matrix = new String[n][m];
        fillMatrix(scanner,n,matrix);

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                if (matrix[row][col].equals("B")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        int peopleTouched = 0;
        int movesMade = 0;
        String command = scanner.nextLine();
        while (!command.equals("Finish") && peopleTouched < 3){

            int previousRow = currentRow;
            int previousCol = currentCol;

            switch (command){

                case "up" :
                    currentRow--;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentRow++;
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "down" :
                    currentRow++;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentRow--;
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "left" :
                    currentCol--;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentCol++;
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "right" :
                    currentCol++;
                    if (isOutOfBounds(matrix,currentRow,currentCol)){
                        currentCol--;
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
            }

            switch (matrix[currentRow][currentCol]) {
                case "O":
                    currentRow = previousRow;
                    currentCol = previousCol;
                    break;
                case "P":
                    matrix[previousRow][previousCol] = "-";
                    matrix[currentRow][currentCol] = "-";
                    peopleTouched++;
                    movesMade++;
                    break;
                case "-":
                    matrix[previousRow][previousCol] = "-";
                    movesMade++;
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n",peopleTouched,movesMade);
    }
    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int i = 0; i < n; i++) {

            String[] matrixRows = scanner.nextLine().split(" ");

            matrix[i] = matrixRows;
        }
    }
    private static boolean isOutOfBounds(String[][] matrix, int r, int c) {

        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}
