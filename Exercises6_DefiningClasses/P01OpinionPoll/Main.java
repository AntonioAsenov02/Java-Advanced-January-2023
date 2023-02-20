package Exercises6_DefiningClasses.P01OpinionPoll;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {

            String input = scanner.nextLine();

            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            Person person = new Person(name,age);

            if (age > 30){

                personList.add(person);
            }
        }

        personList.sort(Comparator.comparing(person -> person.getName()));

        for (Person person : personList) {

            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
