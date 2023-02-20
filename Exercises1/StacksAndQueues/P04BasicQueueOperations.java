package Exercises1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int numbersToAdd = scanner.nextInt();
        int numbersToRemove = scanner.nextInt();
        int numberToCheck = scanner.nextInt();

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        for (int i = 1; i <= numbersToAdd ; i++) {

            numbersQueue.offer(scanner.nextInt());

        }

        for (int i = 1; i <= numbersToRemove ; i++) {

            numbersQueue.poll();
        }

        if (numbersQueue.contains(numberToCheck)){

            System.out.println("true");

        }else {

            if (numbersQueue.isEmpty()){

                System.out.println(0);

            }else {

                System.out.println(Collections.min(numbersQueue));
            }
        }
    }
}
