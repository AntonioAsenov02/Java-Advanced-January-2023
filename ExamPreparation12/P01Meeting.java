package ExamPreparation12;

import java.util.*;
import java.util.stream.Collectors;

public class P01Meeting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> males = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        Queue<Integer> females = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int countMatched = 0;
        while (!females.isEmpty() && !males.isEmpty()) {

            if (females.peek() <= 0) {
                females.poll();
            } else if (males.peek() <= 0) {
                males.pop();
            } else if (females.peek() % 25 == 0) {
                females.poll();
                females.poll();
            } else if (males.peek() % 25 == 0) {
                males.pop();
                males.pop();
            } else {

                if (females.peek() == (males.peek())) {

                    countMatched++;
                    females.poll();
                    males.pop();
                } else {
                    females.poll();
                    int currentMale = males.pop();
                    males.add(currentMale - 2);
                }
            }
        }

        System.out.printf("Matches: %d%n",countMatched);

        if (males.isEmpty()){
            System.out.println("Males left: none");
        }else {
            Collections.reverse(males);
            String collect = males.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Males left: %s%n",collect);
        }
        if (females.isEmpty()){
            System.out.println("Females left: none");
        }else {
            String collect = females.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Females left: %s%n",collect);
        }
    }
}
