package Exercises8_IteratorsAndComparators.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> list = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){

            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            String town = input.split("\\s+")[2];

            Person person = new Person(name,age,town);
            list.add(person);
            input = scanner.nextLine();
        }

        int countAll = list.size();
        int countEqual = 0;
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person personToCompare = list.get(index);
        list.remove(personToCompare);
        for (Person person : list) {
            if (personToCompare.compareTo(person) == 0){
                countEqual++;
            }
        }

        if (countEqual == 0){

            System.out.println("No matches");
        }else {

            System.out.printf("%d %d %d",countEqual + 1,countAll - (countEqual + 1),countAll);
        }
    }
}
