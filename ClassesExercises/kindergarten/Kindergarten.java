package ClassesExercises.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){

        if (registry.size() < this.capacity){
            return registry.add(child);
        }
        return false;
    }

    public boolean removeChild(String firstName){

        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)){
                return registry.remove(child);
            }
        }
        return false;
    }
    public int getChildrenCount(){
        return registry.size();
    }

    public Child getChild(String firstName){

        Child child = null;

        for (Child currentChild : registry) {
            if (currentChild.getFirstName().equals(firstName)){
                child = currentChild;
            }
        }
        return child;
    }

    public String registryReport(){
        registry.sort(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Registered children in %s:%n",this.name));

        for (Child child : registry) {
            builder.append(child).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
