package Lab1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String [] childrenArr = scanner.nextLine().split(" ");
        int tossNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (int i = 0; i < childrenArr.length ; i++) {

            String currentChild = childrenArr[i];
            childrenQueue.offer(currentChild);
        }

        while (childrenQueue.size() != 1){

            for (int i = 1; i < tossNumber ; i++) {

                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }

            String childToRemove = childrenQueue.poll();
            System.out.println("Removed " + childToRemove);
        }

        String lastChildren = childrenQueue.peek();
        System.out.println("Last is " + lastChildren);
    }
}
