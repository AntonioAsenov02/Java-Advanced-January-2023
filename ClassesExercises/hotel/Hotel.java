package ClassesExercises.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){

        if (roster.size() < capacity){
            roster.add(person);
        }
    }

    public boolean remove(String name){

        for (Person person : roster) {
            if (person.getName().equals(name)){
                return roster.remove(person);
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown){

        Person person = null;
        for (Person currentPerson : roster) {
            if (currentPerson.getName().equals(name) && currentPerson.getHometown().equals(hometown)){
                person = currentPerson;
            }
        }
        return person;
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("The people in the ClassesExercises.hotel %s are:%n",this.name));

        for (Person person : roster) {
            builder.append(person).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
