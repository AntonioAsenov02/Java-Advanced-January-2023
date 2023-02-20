package ExamPreparation9;

import java.util.Scanner;

public class P02MouseAndCheese {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String [][] matrix = new String[n][n];

        fillMatrix(scanner,n,matrix);

        int currentRow = -1;
        int currentCol = -1;
        int cheeseEaten = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (matrix[row][col].equals("M")) {

                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }

        String currentDirection = "";
        String command = scanner.nextLine();
        while (!command.equals("end")){

            matrix[currentRow][currentCol] = "-";
            switch (command){

                case "up" :
                    currentDirection = "up";
                    currentRow--;
                    break;
                case "down" :
                    currentDirection = "down";
                    currentRow++;
                    break;
                case "left" :
                    currentDirection = "left";
                    currentCol--;
                    break;
                case "right" :
                    currentDirection = "right";
                    currentCol++;
                    break;
            }

            if (!isInBounds(matrix,currentRow,currentCol)){
                System.out.println("Where is the mouse?");
                break;
            }

            if (matrix[currentRow][currentCol].equals("c")){

                cheeseEaten++;
            } else if (matrix[currentRow][currentCol].equals("B")) {

               continue;
            }
            matrix[currentRow][currentCol] = "M";

            command = scanner.nextLine();
        }

        if (cheeseEaten >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheeseEaten);
        }else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5 - cheeseEaten);
        }
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
