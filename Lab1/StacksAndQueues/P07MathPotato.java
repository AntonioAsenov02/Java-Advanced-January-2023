package Lab1.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String [] childrenArr = scanner.nextLine().split(" ");
        int tossNumber = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> childrenQueue = new PriorityQueue<>();

        for (int i = 0; i < childrenArr.length ; i++) {

            String currentChild = childrenArr[i];
            childrenQueue.offer(currentChild);
        }

        int currentSteps = 1;
        while (childrenQueue.size() != 1){

            for (int i = 1; i < tossNumber ; i++) {

                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }

            if (isPrime(currentSteps)){

                System.out.println("Prime " + childrenQueue.peek());
            }else {
                String childToRemove = childrenQueue.poll();
                System.out.println("Removed " + childToRemove);
            }

            currentSteps++;
        }

        String lastChildren = childrenQueue.peek();
        System.out.println("Last is " + lastChildren);
    }

    private static boolean isPrime(int currentSteps) {

        if (currentSteps == 1){
            return false;
        }

        for (int i = 2; i < currentSteps; i++) {

            if (currentSteps % i == 0){
                return false;
            }
        }
        return true;
    }
}
