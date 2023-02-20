package Exercises1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String [] input = scanner.nextLine().split(" ");

        ArrayDeque<String> numberStack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {

            String currentNumber = input[i];
            numberStack.push(currentNumber);
        }

        while (numberStack.size() >= 1){

            System.out.print(numberStack.pop() + " ");
        }
    }
}
