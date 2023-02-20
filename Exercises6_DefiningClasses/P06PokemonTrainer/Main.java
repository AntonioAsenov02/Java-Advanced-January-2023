package Exercises6_DefiningClasses.P06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<Pokemon>> trainersList = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {

            String[] inputArr = input.split("\\s+");

            Pokemon pokemon = new Pokemon(inputArr[1], inputArr[2], Integer.parseInt(inputArr[3]));
            trainersList.putIfAbsent(inputArr[0], new ArrayList<>());
            trainersList.get(inputArr[0]).add(pokemon);

            input = scanner.nextLine();
        }

        List<Trainer> trainerList = trainersList.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());


        String command = scanner.nextLine();

        while (!command.equals("End")) {

            for (Trainer trainer : trainerList) {

                trainer.commandExecuting(command);
            }
            command = scanner.next();

        }

        trainerList.stream()
                .sorted(Comparator.comparing(Trainer::getBadgesCount).reversed())
                .forEach(System.out::println);
    }
}

