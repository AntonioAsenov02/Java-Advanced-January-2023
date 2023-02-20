package ExamPreparation8;

import java.util.*;
import java.util.stream.Collectors;

public class P01PastryShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        int Biscuit = 25;
        int Cake = 50;
        int Pastry = 75;
        int Pie = 100;

        int biscuitsCount = 0;
        int cakesCount = 0;
        int pastriesCount = 0;
        int piesCount = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            if (liquids.getFirst() + ingredients.peek() == Biscuit) {

                liquids.removeFirst();
                ingredients.pop();
                biscuitsCount++;
            } else if (liquids.getFirst() + ingredients.peek() == Cake) {

                liquids.removeFirst();
                ingredients.pop();
                cakesCount++;
            } else if (liquids.getFirst() + ingredients.peek() == Pastry) {

                liquids.removeFirst();
                ingredients.pop();
                pastriesCount++;
            } else if (liquids.getFirst() + ingredients.peek() == Pie) {

                liquids.removeFirst();
                ingredients.pop();
                piesCount++;
            } else {

                liquids.removeFirst();
                int currentIngredient = ingredients.peek();
                ingredients.pop();
                ingredients.push(currentIngredient + 3);
            }
        }

        if (biscuitsCount > 0 && cakesCount > 0 && pastriesCount > 0 && piesCount > 0){

            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else {

            String collect = liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Liquids left: %s%n",collect);
        }

        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {

            Collections.reverse(ingredients);
            String collect = ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Ingredients left: %s%n",collect);
        }

        System.out.printf("Biscuit: %d%n",biscuitsCount);
        System.out.printf("Cake: %d%n",cakesCount);
        System.out.printf("Pie: %d%n",piesCount);
        System.out.printf("Pastry: %d%n",pastriesCount);
    }
}
