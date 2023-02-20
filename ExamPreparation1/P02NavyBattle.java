package ExamPreparation1;

import java.util.Scanner;

public class P02NavyBattle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String [][] matrix = new String[size][size];

        fillMatrix(matrix,size,scanner);

        int submarinerRow = -1;
        int submarinerCol = -1;
        int countHits = 0;
        int countCruisersSunk = 0;
        int finalRow = -1;
        int finalCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (matrix[row][col].equals("S")){
                    submarinerRow = row;
                    submarinerCol = col;
                    break;
                }
            }
        }


        String input = scanner.nextLine();
        while (true){

            matrix[submarinerRow][submarinerCol] = "-";
            if (input.equals("up")){
                submarinerRow--;
            }else if (input.equals("down")){
                submarinerRow++;
            } else if (input.equals("left")) {
                submarinerCol--;
            }else if (input.equals("right")){
                submarinerCol++;
            }

            String submarinePosition = matrix[submarinerRow][submarinerCol];

            if (submarinePosition.equals("-")){

                matrix[submarinerRow][submarinerCol] = "S";
            }else if (submarinePosition.equals("*")){

                matrix[submarinerRow][submarinerCol] = "S";

                countHits++;
                if (countHits == 3){

                    finalRow = submarinerRow;
                    finalCol =submarinerCol;

                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",submarinerRow,submarinerCol);
                    break;
                }
            } else if (submarinePosition.equals("C")) {

                matrix[submarinerRow][submarinerCol] = "S";
                countCruisersSunk++;

                if (countCruisersSunk == 3){

                    finalRow = submarinerRow;
                    finalCol = submarinerCol;

                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
            input = scanner.nextLine();
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (matrix[row][col].equals(matrix[finalRow][finalCol])){

                    matrix[row][col] = "S";
                }
            }
        }

        printMatrix(size, matrix);

    }

    private static void printMatrix(int size, String[][] matrix) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix,int rows,Scanner scanner) {

        for (int row = 0; row < rows; row++) {

            String[] currentLine = scanner.nextLine().split("");

            matrix[row] = currentLine;
        }
    }
}
