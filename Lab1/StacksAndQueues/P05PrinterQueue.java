package Lab1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        ArrayDeque<String> filesQueue = new ArrayDeque<>();

        while (!input.equals("print")){

            if (!input.equals("cancel")){

                filesQueue.offer(input);
            }else {

                if (filesQueue.isEmpty()){

                    System.out.println("Printer is on standby");

                }else {

                    String firstInput = filesQueue.poll();

                    System.out.println("Canceled " + firstInput);
                }
            }

            input = scanner.nextLine();
        }

        for (String file : filesQueue) {

            System.out.println(file);
        }
    }
}
