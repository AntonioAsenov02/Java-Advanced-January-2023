package RealExam;

import java.util.*;
import java.util.stream.Collectors;

public class P02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> textiles = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> medicaments = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        int patch = 30;
        int bandage = 40;
        int medKit = 100;
        int patchCount = 0;
        int bandageCount = 0;
        int medKitCount = 0;

        while (!textiles.isEmpty() && !medicaments.isEmpty()){

            if (textiles.getFirst() + medicaments.peek() == patch){
                textiles.removeFirst();
                medicaments.pop();
                patchCount++;
            } else if (textiles.getFirst() + medicaments.peek() == bandage) {
                textiles.removeFirst();
                medicaments.pop();
                bandageCount++;
            } else if (textiles.getFirst() + medicaments.peek() == medKit) {
                textiles.removeFirst();
                medicaments.pop();
                medKitCount++;
            }else if (textiles.getFirst() + medicaments.peek() > medKit){
                int remainingSum = (textiles.getFirst() + medicaments.peek()) - medKit;
                textiles.removeFirst();
                medicaments.pop();
                int nextElement = medicaments.pop();
                medKitCount++;
                medicaments.push(nextElement + remainingSum);
            }else {
                textiles.removeFirst();
                int currentSum = medicaments.pop() + 10;
                medicaments.push(currentSum);
            }
        }

        Map<String,Integer> healingItems = new TreeMap<>();
        if (patchCount >= 1){
            healingItems.put("Patch",patchCount);
        } if(bandageCount >= 1){
            healingItems.put("Bandage",bandageCount);
        }if (medKitCount >= 1){
            healingItems.put("MedKit",medKitCount);
        }

        if (textiles.isEmpty() && medicaments.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }

        healingItems.entrySet().stream().sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        if (!textiles.isEmpty()){
            String collect = textiles.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Textiles left: %s%n",collect);
        } else if (!medicaments.isEmpty()) {
            Collections.reverse(medicaments);
            String collect = medicaments.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Medicaments left: %s%n",collect);
        }
    }
}
