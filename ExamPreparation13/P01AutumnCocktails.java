package ExamPreparation13;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01AutumnCocktails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bucket = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshness = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int PearSour = 150;
        int TheHarvest = 250;
        int AppleHinny = 300;
        int HighFashion = 400;

        int pearCount = 0;
        int harvestCount = 0;
        int appleCount = 0;
        int fashionCount = 0;

        while (!bucket.isEmpty() && !freshness.isEmpty()) {
            if (bucket.getFirst() == 0) {
                bucket.removeFirst();
                continue;
            }
            if (bucket.getFirst() * freshness.getLast() == PearSour) {

                bucket.removeFirst();
                freshness.removeLast();
                pearCount++;
            } else if (bucket.getFirst() * freshness.getLast() == TheHarvest) {

                bucket.removeFirst();
                freshness.removeLast();
                harvestCount++;
            } else if (bucket.getFirst() * freshness.getLast() == AppleHinny) {

                bucket.removeFirst();
                freshness.removeLast();
                appleCount++;
            } else if (bucket.getFirst() * freshness.getLast() == HighFashion) {

                bucket.removeFirst();
                freshness.removeLast();
                fashionCount++;
            } else {
                freshness.removeLast();
                int currentBucket = bucket.removeFirst() + 5;
                bucket.addLast(currentBucket);
            }
        }

        if (pearCount >= 1 && harvestCount >= 1 && appleCount >= 1 && fashionCount >= 1){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!bucket.isEmpty()){
            int sum = 0;
            for (Integer ingredient : bucket) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n",sum);
        }
        if (appleCount >= 1){
            System.out.printf(" # Apple Hinny --> %d%n",appleCount);
        }
        if (fashionCount >= 1){
            System.out.printf(" # High Fashion --> %d%n",fashionCount);
        }
        if (pearCount >= 1){
            System.out.printf(" # Pear Sour --> %d%n",pearCount);
        }
        if (harvestCount >= 1){
            System.out.printf(" # The Harvest --> %d%n",harvestCount);
        }
    }
}
