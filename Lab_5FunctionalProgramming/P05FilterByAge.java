package Lab_5FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05FilterByAge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int peoplesCount = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> peopleMap = new LinkedHashMap<>();

        for (int i = 1; i <= peoplesCount; i++) {

            String [] currentLine = scanner.nextLine().split(", ");

            String name = currentLine[0];
            int age = Integer.parseInt(currentLine[1]);

            peopleMap.put(name,age);
        }

        String comparing = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printingFormat = scanner.nextLine();

        BiPredicate<Integer,Integer> filterByAge;
        if (comparing.equals("younger")){

            filterByAge = (personAge,age) -> personAge <= age;
        }else {

            filterByAge = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String,Integer>> printer;
        if (printingFormat.equals("name")){
            
            printer = person -> System.out.println(person.getKey());
        } else if (printingFormat.equals("age")) {
            
            printer = person -> System.out.println(person.getValue());
        } else {

            printer = person -> System.out.printf("%s - %d%n",person.getKey(),person.getValue());
        }
        peopleMap.entrySet().stream()
                .filter(person -> filterByAge.test(person.getValue(),ageLimit))
                .forEach(printer);

    }
}
