package ExamPreparation2;

import java.util.Scanner;

public class P02RallyRacing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String carNumber = scanner.nextLine();

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, n, scanner);

        int distance = 0;

        String command = scanner.nextLine();
        int currentRow = 0;
        int currentCol = 0;

        int firstTRow = -1;
        int firstTCol = -1;
        int secondTRow = -1;
        int secondTCol = -1;

        int count = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {


                if (matrix[row][col].equals("T") && count == 1){

                    firstTRow = row;
                    firstTCol = col;
                    count++;
                }else if (matrix[row][col].equals("T") && count == 2){

                    secondTRow = row;
                    secondTCol = col;
                    break;
                }
            }
        }
        while (!command.equals("End")){


            switch (command){

                case "up" :

                    matrix[currentRow][currentCol] = ".";
                    currentRow--;
                    break;
                case "down" :

                    matrix[currentRow][currentCol] = ".";
                    currentRow++;
                    break;
                case "left" :

                    matrix[currentRow][currentCol] = ".";
                    currentCol--;
                    break;
                case "right" :

                    matrix[currentRow][currentCol] = ".";
                    currentCol++;
                    break;
            }

            String currentPosition = matrix[currentRow][currentCol];
            if (currentPosition.equals("T")){

                matrix[currentRow][currentCol] = ".";
                distance += 30;
                if (currentRow == firstTRow && currentCol == firstTCol){

                    currentRow = secondTRow;
                    currentCol = secondTCol;
                }else {

                    currentRow = firstTRow;
                    currentCol = firstTCol;
                }

            } else if (currentPosition.equals("F")) {

                distance += 10;
                System.out.printf("Racing car %s finished the stage!%n",carNumber);
                System.out.printf("Distance covered %d km.%n",distance);
                matrix[currentRow][currentCol] = "C";
                printMatrix(n,matrix);
                return;

            } else if (currentPosition.equals(".")) {

                distance += 10;
            }

            command = scanner.nextLine();
        }

        matrix[currentRow][currentCol] = "C";
        System.out.printf("Racing car %s DNF.%n",carNumber);
        System.out.printf("Distance covered %d km.%n",distance);
        printMatrix(n,matrix);
    }

    private static void fillMatrix(String[][] matrix, int rows, Scanner scanner) {

        for (int row = 0; row < rows; row++) {

            String[] currentLine = scanner.nextLine().split(" ");

            matrix[row] = currentLine;
        }

    }

    private static void printMatrix(int size, String[][] matrix) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}


