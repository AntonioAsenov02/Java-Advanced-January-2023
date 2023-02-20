package ExamPreparation4;

import java.util.Scanner;

public class P02StickyFingers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String[] movingPositions = scanner.nextLine().split(",");

        String[][] matrix = new String[n][n];

        fillMatrix(scanner, n, matrix);

        int currentRow = -1;
        int currentCol = -1;
        int stolenMoney = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (matrix[row][col].equals("D")) {

                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }

        boolean isCaught = false;
        for (int i = 0; i < movingPositions.length; i++) {

            matrix[currentRow][currentCol] = "+";
            if (movingPositions[i].equals("up")) {

                if (isInBounds(matrix, currentRow - 1, currentCol)) {

                    currentRow--;
                } else {

                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;
                }

            } else if (movingPositions[i].equals("down")) {

                if (isInBounds(matrix, currentRow + 1, currentCol)) {

                    currentRow++;
                } else {

                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;
                }
            } else if (movingPositions[i].equals("left")) {

                if (isInBounds(matrix, currentRow, currentCol - 1)) {

                    currentCol--;
                } else {

                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;
                }
            } else if (movingPositions[i].equals("right")) {

                if (isInBounds(matrix, currentRow, currentCol + 1)) {

                    currentCol++;
                } else {

                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;
                }
            }

            String currentPosition = matrix[currentRow][currentCol];


            if (currentPosition.equals("+")) {

                matrix[currentRow][currentCol] = "D";
            } else if (currentPosition.equals("$")) {

                matrix[currentRow][currentCol] = "D";
                stolenMoney += currentRow * currentCol;

                System.out.printf("You successfully stole %d$.%n", currentRow * currentCol);
            } else if (currentPosition.equals("P")) {

                matrix[currentRow][currentCol] = "#";
                isCaught = true;
                break;
            }
        }
        if (!isCaught){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
            printMatrix(n, matrix);
        }else {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
            printMatrix(n, matrix);
        }

    }


    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int i = 0; i < n; i++) {

            String[] matrixRows = scanner.nextLine().split("\\s+");

            matrix[i] = matrixRows;
        }
    }

    private static boolean isInBounds(String[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void printMatrix(int size, String[][] matrix) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}