package Exercises8_IteratorsAndComparators.P06StrategyPattern;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {

        return Integer.compare(person1.getAge(),person2.getAge());
    }
}
