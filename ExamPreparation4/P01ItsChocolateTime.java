package ExamPreparation4;

import java.util.*;
import java.util.stream.Collectors;

public class P01ItsChocolateTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Double> milk = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacao = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));


        Map<String, Integer> allChocolates = new TreeMap<>();

        int milkChocolate = 30;
        int darkChocolate = 50;
        int bakingChocolate = 100;

        int countMilkChocolate = 0;
        int countDarkChocolate = 0;
        int countBakingChocolate = 0;

        while (!milk.isEmpty() && !cacao.isEmpty()) {

            double currentMilkValue = milk.getFirst();
            double currentCacaoValue = cacao.getLast();
            double cacaoPercentages = currentCacaoValue / (currentMilkValue + currentCacaoValue) * 100;

            if (cacaoPercentages == milkChocolate) {

                milk.removeFirst();
                cacao.removeLast();
                countMilkChocolate++;
            } else if (cacaoPercentages == darkChocolate) {

                milk.removeFirst();
                cacao.removeLast();
                countDarkChocolate++;
            } else if (cacaoPercentages == bakingChocolate) {

                milk.removeFirst();
                cacao.removeLast();
                countBakingChocolate++;
            } else {

                cacao.removeLast();
                double currentMilk = milk.getFirst();
                milk.removeFirst();
                milk.addLast(currentMilk + 10);
            }
        }

        allChocolates.put("Baking Chocolate", countBakingChocolate);
        allChocolates.put("Milk Chocolate", countMilkChocolate);
        allChocolates.put("Dark Chocolate", countDarkChocolate);

        if (countMilkChocolate > 0 && countDarkChocolate > 0 && countBakingChocolate > 0) {

            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            for (Map.Entry<String, Integer> entry : allChocolates.entrySet()) {

                if (entry.getValue() > 0) {
                    System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
                }
            }


        } else {

            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            for (Map.Entry<String, Integer> entry : allChocolates.entrySet()) {

                if (entry.getValue() > 0) {
                    System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
                }
            }

        }
    }
}
