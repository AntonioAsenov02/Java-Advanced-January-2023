package ExamPreparation6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OSPlanning {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> tasks = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (!tasks.getLast().equals(taskToKill)){

            if (threads.getFirst() >= tasks.getLast()){
                threads.removeFirst();
                tasks.removeLast();
            }else {
                threads.removeFirst();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n",threads.getFirst(),taskToKill);

        for (Integer thread : threads) {

            System.out.print(thread + " ");
        }

    }
}
