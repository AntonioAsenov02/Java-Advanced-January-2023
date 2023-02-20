package ExamPreparation12;

import java.util.Scanner;

public class P02ThroneConquering {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][];

        fillMatrix(scanner,n,matrix);

        int parisRow = -1;
        int parisCol = -1;
        int helenRow = -1;
        int helenCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col].equals("P")){
                    parisRow = row;
                    parisCol = col;
                } else if (matrix[row][col].equals("H")) {
                    helenRow = row;
                    helenCol = col;
                }
            }
        }

        while (energy > 0 && !matrix[parisRow][parisCol].equals(matrix[helenRow][helenCol])){

            String[] commandArr = scanner.nextLine().split("\\s+");
            String command = commandArr[0];
            int commandRow = Integer.parseInt(commandArr[1]);
            int commandCol = Integer.parseInt(commandArr[2]);

            matrix[commandRow][commandCol] = "S";
            matrix[parisRow][parisCol] = "-";

            switch (command){
                case "up" :
                    parisRow--;
                    if (isOutOfBounds(matrix, parisRow, parisCol)){
                        parisRow++;
                    }
                    break;
                case "down" :
                    parisRow++;
                    if (isOutOfBounds(matrix, parisRow, parisCol)){
                        parisRow--;
                    }
                    break;
                case "left" :
                    parisCol--;
                    if (isOutOfBounds(matrix, parisRow, parisCol)){
                        parisCol++;
                    }
                    break;
                case "right" :
                    parisCol++;
                    if (isOutOfBounds(matrix, parisRow, parisCol)){
                        parisCol--;
                    }
                    break;
            }
            energy--;

            if (matrix[parisRow][parisCol].equals("S")){
                energy -= 2;
            }
        }

        if (parisRow == helenRow && parisCol == helenCol){
            matrix[parisRow][parisCol] = "-";
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",energy);
        }else {
            matrix[parisRow][parisCol] = "X";
            System.out.printf("Paris died at %d;%d.%n",parisRow,parisCol);
        }
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
