package Exercises1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= numberOfOperations ; i++) {

            String input = scanner.nextLine();

            if (input.split(" ")[0].equals("1")){

                stack.push(text.toString());
                String currentText = input.split(" ")[1];

                text.append(currentText);

            }else if (input.split(" ")[0].equals("2")){

                stack.push(text.toString());
                int numberOfElements = Integer.parseInt(input.split(" ")[1]);

                text.delete(text.length() - numberOfElements, text.length());

            }else if (input.split(" ")[0].equals("3")){

                int position = Integer.parseInt(input.split(" ")[1]);

                System.out.println(text.charAt(position - 1));

            } else if (input.split(" ")[0].equals("4")) {

                if (!stack.isEmpty()){

                   String last = stack.pop();
                   text = new StringBuilder(last);
                }


            }
        }
    }
}
