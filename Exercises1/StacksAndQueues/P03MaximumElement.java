package Exercises1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= numberOfCommands; i++) {

            String command = scanner.nextLine();

            if (command.equals("2")){

                stack.pop();

            }else if (command.equals("3")){

                if (stack.size() > 0){

                    System.out.println(Collections.max(stack));
                }

            }else {

                int currentNumber = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(currentNumber);

            }
        }
    }
}
