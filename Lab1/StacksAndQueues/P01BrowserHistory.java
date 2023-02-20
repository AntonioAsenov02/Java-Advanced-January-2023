package Lab1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> historyStack = new ArrayDeque<>();

        String currentUrl = scanner.nextLine();

        while (!currentUrl.equals("Home")){

            if (currentUrl.equals("back")){

                if (historyStack.isEmpty() || historyStack.size() == 1){

                    System.out.println("no previous URLs");
                }else {

                    historyStack.pop();
                    System.out.println(historyStack.peek());
                }
            }else {

                historyStack.push(currentUrl);
                System.out.println(historyStack.peek());
            }

            currentUrl = scanner.nextLine();
        }
    }
}
