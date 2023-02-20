package Lab1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        String[] tokens = input.split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();


        Collections.addAll(stack,tokens);

        while (stack.size() > 1){

            int number1 = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int number2 = Integer.parseInt(stack.pop());

            if (operator.equals("+")){

                int sum = number1 + number2;
                stack.push(String.valueOf(sum));

            }else if (operator.equals("-")){

                int sum = number1 - number2;
                stack.push(String.valueOf(sum));
        }

        }
        System.out.println(stack.peek());
    }
}
