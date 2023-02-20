package ClassesExercises.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat{
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){

        if (this.data.size() < this.capacity){
            this.data.add(elephant);
        }
    }

    public boolean remove(String name){

        for (Elephant elephant : this.data) {

            if (elephant.getName().equals(name)){
                return this.data.remove(elephant);
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom){

        Elephant elephant = null;
        for (Elephant currentElephant : data) {

            if (currentElephant.getRetireFrom().equals(retiredFrom)){
                elephant = currentElephant;
            }
        }
        return elephant;
    }

    public Elephant getOldestElephant(){

        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants(){

        return this.data.size();
    }

    public String getReport(){

        StringBuilder builder = new StringBuilder();

        builder.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant elephant : data) {
            builder.append(String.format("%s came from: %s",elephant.getName(),elephant.getRetireFrom()));
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
