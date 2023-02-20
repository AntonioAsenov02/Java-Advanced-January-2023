package Exercises3SetsAmdMaps;

import java.util.*;

public class P07HandsOfCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String, Set<String>> map = new LinkedHashMap<>();


        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {

            String[] tokens = input.split(":");
            String name = tokens[0];
            String cards = tokens[1];

            String[] cardsArr = cards.split(", ");

            Set<String> cardsSet = new HashSet<>();
            cardsSet.addAll(Arrays.asList(cardsArr));


            if (!map.containsKey(name)) {

                map.put(name, cardsSet);
            } else {

                Set<String> currentCards = map.get(name);
                currentCards.addAll(cardsSet);
                map.put(name, currentCards);
            }

            input = scanner.nextLine();
        }

        map.forEach((name, cards) -> {
            int points = getCardPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });
    }

    private static int getCardPoints(Set<String> cards) {

        Map<Character,Integer> symbolsValues = getSymbolsValues();

        int sumPoints = 0;

        for (String card : cards) {


            int points = 0;
            if (card.startsWith("10")){

                char type = card.charAt(2);
                points = 10 * symbolsValues.get(type);

            }else {

                char power = card.charAt(0);
                char type = card.charAt(1);
                points = symbolsValues.get(power) * symbolsValues.get(type);
            }

            sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {

        Map<Character,Integer> characterValues = new HashMap<>();
        characterValues.put('2',2);
        characterValues.put('3',3);
        characterValues.put('4',4);
        characterValues.put('5',5);
        characterValues.put('6',6);
        characterValues.put('7',7);
        characterValues.put('8',8);
        characterValues.put('9',9);
        characterValues.put('J',11);
        characterValues.put('Q',12);
        characterValues.put('K',13);
        characterValues.put('A',14);
        characterValues.put('S',4);
        characterValues.put('H',3);
        characterValues.put('D',2);
        characterValues.put('C',1);
        return characterValues;
    }
}
