package ExamPreparation7;

import java.util.*;
import java.util.stream.Collectors;

public class P01LootBox {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            if ((firstBox.getFirst() + secondBox.getLast()) % 2 == 0) {

                claimedItems.add(firstBox.getFirst() + secondBox.getLast());
                firstBox.removeFirst();
                secondBox.removeLast();

            } else {

                int currentItem = secondBox.getLast();
                secondBox.removeLast();
                firstBox.addLast(currentItem);
            }
        }

        if (firstBox.isEmpty()){

            System.out.println("First lootbox is empty");
        } else {

            System.out.println("Second lootbox is empty");
        }

        int sum = 0;
        for (Integer item : claimedItems) {
            sum += item;
        }

        if (sum >= 100){
            System.out.printf("Your loot was epic! Value: %d%n",sum);
        }else {
            System.out.printf("Your loot was poor... Value: %d%n",sum);
        }
    }
}
