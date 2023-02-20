package ExamPreparation5;

import java.util.*;
import java.util.stream.Collectors;

public class P01BlackSmith {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Queue<Integer> steel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> carbon = new Stack<>();
        for (String s : scanner.nextLine().split("\\s+")) {
            Integer parseInt = Integer.parseInt(s);
            carbon.add(parseInt);
        }

        int gladius = 70;
        int shamshir = 80;
        int katana = 90;
        int sabre = 110;

        int gladiusCount = 0;
        int shamshirCount = 0;
        int katanaCount = 0;
        int sabreCount = 0;
        Map<String,Integer> swordsForged = new TreeMap<>();

        while (!steel.isEmpty() && !carbon.isEmpty()){

            if (steel.peek() + carbon.peek() == gladius){

                steel.poll();
                carbon.pop();
                gladiusCount++;
                swordsForged.put("Gladius",gladiusCount);
            }else if (steel.peek() + carbon.peek() == shamshir){

                steel.poll();
                carbon.pop();
                shamshirCount++;
                swordsForged.put("Shamshir",shamshirCount);
            } else if (steel.peek() + carbon.peek() == katana) {

                steel.poll();
                carbon.pop();
                katanaCount++;
                swordsForged.put("Katana",katanaCount);
            } else if (steel.peek() + carbon.peek() == sabre) {

                steel.poll();
                carbon.pop();
                sabreCount++;
                swordsForged.put("Sabre",sabreCount);
            }else {

                steel.poll();
                int currentCarbon = carbon.peek();
                carbon.pop();
                carbon.push(currentCarbon + 5);
            }
        }

        int totalNumberSwords = gladiusCount + shamshirCount + katanaCount + sabreCount;
        if (swordsForged.isEmpty()){
            System.out.println("You did not have enough resources to forge a sword.");
        }else {
            System.out.printf("You have forged %d swords.%n",totalNumberSwords);
        }

        if (steel.isEmpty()){
            System.out.println("Steel left: none");
        }else {

            String collect = steel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Steel left: %s%n",collect);

        }

        if (carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else {

            Collections.reverse(carbon);
            String collect = carbon.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Carbon left: %s%n",collect);
        }

        for (Map.Entry<String, Integer> entry : swordsForged.entrySet()) {

            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
    }
}
