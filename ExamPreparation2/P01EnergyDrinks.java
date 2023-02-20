package ExamPreparation2;

import java.util.*;
import java.util.stream.Collectors;

public class P01EnergyDrinks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> milligramsOfCaffeine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> energyDrinks = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int currentCaffeine = 0;
        int maxCaffeine = 300;

        while (!milligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()){

            if (milligramsOfCaffeine.getLast() * energyDrinks.getFirst() + currentCaffeine > maxCaffeine){

                milligramsOfCaffeine.removeLast();
                int moveDrink = energyDrinks.removeFirst();
                energyDrinks.offer(moveDrink);
                if (currentCaffeine - 30 >= 0){

                    currentCaffeine -= 30;
                }
            }else {

                currentCaffeine += milligramsOfCaffeine.getLast() * energyDrinks.getFirst();
                milligramsOfCaffeine.removeLast();
                energyDrinks.removeFirst();

            }
        }

        if (!energyDrinks.isEmpty()){

            System.out.printf("Drinks left: %s%n",String.join(", ", Arrays.asList(energyDrinks.toString().
                    substring(1, energyDrinks.toString().length() - 1))));
        }else {

            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.",currentCaffeine);

    }
}
