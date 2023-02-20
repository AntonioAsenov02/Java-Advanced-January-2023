package Exercises8_IteratorsAndComparators.P06StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {

        int result = Integer.compare(person1.getName().length(),person2.getName().length());

        if (result == 0){
            for (int i = 0; i < person1.getName().length(); i++) {
                result = Character.compare(person1.getName().charAt(i),person2.getName().charAt(i));

                if (result == 0){
                    result = Character.compare(person1.getName().charAt(i),person2.getName().charAt(i));
                }else {
                    break;
                }
            }
        }

        return result;
    }
}
