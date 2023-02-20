package Exercises8_IteratorsAndComparators.P06StrategyPattern;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Comparator<Person> nameComparator = new PersonNameComparator();
        Set<Person> personListByName = new TreeSet<>(nameComparator);
        Comparator<Person> ageComparator = new PersonAgeComparator();
        Set<Person> personListByAge = new TreeSet<>(ageComparator);
        for (int i = 1; i <= n ; i++) {

            String input = scanner.nextLine();
            String [] inputArr =  input.split("\\s+");

            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);

            Person person = new Person(name,age);
            personListByAge.add(person);
            personListByName.add(person);
        }


        for (Person person : personListByName) {
            System.out.println(person);
        }

        for (Person person : personListByAge) {
            System.out.println(person);
        }
    }
}
