package Lab2_MultidimensionalArrays;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String [][] firstMatrix = new String[rows][cols];
        String [][] secondMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {

            String [] symbols = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {

                firstMatrix[row][col] = symbols[col];
            }
        }

        for (int row = 0; row < rows; row++) {

            String [] symbols = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {

                secondMatrix[row][col] = symbols[col];
            }
        }

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (firstMatrix[row][col].equals(secondMatrix[row][col])){

                    System.out.print(firstMatrix[row][col] + " ");
                }else {

                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }

    }
}
