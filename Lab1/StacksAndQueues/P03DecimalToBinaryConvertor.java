package Lab1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinaryConvertor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (number == 0){

            System.out.print(0);
        }

        while (number != 0){


        stack.push(number % 2);
        number /= 2;

        }

        while (stack.size() >= 1){

            int currentNumber = stack.pop();

            System.out.print(currentNumber);
        }

    }
}
