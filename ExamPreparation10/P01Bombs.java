package ExamPreparation10;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBomb = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> lastBomb = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        int DaturaBombs = 40;
        int CherryBombs = 60;
        int SmokeDecoyBombs = 120;

        int daturaCount = 0;
        int cherryCount = 0;
        int smokeCount = 0;

        while (!firstBomb.isEmpty() && !lastBomb.isEmpty())

            if (daturaCount >= 3 && cherryCount >= 3 && smokeCount >= 3) {
                break;
            } else if (firstBomb.getFirst() + lastBomb.peek() == DaturaBombs) {

                firstBomb.removeFirst();
                lastBomb.pop();
                daturaCount++;
            } else if (firstBomb.getFirst() + lastBomb.peek() == CherryBombs) {

                firstBomb.removeFirst();
                lastBomb.pop();
                cherryCount++;
            } else if (firstBomb.getFirst() + lastBomb.peek() == SmokeDecoyBombs) {

                firstBomb.removeFirst();
                lastBomb.pop();
                smokeCount++;
            } else {

                int currentValue = lastBomb.pop();
                lastBomb.push(currentValue - 5);
            }

        if (daturaCount >= 3 && cherryCount >= 3 && smokeCount >= 3) {

            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (firstBomb.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            String collect = firstBomb.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Bomb Effects: %s%n", collect);
        }

        if (lastBomb.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {

            Collections.reverse(lastBomb);
            String collect = lastBomb.stream().map(String::valueOf).collect(Collectors.joining(", "));

            System.out.printf("Bomb Casings: %s%n", collect);
        }

        System.out.printf("Cherry Bombs: %d%n",cherryCount);
        System.out.printf("Datura Bombs: %d%n",daturaCount);
        System.out.printf("Smoke Decoy Bombs: %d%n",smokeCount);
    }
}
