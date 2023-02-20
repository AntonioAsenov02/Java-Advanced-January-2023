package Lab1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpdate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String currentUrl = scanner.nextLine();

        while (!currentUrl.equals("Home")) {

            if (currentUrl.equals("back")) {

                if (backHistory.size() < 2) {

                    System.out.println("no previous URLs");

                } else {
                    forwardHistory.addFirst(backHistory.peek());
                    backHistory.pop();
                    System.out.println(backHistory.peek());
                }
            } else if (currentUrl.equals("forward")) {

                if (forwardHistory.size() < 1){

                    System.out.println("no next URLs");

                }else {

                    System.out.println(forwardHistory.peek());

                    backHistory.push(forwardHistory.pop());

                }

            } else {

                System.out.println(currentUrl);
                backHistory.push(currentUrl);
                forwardHistory.clear();
            }

            currentUrl = scanner.nextLine();
        }
    }
}