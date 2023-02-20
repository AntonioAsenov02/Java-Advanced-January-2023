package Exercises1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String [] inputArr = scanner.nextLine().split(" ");

        int numbersToAdd = Integer.parseInt(inputArr[0]);
        int numbersToPop = Integer.parseInt(inputArr[1]);
        String numberToBeChecked = inputArr[2];

        String [] numbersArr = scanner.nextLine().split("\\s+");

        ArrayDeque<String> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < numbersToAdd ; i++) {

            String currentNumber = numbersArr[i];
            numbersStack.push(currentNumber);
        }

        for (int i = 1; i <= numbersToPop ; i++) {

            numbersStack.pop();
        }

        if (numbersStack.contains(numberToBeChecked)){

            System.out.println("true");

        }else {

            if (numbersStack.isEmpty()){

                System.out.println(0);

            }else {

                System.out.println(Collections.min(numbersStack));
            }
        }

    }
}
