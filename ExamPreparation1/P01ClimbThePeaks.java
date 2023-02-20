package ExamPreparation1;

import java.util.*;
import java.util.stream.Collectors;

public class P01ClimbThePeaks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> peaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol",
                "Polezhan", "Kamenitza"));
        Map<String,Integer> peaksLevels = new LinkedHashMap<>(Map.of("Vihren",80,"Kutelo",90,
                "Banski Suhodol",100,"Polezhan",60,"Kamenitza",70));

        List<String> conqueredPeaks = new ArrayList<>();

        ArrayDeque<Integer> food = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stamina = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        while(!peaksLevels.isEmpty() && !food.isEmpty() && !stamina.isEmpty()){

            String currentPeak = peaks.getFirst();

            if (food.getLast() + stamina.getFirst() >= peaksLevels.get(currentPeak)){

                food.removeLast();
                stamina.removeFirst();
                peaks.remove(currentPeak);
                peaksLevels.remove(currentPeak);
                conqueredPeaks.add(currentPeak);
            }else {
                food.removeLast();
                stamina.removeFirst();
            }
        }

        if (peaksLevels.isEmpty()){

            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            for (String peak : conqueredPeaks) {

                System.out.println(peak);
            }
        }else {

            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if (!conqueredPeaks.isEmpty()){

                System.out.println("Conquered peaks:");
                for (String peak : conqueredPeaks) {

                    System.out.println(peak);
                }
            }

        }
    }
}
