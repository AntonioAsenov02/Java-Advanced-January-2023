package ExamPreparation11;

import java.util.Scanner;

public class P02PawnWars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];
        for (int i = 0; i < 8; i++) {

            String[] currentRow = scanner.nextLine().split("");
            matrix[i] = currentRow;
        }

        int currentRowWhite = -1;
        int currentColWhite = -1;
        int currentRowBlack = -1;
        int currentColBlack = -1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                if (matrix[row][col].equals("w")) {
                    currentRowWhite = row;
                    currentColWhite = col;
                } else if (matrix[row][col].equals("b")) {
                    currentRowBlack = row;
                    currentColBlack = col;
                }
            }
        }

        boolean isCaptured = false;
        while (currentRowWhite != 0 && currentRowBlack != 7 && !isCaptured) {

            if (whitePawHitBlack(currentRowWhite, currentColWhite, currentRowBlack, currentColBlack)) {

                String coordinates = findCoordinates(currentRowBlack, currentColBlack);
                System.out.printf("Game over! White capture on %s.", coordinates);
                isCaptured = true;
            }
            currentRowWhite--;

            if (blackPawHitWhite(currentRowBlack, currentColBlack, currentRowWhite, currentColWhite)) {

                String coordinates = findCoordinates(currentRowWhite, currentColWhite);
                System.out.printf("Game over! Black captures on %s.", coordinates);
                isCaptured = true;
            }
            currentRowBlack++;
        }
        if (!isCaptured) {
            if (currentRowWhite == 0) {

                System.out.printf("Game over! White pawn is promoted to a queen at %s.", findCoordinates(currentRowWhite, currentColWhite));
            } else {
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.", findCoordinates(currentRowBlack, currentColBlack));
            }
        }
    }

    private static String findCoordinates(int bRow, int bCol) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[bCol]).append(row[bRow]);
        return sb.toString();
    }

    private static boolean whitePawHitBlack(int wRow, int wCol, int bRow, int bCol) {
        if (wRow - 1 == bRow && (wCol + 1 == bCol || wCol - 1 == bCol)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean blackPawHitWhite(int bRow, int bCol, int wRow, int wCol) {
        if (bRow + 1 == wRow && (bCol + 1 == wCol || bCol - 1 == wCol)) {
            return true;
        } else {
            return false;
        }
    }
}
