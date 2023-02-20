package Lab2_MultidimensionalArrays;

import java.util.Scanner;

public class P02PositionsOf {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String [] inputArr = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(inputArr[0]);
        int cols = Integer.parseInt(inputArr[1]);
        int [][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {

            String [] numbersArr = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {

                matrix [row][col] = Integer.parseInt(numbersArr[col]);
            }
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int currentNumber = matrix[row][col];

                if (currentNumber == numberToFind){

                    counter++;
                    System.out.println(row + " " + col);
                }


                }
            }
        if (counter == 0){

            System.out.println("not found");
        }

    }
}
