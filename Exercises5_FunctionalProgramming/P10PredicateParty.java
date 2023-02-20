package Exercises5_FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());


        String input = scanner.nextLine();
        while (!input.equals("Party!")) {

            Predicate<String> predicate = null;

            String criteria = input.split("\\s+")[2];


            if (input.contains("Length")) {

                predicate = x -> x.length() == Integer.parseInt(criteria);
            } else if (input.contains("Starts")){

                predicate = x -> x.startsWith(criteria);
            } else if (input.contains("Ends")){

                predicate = x -> x.endsWith(criteria);
            }

            if (input.contains("Remove")) {

                ArrayList<String> toRemove = new ArrayList<>();

                for (String name : namesList) {

                    if (predicate.test(name)){
                        toRemove.add(name);
                    }
                }
                namesList.removeAll(toRemove);
            } else if (input.contains("Double")) {

                ArrayList<String> toAdd = new ArrayList<>();

                for (String name : namesList) {

                    if (predicate.test(name)){
                        toAdd.add(name);
                    }
                }
                namesList.addAll(toAdd);
            }

            input = scanner.nextLine();
        }

        if (namesList.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.println(namesList.stream()
                    .sorted()
                    .collect(Collectors.toCollection(ArrayList::new))
                    .toString()
                    .replaceAll("([\\[\\]])","") + " are going to the party!");
        }
    }
}
