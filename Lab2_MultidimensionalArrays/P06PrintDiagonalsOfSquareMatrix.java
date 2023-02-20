package Lab2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int length = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[length][length];

        for (int row = 0; row < length; row++) {

            int[] currentLine = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentLine;
        }

        String numbers = "";
        for (int i = 0; i < length; i++) {


            int currentNumber = matrix[i][i];

            numbers += currentNumber + " ";
        }

        String numbers2 = "";
        int currentLength = length;
        for (int i = 0; i < length; i++) {

            int currentNumber = matrix[currentLength -1][i];

            numbers2 += currentNumber + " ";
            currentLength--;
        }

        System.out.println(numbers);
        System.out.println(numbers2);

    }
}

